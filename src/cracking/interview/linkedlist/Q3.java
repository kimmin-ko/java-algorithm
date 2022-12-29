package cracking.interview.linkedlist;

public class Q3 {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.append(5);

//        deleteMiddleNode(head);
        deleteNode(head.get(2));
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

    private static void deleteMiddleNode(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        Node prev = head;
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;
    }

}
