package cracking.interview.stack_and_queue;

public class Q2 {

    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.push(1);
        stack.push(2);
        stack.push(-10);
        stack.push(9);
        stack.push(8);
        stack.push(5);
        stack.push(4);
        stack.push(2);
        stack.push(7);

        System.out.println("min: " + stack.min());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("min: " + stack.min());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("min: " + stack.min());
    }
}
