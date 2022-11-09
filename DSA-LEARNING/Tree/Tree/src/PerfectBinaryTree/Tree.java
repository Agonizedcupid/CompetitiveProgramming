package PerfectBinaryTree;

public class Tree {

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
    public boolean isPerfectBinaryTree (Node rootNode) {
        if (rootNode == null) return true; // it satisfies No: 2
        if (rootNode.leftChild == null && rootNode.rightChild == null) return true; //it satisfies No. 2

        
    }
}
