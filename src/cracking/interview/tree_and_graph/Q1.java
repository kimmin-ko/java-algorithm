package cracking.interview.tree_and_graph;

public class Q1 {

    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
//        graph.addEdge(1, 3);
//        graph.addEdge(2, 4);
//        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 8);

//        graph.dfs();
//        graph.bfs();
        boolean answer = graph.search(0, 8);
        System.out.println("answer = " + answer);
    }
}
