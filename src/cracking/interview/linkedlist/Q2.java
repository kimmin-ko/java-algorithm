package cracking.interview.linkedlist;

import java.util.ArrayList;

public class Q2 {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.append(5);

//        System.out.println(kThFromLast(head, 4).data);
        System.out.println(kThFromLastRecur(head, 4, new Reference(0)).data);
        System.out.println(kThFromLastRecur(head, 3, new Reference(0)).data);
    }

    private static class Reference {
        int count;

        public Reference(int count) {
            this.count = count;
        }
    }

    private static Node kThFromLastRecur(Node n, int k, Reference r) {
        if (n == null) {
            return null;
        }

        Node found = kThFromLastRecur(n.next, k, r);
        r.count++;
        if (k == r.count) {
            return n;
        }
        return found;
    }

    private static Node kThFromLast(Node head, int k) {
        ArrayList<Node> list = new ArrayList<>();
        list.add(head);

        while (head.next != null) {
            head = head.next;
            list.add(head);
        }

        return list.get(list.size() - k);
    }
}
