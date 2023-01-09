package algorithm.leetcode.linked_list;

public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers s = new AddTwoNumbers();

        // l1
        ListNode l1_4 = new ListNode(5);
        ListNode l1_3 = new ListNode(3, l1_4);
        ListNode l1_2 = new ListNode(4, l1_3);
        ListNode l1 = new ListNode(2, l1_2);

        // l2
        ListNode l2_3 = new ListNode(4);
        ListNode l2_2 = new ListNode(6, l2_3);
        ListNode l2 = new ListNode(5, l2_2);

        // solution
        ListNode listNode = s.addTwoNumbers(l1, l2);
        System.out.println("listNode = " + listNode.val);
    }

    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        int carry = 0;

        while (node1 != null || node2 != null) {
            int node1Val = node1 != null ? node1.val : 0;
            int node2Val = node2 != null ? node2.val : 0;
            System.out.println("node1 = " + node1Val + ", node2 = " + node2Val);

            int number = node1Val + node2Val + carry;
            int val = number % 10;
            cur.next = new ListNode(val);
            cur = cur.next;

            carry = number / 10;

            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }
        }

        if (carry == 1) {
            cur.next = new ListNode(carry);
        }

        return head.next;
    }
}
