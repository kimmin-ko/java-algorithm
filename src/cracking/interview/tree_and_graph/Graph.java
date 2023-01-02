package cracking.interview.tree_and_graph;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Graph {

    static class Node {
        private int data;
        private LinkedList<Node> adjacent;
        private boolean marked;

        public Node(int data) {
            this.data = data;
            this.adjacent = new LinkedList<>();
            this.marked = false;
        }

        public void mark() {
            this.marked = true;
        }
    }

    private Node[] nodes;

    public Graph(int size) {
        this.nodes = new Node[size];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }
    }

    public void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    public void dfs() {
        dfs(0);
    }

    public void dfs(int index) {
        Node root = nodes[index];
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        root.mark();

        while (!stack.isEmpty()) {
            Node r = stack.pop();
            for (Node n : r.adjacent) {
                if (!n.marked) {
                    stack.push(n);
                    n.mark();
                }
            }
            visit(r);
        }
    }

    public void bfs() {
        bfs(0);
    }

    public void bfs(int index) {
        Node root = nodes[index];
        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(root);
        root.mark();

        while (!queue.isEmpty()) {
            Node r = queue.pollFirst();
            for (Node n : r.adjacent) {
                if (!n.marked) {
                    queue.addLast(n);
                    n.mark();
                }
            }
            visit(r);
        }
    }

    public boolean search(int i1, int i2) {
        return search(nodes[i1], nodes[i2]);
    }

    private boolean search(Node start, Node end) {
        initMarks();

        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(start);
        start.mark();

        while (!queue.isEmpty()) {
            Node r = queue.pollFirst();
            if (r == end) {
                return true;
            }
            for (Node n : r.adjacent) {
                if (!n.marked) {
                    queue.addLast(n);
                    n.mark();
                }
            }
        }

        return false;
    }

    // private //
    private void visit(Node node) {
        System.out.print(node.data + " ");
    }

    private void initMarks() {
        for (Node node : this.nodes) {
            node.marked = false;
        }
    }
}
