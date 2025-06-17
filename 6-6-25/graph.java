
   import java.util.ArrayList;

public class UndirectedGraph {
    private int[][] graph;
    private int vertices;

    public UndirectedGraph(int vertices) {
        this.vertices = vertices;
        graph = new int[vertices][vertices]; 
    }

    public void addEdge(int src, int dest) {
        if (isValid(src, dest)) {
            graph[src][dest] = 1;
            graph[dest][src] = 1;  
        } else {
            System.out.println("Invalid edge between " + src + " and " + dest);
        }
    }

    public void removeEdge(int src, int dest) {
        if (isValid(src, dest)) {
            graph[src][dest] = 0;
            graph[dest][src] = 0;  
        } else {
            System.out.println("Invalid edge between " + src + " and " + dest);
        }
    }

    private boolean isValid(int src, int dest) {
        return src >= 0 && src < vertices && dest >= 0 && dest < vertices && src != dest;
    }

    public void printGraph() {
        System.out.println("Adjacency matrix of undirected graph:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<Integer> getNeighbors(int node) {
        ArrayList<Integer> neighbors = new ArrayList<>();
        if (node < 0 || node >= vertices) {
            System.out.println("Invalid node " + node);
            return neighbors;
        }
        for (int i = 0; i < vertices; i++) {
            if (graph[node][i] == 1) {
                neighbors.add(i);
            }
        }
        return neighbors;
    }

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();

        System.out.println("Neighbors of node 1: " + graph.getNeighbors(1));

        graph.removeEdge(1, 4);
        System.out.println("After removing edge between 1 and 4:");
        graph.printGraph();
    }
}


