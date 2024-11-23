/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package citygraph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;


/**
 *
 * @author 90551
 */
public class Options {
  
    public Hash<String> hashtable;
    public Graph graph;

    public Options(Graph graph, Hash hashtable) {
        this.graph = graph;
        this.hashtable = hashtable;
    }

    public boolean isThereAPath(String v1, String v2) {
        int indexV1 = hashtable.hash(v1);
        int indexV2 = hashtable.hash(v2);

        if (indexV1 == -1 || indexV2 == -1) {
            System.out.println("Invalid vertices");
            return false;
        }

        boolean[] visited = new boolean[graph.numV];

        Queue queue = new Queue();
        queue.enqueue(indexV1);

        while (!queue.isEmpty()) {
            int current = queue.dequeue();

            if (current == indexV2) {
                return true; // Path found
            }

            visited[current] = true;

            for (int i = 0; i < graph.numV; i++) {
                if (graph.edges[current][i] != 0 && !visited[i]) {
                    queue.enqueue(i);
                }
            }
        }

        return false;


    }

    public String Neighbors(String v1) {
        String sonuc = "Neighbors of " + v1 + ": ";

        int v1Int = hashtable.hash(v1);
        for (int i = 0; i < hashtable.M; i++) {
            if (graph.isAdjacent(v1Int, i)) {
                sonuc += hashtable.B(i) + " ";
            }
        }

        return sonuc;
    }

    public String HighestDegree() {
        int max = 0;
        String name = "Highest degree: ";
        for (int i = 0; i < hashtable.M; i++) {
            if (graph.degree(i) > max) {
                max = graph.degree(i);
                name =  hashtable.B(i) + "(" + max + ") ";
            }if(graph.degree(i)==max){
                name = hashtable.B(i) + "(" +  max + ")";
            }
        }
        return name;
    }

    public boolean IsThereACycle(String v1) {
        int v1Int = hashtable.hash(v1);
        if (graph.edges[v1Int][v1Int] != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsDirected() { //emin değilim yanlış
        boolean result = false;
        for (int i = 0; i < hashtable.M; i++) {
            for (int j = 0; j < hashtable.M; j++) {
                if (graph.edges[i][j] != 0 && graph.edges[j][i] == 0) {
                    return true;
                }
            }
        }

        return result;
    }

    public boolean AreTheyAdjacent(String v1, String v2) {
        int v1Int = hashtable.hash(v1);
        int v2Int = hashtable.hash(v2);
        if (graph.isAdjacent(v1Int, v2Int)) {
            return true;
        } else {
            return false;
        }
    }

    public int NumberOfVertices(String v1) {
        int sonuc = 0;
        int v1Int = hashtable.hash(v1);
        for (int i = 0; i < hashtable.M; i++) {
            if (graph.isAdjacent(v1Int, i))
                sonuc++;
        }

        return sonuc;
    }

    public void deneme(String filePath) {
        try {

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("->");

                if (!hashtable.contains(parts[0].trim())) {
                    hashtable.insert(parts[0].trim());


                }
                int from = hashtable.hash(parts[0].trim());

                String[] edges = parts[1].split(", ");

                for (String edge : edges) {
                    String[] edgeParts = edge.split(":");

                    if (!hashtable.contains(edgeParts[0].trim())) {

                        hashtable.insert(edgeParts[0].trim());
                    }

                    int to = hashtable.hash(edgeParts[0].trim());

                    String weightString = edgeParts[1].trim();
                    weightString = weightString.replaceAll("[^0-9]", ""); // Sadece sayıları bırak, diğer karakterleri temizle
                    int weight = Integer.parseInt(weightString);

                    System.out.print("*" + from + "-" + to + "-" + weight);
                    System.out.println("");
                    graph.addEdge(from, to, weight);

                }

            }
        } catch (IOException e) {

            e.printStackTrace();
        }
        System.out.println(hashtable.toString());
        System.out.println(graph.toString());
    }
   

    public void breadthFirstSearch(int startNode, int endNode) {
   Queue queue = new Queue();  // Use your custom queue
    boolean[] visited = new boolean[graph.numV];
    int[] path = new int[graph.numV];

    queue.enqueue(startNode);
    visited[startNode] = true;
    path[startNode] = -1;

    while (!queue.isEmpty()) {
        int currentNodeVertex = queue.dequeue();
        System.out.print("-" + hashtable.B(currentNodeVertex) + "-");
        if (currentNodeVertex == endNode) {
            return;
        }
        int[] neighbors = graph.getNeighbors(currentNodeVertex);
        for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                System.out.print("-" + graph.edges[currentNodeVertex][neighbor] + "-" + hashtable.B(neighbor));
               
                queue.enqueue(neighbor);

                visited[neighbor] = true;
                path[neighbor] = currentNodeVertex;  // Update the path
            }
        }
    }
        System.out.println("\nShortest Path to Each Node:");
        for (int i = 0; i < graph.numV; i++) {
            printShortestPath(path, startNode, i);
        }



    }
    public void shortpath(int startNode,int endNode){
     Queue queue = new Queue();  // Use your custom queue
    boolean[] visited = new boolean[graph.numV];
    int[] path = new int[graph.numV];

    queue.enqueue(startNode);
    visited[startNode] = true;
    path[startNode] = -1;

    while (!queue.isEmpty()) {
        int currentNodeVertex = queue.dequeue();
    
        if (currentNodeVertex == endNode) {
            printShortestPath(path, startNode, endNode);
        }
        int[] neighbors = graph.getNeighbors(currentNodeVertex);
        for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                
               
                queue.enqueue(neighbor);

                visited[neighbor] = true;
                path[neighbor] = currentNodeVertex;  // Update the path
            }
        }
    }

 
    }

    public void printShortestPath( int[] path , int startNode, int endNode) {
         System.out.print("Shortest path from " + hashtable.B(startNode) + " to " + hashtable.B(endNode) + ": ");
    LinkedList<Integer> shortestPath = new LinkedList<>();
    int at = endNode;
    while (at != -1) {
        shortestPath.insertFirst(at);
        at = path[at];
    }

    for (int i = 0; i < shortestPath.size; i++) {
        int node = shortestPath.get(i);
        System.out.print(hashtable.B(node) + " ");
    }
    System.out.println();
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public void DFS(int start, int end) {
        boolean[] visited = new boolean[graph.numV];
        Stack<Integer> stack = new Stack<>(graph.numV);
        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            visited[current] = true;
            System.out.print(hashtable.B(current) + " ");

            if (current == end) {
                System.out.println("\nPath found!");
                return;
            }

            for (int i = 0; i < graph.numV; i++) {
                if (graph.edges[current][i] > 0 && !visited[i]) {

                    stack.push(i);
                }
            }
        }

        System.out.println("\nPath not found!");
    }

    public int numberOfSimplePaths(String v1, String v2) {
        int source = hashtable.hash(v1);
        int destination = hashtable.hash(v2);
        if (source == -1 || destination == -1) {
            throw new IllegalArgumentException("Source or destination not found in the graph.");
        }


        return dfs(source, destination);
    }

    private int dfs(int start, int end) {
        boolean[] visited = new boolean[graph.numV];
        Stack<Integer> stack = new Stack<>(graph.numV);
        stack.push(start);
        int count =0 ;

        while (!stack.isEmpty()) {
            int current = stack.pop();
            visited[current] = true;


            if (current == end) {

                count++;

            }

            for (int i = 0; i < graph.numV; i++) {
                if (graph.edges[current][i] > 0 && !visited[i]) {
                    stack.push(i);
                }
            }
        }

return count;
    }
}


