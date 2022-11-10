package PerfectBinaryTree;


public class PerfectBinaryTree {
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

        //checking the Tree is perfect Binary tree or not:
        System.out.println(tree.wrapperFunction(tree.rootNode));
    }
}
