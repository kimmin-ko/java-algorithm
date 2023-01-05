package cracking.interview.tree_and_graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class Q3 {

    public static void main(String[] args) {
        Tree tree = new Tree(10);
        ArrayList<LinkedList<Tree.Node>> lists = tree.bstToList();
        tree.printList(lists);
    }
}
