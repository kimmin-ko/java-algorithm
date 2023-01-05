package cracking.interview.stack_and_queue;

import java.util.EmptyStackException;

public class StackWithMin {

    private Node top;

    public void push(int value) {
        int topMinValue = top != null ? top.min : Integer.MAX_VALUE;
        Node newNode = new Node(value, Math.min(value, topMinValue));
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (top == null) {
            throw new EmptyStackException();
        }

        int item = top.value;
        top = top.next;
        return item;
    }

    public int min() {
        if (top == null) {
            throw new EmptyStackException();
        }

        return top.min;
    }

    static class Node {
        private final int value;
        private final int min;
        private Node next;

        public Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

}
