package FullBinaryTree;

public class Tree {

    public Node rootNode;

    //Representation of a tree
    static class Node {
        int value;
        Node leftChild, rightChild;

        public Node(int value) {
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    //Full binary tree means : it has two conditions:
    // 1. every node has either max 2 children or
    // 2. no children:
    public boolean isFullBinaryTree (Node root) {
        //step 1: root == null means Full Binary Tree(satisfies No: 2)
        if (root == null) return true;

        //step 2: if the left & right child is null means Full Binary Tree (satisfies No: 2)
        if (root.leftChild == null && root.rightChild == null) return true;

        // step 3: step 1 & 2 are base conditions: Now check every node for two conditions explain above recursively:
        if (root.leftChild != null && root.rightChild != null) {
            return isFullBinaryTree(root.leftChild) && isFullBinaryTree(root.rightChild);
        }
        // if it's not a full binary tree:
        return false;

    }
}
