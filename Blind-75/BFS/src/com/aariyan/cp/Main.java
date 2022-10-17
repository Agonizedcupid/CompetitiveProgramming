package com.aariyan.cp;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    private int numberOfVertices;
    private LinkedList<Integer> adjacencyList[]; //Adjacency list to store all the vertex:

    //It will represent a graph:
    public Main(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        adjacencyList = new LinkedList[numberOfVertices];
        //Initiating all the list as empty or null (Could be -1 as well):
        for (int i = 0; i < numberOfVertices; ++i) {
            adjacencyList[i] = new LinkedList();
        }
    }

    //Adding vertices on the graph:
    void addEdge(int startVertex, int toBeConnectedVertex) {
        adjacencyList[startVertex].add(toBeConnectedVertex);
    }

    //Now, Traverse the graph using BFS:
    void BFS (int sourceVertex) {
        //boolean array to track the visited or non-visited node/vertex:
        boolean[] isVisited = new boolean[numberOfVertices];
        //Create a queue to push the non-visited element and pop after visit:
        LinkedList<Integer> queue = new LinkedList<Integer>();

        //Now, Visit the source (Current) node/vertex and enqueue:
        isVisited[sourceVertex] = true;
        queue.add(sourceVertex);

        while (queue.size() != 0) {
            //removing from Queue as it's visited:
            sourceVertex = queue.poll();
            //Printing the Visited & removed node from Queue:
            System.out.print(sourceVertex + " ");

            // Making an iterator of all the adjacent List:
            Iterator<Integer> iterator = adjacencyList[sourceVertex].listIterator();
            //Traversing whole adjacent list through iterator:
            while(iterator.hasNext()) {
                int nextVisited = iterator.next();
                if (!isVisited[nextVisited]) {
                    isVisited[nextVisited] = true;
                    queue.add(nextVisited);
                }
            }

        }
        System.out.println();
    }

    public static void main(String[] args) {
        Main graph = new Main(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        graph.BFS(2);
    }
}
