package Traversal.Preorder;

public class PreorderTraversal {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.leftSubTree = new Node(12);
        tree.root.leftSubTree.leftSubTree = new Node(5);
        tree.root.leftSubTree.rightSubTree = new Node(6);
        tree.root.rightSubTree = new Node(9);

        //Call the traversal:
        tree.preOrderTraversal(tree.root);
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void preOrderTraversal(Node root) {
        if (root == null) return;

        //Printing the Root:
        System.out.print(root.value + " ");
        //Traversing through the Left SubTree
        preOrderTraversal(root.leftSubTree);
        //Traversing through the RightSub Tree
        preOrderTraversal(root.rightSubTree);
    }
}

class Node {
    int value;

    Node leftSubTree;
    Node rightSubTree;

    public Node(int value) {
        this.value = value;
        leftSubTree = rightSubTree = null;
    }

}

