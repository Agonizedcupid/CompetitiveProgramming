package CompleteBinaryTree;

public class CompleteBinaryTreeConstruct {

    public Node rootNode;

    static class Node {
        int value;
        Node leftChild, rightChild;

        public Node(int value) {
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    public boolean isValidCompleteBinaryTree(Node rootNode, int index, int totalNumberOfNodes) {
        if (rootNode == null) return true;

        if (index >= totalNumberOfNodes) return false;

        return (isValidCompleteBinaryTree(rootNode.leftChild, 2 * index + 1, totalNumberOfNodes)
                && isValidCompleteBinaryTree(rootNode.rightChild, 2 * index + 2, totalNumberOfNodes));
    }

    public int countNode(Node rootNode) {
        if (rootNode == null) return 0;
        return countNode(rootNode.leftChild) + countNode(rootNode.rightChild) + 1;
    }

}
