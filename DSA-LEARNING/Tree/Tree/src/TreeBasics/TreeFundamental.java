package TreeBasics;

import java.util.Vector;

public class TreeFundamental {

    public static void main (String[] args) {
        int numberOfNodes = 7, root = 1;
        Vector<Vector<Integer>> adjacentList = new Vector<Vector<Integer>>();
        //creating empty list:
        for (int i=0; i<numberOfNodes + 1; i++) {
            adjacentList.add(new Vector<>());
        }

        //Making the TREE:
        adjacentList.get(1).add(2);
        adjacentList.get(2).add(1);

        adjacentList.get(1).add(3);
        adjacentList.get(3).add(1);

        adjacentList.get(1).add(4);
        adjacentList.get(4).add(1);

        adjacentList.get(2).add(5);
        adjacentList.get(5).add(2);

        adjacentList.get(2).add(6);
        adjacentList.get(6).add(2);

        adjacentList.get(4).add(7);
        adjacentList.get(7).add(4);

        //Print parent of all node:
        new Fundamental().printParentOfEachNode(root, adjacentList, 0);
    }
}
