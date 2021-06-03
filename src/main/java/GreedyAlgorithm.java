import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class GreedyAlgorithm {

    private int numVertices;
    private LinkedList<Integer> adjacenyList[];
    private List<Integer> vertexCovered;

    // create the constructor
    public GreedyAlgorithm(int v) {
        numVertices = v;
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
        vertexCovered = new ArrayList<>();
        int mvc = 0;
        int maxDegree, next;

        while (true) {
            int degree[] = new int[numVertices];
            next = 0;
            maxDegree = 0;

            // Calculate each node's degree
            for (int i = 0; i < numVertices; i++) {
                degree[i] = adjacenyList[i].size();
            }

            // Select the maximal degree in Graph
            for (int i = 0; i < numVertices; i++) {
                if (degree[i] > maxDegree) {
                    maxDegree = degree[i];
                    next = i;
                }
            }

            // for every max degree, add 1 to max vector cover
            // the node with max degree will be removed from the adjaceny list
            if (maxDegree > 0) {
                mvc += 1;
                vertexCovered.add(next);
                adjacenyList[next].clear();

                for (int i = 0; i < numVertices; i++) {
                    adjacenyList[i].remove(Integer.valueOf(next));
                }
            } else {
                // all edges are covered and graph is empty
                // return the max vertex cover
                return mvc;
            }
        }
    }
}
