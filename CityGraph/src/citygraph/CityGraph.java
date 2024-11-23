/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package citygraph;

import java.util.Scanner;

/**
 *
 * @author 90551
 */
public class CityGraph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);
        String pathName = "C:\\Users\\90551\\Downloads\\graph (1).txt";
        Hash hashtable = new Hash(57);
        Graph graph = new Graph(57);
        Options op = new Options(graph,hashtable);


        while (true){
            option();
            int option = scanner.nextInt();
            switch (option){
                case 1:
                    op.deneme(pathName);
                    break;
                case 2:
                    System.out.print("Enter vertex 1: ");
                    String v1 = scanner.next();
                    System.out.print("Enter vertex 2: ");
                    String v2 = scanner.next();
                   System.out.println("Is there a path: " + op.isThereAPath(v1, v2));

                    break;
                case 3:
                    System.out.print("Enter vertex 1: ");
                    String v3 = scanner.next();
                    System.out.print("Enter vertex 2: ");
                    String v4 = scanner.next();
                    op.breadthFirstSearch(hashtable.hash(v3),hashtable.hash(v4));

                    break;
                case 4:
                    System.out.print("Enter vertex 1: ");
                    String v5 = scanner.next();
                    System.out.print("Enter vertex 2: ");
                    String v6 = scanner.next();
                    op.DFS(hashtable.hash(v5),hashtable.hash(v6));

                    break;
                case 5:
                    System.out.print("Enter vertex 1: ");
                    String v7 = scanner.next();
                    System.out.print("Enter vertex 2: ");
                    String v8 = scanner.next();
                   op.shortpath(hashtable.hash(v7),hashtable.hash(v8));
                    break;
                case 6:
                    System.out.print("Enter vertex 1: ");
                    String v9 = scanner.next();
                    System.out.print("Enter vertex 2: ");
                    String v10 = scanner.next();
                    System.out.println(op.numberOfSimplePaths(v9,v10));
                    break;
                case 7:
                    System.out.println("Enter vertex: ");
                    String s1 = scanner.next();
                    System.out.println(op.Neighbors(s1));
                    break;
                case 8:
                    System.out.println("Highest degree: "+op.HighestDegree());
                    break;
                case 10:
                    System.out.println("Enter vertex 1: ");
                    String v101 = scanner.next();
                    System.out.println("Enter vertex 2: ");
                    String v102 = scanner.next();
                    System.out.println(op.AreTheyAdjacent(v101,v102));
                    break;
                case 9:
                    System.out.println("Is Directed: ");
                    System.out.println(op.IsDirected());
                    break;
                case 11:
                    System.out.println("Enter vertex: ");
                    String xd = scanner.next();
                    System.out.println("IsThereACycle: ");
                    System.out.println(op.IsThereACycle(xd));
                    break;
                case 12:
                    System.out.println("Enter vertex: ");
                    String WW = scanner.next();
                    System.out.println(op.NumberOfVertices(WW));
                    break;
                case 0:
                    System.exit(0);
                    break;
            }

        }

    }
    public static void option(){
        Scanner scn = new Scanner(System.in);
        System.out.println("1-Read Graph From File");
        System.out.println("2-Is There A Path");
        System.out.println("3-BFSFromTo");
        System.out.println("4-DFSFromTo");
        System.out.println("5-What Is Shortest Path?");
        System.out.println("6-Number Of Simple Paths");
        System.out.println("7-Neighbors");
        System.out.println("8-Highest Degree");
        System.out.println("9-Is Directed");
        System.out.println("10-Are They Adjacent");
        System.out.println("11-Is There A Cycle");
        System.out.println("12-Number Of Verticles In Component");
        System.out.println("0-EXIT");
        //nt option = scn.nextInt();
        //return option;
    }

}

    
