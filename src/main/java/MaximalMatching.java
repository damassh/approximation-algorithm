public class MaximalMatching {

    int edge[][];
    private int numVertices;
    private int numEdges;

    // create the constructor
    public MaximalMatching(int v, int e) {
        numVertices = v;
        numEdges = e;
        edge = new int[numVertices][numVertices];
    }

    // add edge to the graph; u for head and v for tail
    void addEdge(int u, int v) {
        u -= 1;
        v -= 1;
        edge[u][v] = 1;
        edge[v][u] = 1;
    }

    Integer getMVC() {
        int mvc = 0;

        while (numEdges > 0) {
            for (int u = 0; u < numVertices; u++) {
                for (int v = 0; v < numVertices; v++) {
                    if (edge[u][v] == 1) {
                        mvc += 2;
                        for (int i = 0; i < numVertices; i++) {
                            if (edge[u][i] == 1) {
                                edge[u][i] = 0;
                                edge[i][u] = 0;
                                numEdges -= 2;
                            }

                            if (edge[v][i] == 1) {
                                edge[v][i] = 0;
                                edge[i][v] = 0;
                                numEdges -= 2;
                            }
                        }
                    }
                }
            }
        }
        return mvc;
    }
}
