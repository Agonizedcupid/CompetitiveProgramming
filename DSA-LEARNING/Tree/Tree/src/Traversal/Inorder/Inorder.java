package Traversal.Inorder;

import java.util.Stack;

public class Inorder {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.leftNode = new Node(12);
        tree.root.rightNode = new Node(9);
        tree.root.leftNode.leftNode = new Node(5);
        tree.root.leftNode.rightNode = new Node(6);

        //Recursive Approach
        //tree.inOrderTraversal(tree.root);
        //Iterative Approach
        tree.inOrderIterativeApproach(tree.root);
    }
}

/*
 *                  1    -----> Node class representing Every Node of Tree (Ex. 1 - 12 - 5 - 6 - 9)
 *                /   \
 *              12      9
 *            /    \
 *          5        6
 *
 */
class BinaryTree {
    //We need a root for the tree.
    Node root;

    BinaryTree() {
        root = null;
    }

    //InOrder Traversal means = Left - Root - Right
    void inOrderTraversal(Node node) {
        if (node == null) return;

        //Traverse Left
        inOrderTraversal(node.leftNode);
        //Traverse Root:
        System.out.print(node.value + " --> ");
        //Traverse Right:
        inOrderTraversal(node.rightNode);
    }

    public void inOrderIterativeApproach(Node root) {
        if (root == null) return;

        Stack<Node> stack = new Stack<>();
        Node currentNode = root;
        while (currentNode != null || stack.size() > 0) {
            //First visit the left subtree
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.leftNode;
            }

            currentNode = stack.pop();
            System.out.print(currentNode.value + " ");

            currentNode = currentNode.rightNode;

        }
    }

}

// This implement the Node of a tree as well as left & right subtree pointer.
class Node {
    int value;
    Node leftNode, rightNode;

    Node(int value) {
        this.value = value;
        leftNode = rightNode = null;
    }
}
