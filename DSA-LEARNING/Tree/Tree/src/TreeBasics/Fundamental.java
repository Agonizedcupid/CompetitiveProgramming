package TreeBasics;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class Fundamental {

    //it will print the parent node of all child node:
    public void printParentOfEachNode(int root, Vector<Vector<Integer>> adjacentList, int parent) {
        if (parent == 0) {
            System.out.println(root + " -> Root");
        } else {
            System.out.println(root + " -> " + parent);
        }

        // Traversing the adjacentList(DFS)
        int listSize = adjacentList.get(root).size();
        for (int i = 0; i < listSize; i++) {
            int currentNode = adjacentList.get(root).get(i);
            if (currentNode != parent) { // it means if the node is not a root node:
                printParentOfEachNode(currentNode, adjacentList, root);
            }
        }
    }

    /**
     *  It will print the correct value but the problem is it will not print in right order
     */
    //It will print the Child node of each parent node:
    public void printChildOfEachNode(int rootNode, Vector<Vector<Integer>> adjacentList, int newParent) {

        if (newParent != 0) {
            System.out.println(rootNode + " -> "+newParent);
        }

        int listSize = adjacentList.get(rootNode).size();
        for (int i = 0; i < listSize; i++) {
            int currentChildren = adjacentList.get(rootNode).get(i);
            if (currentChildren != newParent) {
                printChildOfEachNode(currentChildren, adjacentList,rootNode);
            }
        }
    }

    /**
     *  Implementing using BFS
     */
    public void printChildOfEachNodeByBFS (int rootNode, Vector<Vector<Integer>> adjacentList) {
        //BFS
        //1. Need a QUEUE to keep the value
        Queue<Integer> dataContainer = new LinkedList<>();

        //2. Put the root node in the QUEUE
        dataContainer.add(rootNode);

        //3. Keep a boolean array to keep track of the node visited or not:
        boolean[] nodeVisited = new boolean[adjacentList.size()]; // By-default boolean variable is always false

//        //4. Mark the ROOT NODE as visited:
//        nodeVisited[rootNode] = true;

        //5. Iterate through all the elements of List:
        while (dataContainer.size() != 0) {
            int newVisitedNode = dataContainer.peek(); // just visited value
            dataContainer.remove();
            nodeVisited[newVisitedNode] = true;
            System.out.print(newVisitedNode + " -> "); // it will print the Parent Node:

            //iterate through all the child of this specific Root Node & make them visited:
            int childNodeSize = adjacentList.get(newVisitedNode).size();
            for (int index = 0; index < childNodeSize; index ++) {
                int currentChild = adjacentList.get(newVisitedNode).get(index);
                if (!nodeVisited[currentChild]) {
                    System.out.print(currentChild + ", ");
                    dataContainer.add(currentChild);
                }
            }
            System.out.println();
        }

    }

    // Print the leaf node of a tree:
    public void printLeafNode(int rootNode, Vector<Vector<Integer>> adjacentList) {
        int listSize = adjacentList.get(rootNode).size();
        if (listSize != 1) {
            int leafNode = adjacentList.get(rootNode).get(0);
            System.out.print(leafNode);
        } else {
            for (int i=0; i<listSize; i++) {
                int changedRoot = adjacentList.get(rootNode).get(i);
                System.out.println("Root: "+ adjacentList.get(changedRoot).size() + " -> "+changedRoot);
                printLeafNode(changedRoot, adjacentList);
            }
        }
        System.out.println();
    }

}
