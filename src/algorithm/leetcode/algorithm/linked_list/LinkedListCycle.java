package algorithm.leetcode.algorithm.linked_list;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }

            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }
}
