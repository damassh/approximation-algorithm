import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class VertexSupportAlgorithm {

    private int numVertices;
    private int numEdges;
    private LinkedList<Integer> adjacenyList[];

    public VertexSupportAlgorithm(int v, int e) {
        numVertices = v;
        numEdges = e;
        adjacenyList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            this.adjacenyList[i] = new LinkedList<>();
        }
    }

    // add edge to the graph; u for head and v for tail
    void addEdge(int u, int v) {
        adjacenyList[u].add(v);
        adjacenyList[v].add(u);
    }

    Integer getMVC() {
        List<Integer> vectorCover = new ArrayList<>();

        while (numEdges > 0) {
            int degree[] = new int[numVertices];
            int supportVector[] = new int[numVertices];

            // Calculate each node's degree
            for (int i = 0; i < numVertices; i++) {
                degree[i] = adjacenyList[i].size();
            }

            // Calculate support vector
            int maxSupportVector = 0;
            int k = 1;
            int t = 0;
            for (int i = 1; i < numVertices; i++) {
                for (int j: adjacenyList[i]) {
                    supportVector[i] += degree[j];
                }
                // get the maximum support
                if (supportVector[i] > maxSupportVector) {
                    maxSupportVector = supportVector[i];
                    t = i;
                } else if (maxSupportVector == supportVector[i] && degree[i-k] <= degree[i]) {
                    maxSupportVector = supportVector[i];
                    t = i;

                } else if (maxSupportVector == supportVector[i] && degree[i-k] > degree[i]) {
                    maxSupportVector = supportVector[i - k];
                    t = i - k;
                }
                k++;
            }

            // add the vertex with the maximum support to vector cover
            vectorCover.add(t);

            // remove the neighbors of the nodes of the vertex with maximum support
            numEdges -= adjacenyList[t].size();
            adjacenyList[t].clear();

            for (int i = 1; i < numVertices; i++) {
                if (adjacenyList[i].contains(Integer.valueOf(t))) {
                    adjacenyList[i].remove(Integer.valueOf(t));
                }
            }
        }
        return vectorCover.size();
    }
}
