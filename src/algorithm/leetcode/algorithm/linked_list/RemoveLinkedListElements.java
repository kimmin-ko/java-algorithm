package algorithm.leetcode.algorithm.linked_list;

public class RemoveLinkedListElements {

    public static void main(String[] args) {
        RemoveLinkedListElements s = new RemoveLinkedListElements();

        ListNode n5 = new ListNode(3);
        ListNode n4 = new ListNode(6, n5);
        ListNode n3 = new ListNode(2, n4);
        ListNode n2 = new ListNode(1, n3);
        ListNode head = new ListNode(6, n2);

        ListNode answer = s.removeElements(head, 6);

    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        return remove(head, val);
    }

    public ListNode remove(ListNode head, int val) {
        while (head != null) {
            if (head.val == val) {
                head = head.next;
                continue;
            }

            break;
        }

        if (head == null) {
            return null;
        }

        ListNode n = head;
        while (n.next != null) {
            if (n.next.val == val) {
                n.next = n.next.next;
                continue;
            }

            n = n.next;
        }

        return head;
    }
}
