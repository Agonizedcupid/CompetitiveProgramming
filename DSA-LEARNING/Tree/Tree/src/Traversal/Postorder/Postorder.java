package Traversal.Postorder;


import java.util.Stack;

public class Postorder {

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
        //tree.postOrderTraversal(tree.root);
        //Recursive Approach
        tree.postorderIterativeApproach(tree.root);
    }

    static class BinaryTree {
        Node root;

        BinaryTree() {
            root = null;
        }

        void postOrderTraversal(Node root) {
            if (root == null) return;
            postOrderTraversal(root.leftNode);
            postOrderTraversal(root.rightNode);
            System.out.print(root.value + " ");
        }

        void postorderIterativeApproach(Node root) {
            if (root == null) return;
            Stack<Node> stack = new Stack<>();

            while (true) {
                while (root != null) {
                    stack.push(root);
                    stack.push(root);
                    root = root.leftNode;
                }

                if (stack.isEmpty()) return;
                root = stack.pop();

                if (!stack.isEmpty() && root == stack.peek()) {
                    root = root.rightNode;
                } else {
                    System.out.print(root.value + " ");
                    root = null;
                }
            }
        }

    }

    static class Node {
        int value;
        Node leftNode, rightNode;

        Node(int value) {
            this.value = value;
            leftNode = rightNode = null;
        }
    }
}
