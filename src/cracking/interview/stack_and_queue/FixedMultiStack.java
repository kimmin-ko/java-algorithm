package cracking.interview.stack_and_queue;

import java.util.EmptyStackException;

public class FixedMultiStack {

    private final int numOfStack = 3;
    private final int stackSize;
    private final int[] sizes;
    private final int[] values;

    public FixedMultiStack(int stackSize) {
        this.stackSize = stackSize;
        this.sizes = new int[numOfStack];
        this.values = new int[numOfStack * stackSize];
    }

    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackSize;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }

        int top = getTopIndex(stackNum);
        int data = values[top];
        values[top] = 0;
        sizes[stackNum]--;
        return data;
    }

    public void push(int stackNum, int data) throws FullStackException {
        if (isFull(stackNum)) {
            throw new FullStackException();
        }

        values[getTopIndex(stackNum) + 1] = data;
        sizes[stackNum]++;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        return values[getTopIndex(stackNum)];
    }

    // private //
    private int getTopIndex(int stackNum) {
        int offset = stackNum * stackSize;
        int size = sizes[stackNum];
        return offset + size - 1;
    }
}
