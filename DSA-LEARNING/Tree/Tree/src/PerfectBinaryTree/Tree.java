package PerfectBinaryTree;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Tree {

    public Node rootNode;
    //Representation of a tree:
    static class Node {
        int value;
        Node leftChild, rightChild;
        public Node (int value) {
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    //  A tree is a prefect binary tree if below conditions are satisfied:
    // 1. A node has exactly 2 child
    // 2. leaf node should be in same orders
    private boolean isPerfectBinaryTree (Node rootNode, int depth, int level) {
        if (rootNode == null) return true; // it satisfies No: 2
        if (rootNode.leftChild == null && rootNode.rightChild == null) return depth == level + 1; //it satisfies No. 2

        // if any node like left or right is null then it's not a perfectBinaryTree:
        if (rootNode.leftChild == null || rootNode.rightChild == null) return false;

        // Now traverse the while Tree:
        return isPerfectBinaryTree (rootNode.leftChild, depth, level + 1) && isPerfectBinaryTree(rootNode.rightChild, depth, level + 1);
    }

    private int countLevelAsDepth (Node rootNode) {
        int depth = 0;
        while (rootNode != null) {
            depth ++;
            rootNode = rootNode.leftChild;
        }

        String s = "sdgasdfg";
        Map<Integer, Integer> contain = new HashMap<>();
        contain.put(contain.get(s.charAt(0)),contain.getOrDefault(s.charAt(0),0) + 1);
        return depth;


    }

    public boolean wrapperFunction (Node rootNode) {
        return isPerfectBinaryTree(rootNode, countLevelAsDepth(rootNode), 0);
    }
}
