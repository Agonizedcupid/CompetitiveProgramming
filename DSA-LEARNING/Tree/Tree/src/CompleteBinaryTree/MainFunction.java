package CompleteBinaryTree;

public class MainFunction {
    public static void main(String[] args) {
        CompleteBinaryTreeConstruct tree = new CompleteBinaryTreeConstruct();
        tree.rootNode = new CompleteBinaryTreeConstruct.Node(1);

        tree.rootNode.leftChild = new CompleteBinaryTreeConstruct.Node(2);
        tree.rootNode.rightChild = new CompleteBinaryTreeConstruct.Node(3);

        tree.rootNode.leftChild.leftChild = new CompleteBinaryTreeConstruct.Node(4);
        tree.rootNode.leftChild.rightChild = new CompleteBinaryTreeConstruct.Node(5);

        tree.rootNode.rightChild.leftChild = new CompleteBinaryTreeConstruct.Node(6);

        int numberOfNodes = tree.countNode(tree.rootNode);
        System.out.println("Number of Nodes: " + numberOfNodes);

        System.out.println(tree.isValidCompleteBinaryTree(tree.rootNode, 0, numberOfNodes));
    }
}
