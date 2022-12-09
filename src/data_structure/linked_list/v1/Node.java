package data_structure.linked_list.v1;

public class Node {

    private int data;
    private Node next = null;

    public Node(int data) {
        this.data = data;
    }

    public void append(int data) {
        Node end = new Node(data);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public void delete(int data) {
        Node n = this;
        while (n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
                continue;
            }
            n = n.next;
        }
    }

    public void retrieve() {
        Node n = this;
        while (n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }
}
