package cracking.interview.tree_and_graph;

public class Q12 {

    public static void main(String[] args) {
        Tree tree = new Tree(10);
        int answer = tree.countPathsWithSum(3);
        System.out.println("answer = " + answer);
    }
}
