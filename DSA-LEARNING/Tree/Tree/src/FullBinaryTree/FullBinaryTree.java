package FullBinaryTree;

public class FullBinaryTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.rootNode = new Tree.Node(1);

        //Level 1:
        tree.rootNode.leftChild = new Tree.Node(2);
        tree.rootNode.rightChild = new Tree.Node(3);

        //Level 2:
        tree.rootNode.leftChild.leftChild = new Tree.Node(4);
        tree.rootNode.leftChild.rightChild = new Tree.Node(5);

        //Level 3:
        tree.rootNode.leftChild.rightChild.leftChild = new Tree.Node(6);
        tree.rootNode.leftChild.rightChild.rightChild = new Tree.Node(7);

        // It's not a Full Binary Tree if i  un comment this:
        //tree.rootNode.leftChild.rightChild.rightChild.rightChild = new Tree.Node(8);

        //checking the Tree is Full Binary Tree or not
        System.out.println(tree.isFullBinaryTree(tree.rootNode));
    }
}
