package data_structure.linked_list.v2;

public class LinkedList {

    private Node header;

    public LinkedList() {
        this.header = new Node();
    }

    public void append(int data) {
        Node end = new Node(data);
        Node n = header;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    void delete(int data) {
        Node n = header;
        while (n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
                continue;
            }
            n = n.next;
        }
    }

    public void retrieve() {
        Node n = header.next;
        while (n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }

    public void removeDups() {
        Node n = header;
        while (n.next != null) {
            Node r = n;
            while (r.next != null) {
                if (n.data == r.data) {
                    r.next = r.next.next;
                }
            }
        }
    }

    static class Node {
        private int data;
        private Node next = null;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }

    }
}
