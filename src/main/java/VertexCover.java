import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class VertexCover {

    public static final String DIRECTORY = "instanceSet";

    public static void runGreedyAlgorithm(String filename) throws IOException {
        String instanceSet = getFileName(filename);

        long startTime = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        String [] reader = br.readLine().split("\\s+");
        String line;

        int numVertices = Integer.parseInt(reader[2]);
        int numEdges = Integer.parseInt(reader[3]);

        GreedyAlgorithm ga = new GreedyAlgorithm(numVertices + 1);
        while ((line = br.readLine()) != null) {
            reader = line.split("\\s+");
            ga.addEdge(Integer.parseInt(reader[1]), Integer.parseInt(reader[2]));
        }

        int mvc = ga.getMVC();
        long executionTime = (System.currentTimeMillis() - startTime);
        print(instanceSet, numVertices, numEdges, mvc, executionTime);
        br.close();
    }

    public static void runMaximalMatching(String filename) throws IOException {
        String instanceSet = getFileName(filename);

        long startTime = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        String [] reader = br.readLine().split("\\s+");
        String line;

        int numVertices = Integer.parseInt(reader[2]);
        int numEdges = Integer.parseInt(reader[3]);

        MaximalMatching mm = new MaximalMatching(numVertices, numEdges);
        while ((line = br.readLine()) != null) {
            reader = line.split("\\s+");
            mm.addEdge(Integer.parseInt(reader[1]), Integer.parseInt(reader[2]));
        }

        int mvc = mm.getMVC();
        long executionTime = (System.currentTimeMillis() - startTime);
        print(instanceSet, numVertices, numEdges, mvc, executionTime);
        br.close();

    } public static void runVSA(String filename) throws IOException {
        String instanceSet = getFileName(filename);
        long startTime = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        String [] reader = br.readLine().split("\\s+");
        String line;

        int numVertices = Integer.parseInt(reader[2]);
        int numEdges = Integer.parseInt(reader[3]);

        VertexSupportAlgorithm vsa = new VertexSupportAlgorithm(numVertices + 1, numEdges);
        while ((line = br.readLine()) != null) {
            reader = line.split("\\s+");
            vsa.addEdge(Integer.parseInt(reader[1]), Integer.parseInt(reader[2]));
        }

        int mvc = vsa.getMVC();
        long executionTime = (System.currentTimeMillis() - startTime);
        print(instanceSet, numVertices, numEdges, mvc, executionTime);
        br.close();

    }

    public static String getFileName(String filename) {
        String[] f = filename.split("/");
        return String.valueOf(f[f.length - 1]);
    }

    public static void print(String instanceSet, Integer numVertices, Integer numEdges,
                             Integer mvc, long executionTime) {
        System.out.println(instanceSet + "\t\t\t " + numVertices + "\t\t\t\t " + numEdges
                + "\t\t\t" + mvc + "\t\t\t " + executionTime);
    }
    public static void main(String[] args) throws IOException {
        ReadFiles readFiles = new ReadFiles();
        List<String> files = readFiles.getFilesFromDirectory(DIRECTORY);
        String [] algorithms = {"greedy", "maximalMatching", "vsa"};

        for (String algorithm: algorithms) {
            System.out.println("Algorithm: " + algorithm);
            System.out.println("Instance Set \t\t\t Vertices Num \t\t Edges Num \t\tMVC \t\t Execution Time (ms)");
            System.out.println("---------------------------------------------------------------------------------------");
            for (String file: files) {
                if (algorithm.equals("greedy")) {
                    runGreedyAlgorithm(file);
                } else if (algorithm.equals("maximalMatching")) {
                    runMaximalMatching(file);
                } else if (algorithm.equals("vsa")){
                    runVSA(file);
                }
            }
            System.out.println("---------------------------------------------------------------------------------------");
        }

    }
}
