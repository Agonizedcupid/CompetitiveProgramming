package TreeBasics;

import java.util.Vector;

public class Fundamental {

    //it will print the parent node of any child node:
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

}
