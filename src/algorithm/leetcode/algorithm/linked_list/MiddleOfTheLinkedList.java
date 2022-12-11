package algorithm.leetcode.algorithm.linked_list;

public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode n = head;
        int size = 1;
        while (n.next != null) {
            size++;
            n = n.next;
        }

        int middle = size / 2;
        for (int i = 0; i < middle; i++) {
            head = head.next;
        }

        return head;
    }

}
