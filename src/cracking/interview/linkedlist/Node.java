package cracking.interview.linkedlist;

public class Node {

    Node next = null;
    int data;

    public Node(int d) {
        this.data = d;
    }

    void append(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    void retrieve() {
        Node n = this;
        while (n != null) {
            System.out.print(n.data + ", ");
            n = n.next;
        }
    }

    public Node get(int data) {
        Node n = this;
        while (n != null) {
            if (n.data == data) {
                return n;
            }
            n = n.next;
        }
        return null;
    }
}
