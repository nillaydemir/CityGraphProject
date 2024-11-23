/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package citygraph;

/**
 *
 * @author 90551
 */
public class Graph {
     int edges[][] ; // can be anything, but int vertices handy
    // can be double if there are double weigths
    int numV ;
    int numE;
    public int[][] adjacencyMatrix ;



    public Graph(int V) {
        this.numV = V;
        edges = new int[V][V];
        this.adjacencyMatrix = new int[numV][numV];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                edges[i][j] = 0;
            }
        }
    }

    public void addEdge(int from, int to, int weight) {
        edges[from][to] = weight;
        adjacencyMatrix[from][to] =1;

    }

    public boolean isAdjacent(int v1, int v2) {
        return (edges[v1][v2] != 0);
    }

    public int degree(int v) {
        int degree = 0;
        for (int i = 0; i < numV; i++) {
            degree += edges[v][i];
        }
        return degree;
    }

    public String toString() {
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < numV; i++) {
            for (int j = 0; j < numV; j++) {
                s.append(edges[i][j]+" ");
            }
            s.append("\n");
        }
        return s.toString();
    }


    public int[] getNeighbors(int vertex) {
        int[] neighbors = new int[numV];
        int count = 0;
        for (int i = 0; i < numV; i++) {
            if (adjacencyMatrix[vertex][i] == 1) {
                neighbors[count++] = i;
            }
        }
        return neighbors;
    }


}
