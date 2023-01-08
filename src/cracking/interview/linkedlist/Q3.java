package cracking.interview.linkedlist;

public class Q3 {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.append(5);

        deleteNode(head.get(3));
        head.retrieve();
    }

    private static boolean deleteNode(Node node) {
        if (node == null || node.next == null) {
            return false;
        }

        Node next = node.next;
        node.data = next.data;
        node.next = next.next;
        return true;
    }

}
