package cracking.interview.stack_and_queue;

import java.util.EmptyStackException;

public class MultiStack {

    private StackInfo[] stackInfos;
    private int[] values;

    public MultiStack(int numOfStack, int defaultSize) {
        stackInfos = new StackInfo[numOfStack];
        for (int i = 0; i < numOfStack; i++) {
            stackInfos[i] = new StackInfo(i * defaultSize, defaultSize);
        }
        values = new int[numOfStack * defaultSize];
    }

    public void push(int stackNum, int value) throws FullStackException {
        if (allStackAreFull()) {
            throw new FullStackException();
        }
        StackInfo stack = stackInfos[stackNum];
        if (stack.isFull()) {
            expand(stackNum);
        }
        values[stack.getNewDataIndex()] = value;
        stack.dataSize++;
    }

    public int pop(int stackNum) {
        StackInfo stack = stackInfos[stackNum];
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        int lastIndex = stack.getLastDataIndex();
        int value = values[lastIndex];
        values[lastIndex] = 0;
        stack.dataSize--;
        return value;
    }

    public int peek(int stackNum) {
        StackInfo stack = stackInfos[stackNum];
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return values[stack.getLastDataIndex()];
    }

    public int numOfElements() {
        int totalDataSize = 0;
        for (StackInfo stackInfo : stackInfos) {
            totalDataSize += stackInfo.dataSize;
        }
        return totalDataSize;
    }

    public boolean allStackAreFull() {
        return numOfElements() == values.length;
    }

    // private //
    private void expand(int stackNum) {
        int nextStackNum = (stackNum + 1) % stackInfos.length;
        shift(nextStackNum);
        stackInfos[stackNum].stackSize++;
    }

    private void shift(int stackNum) {
        StackInfo stack = stackInfos[stackNum];
        if (stack.isFull()) {
            int nextStackNum = (stackNum + 1) % stackInfos.length;
            shift(nextStackNum);
            stack.stackSize++;
        }
        int index = stack.getLastStackIndex();
        while (stack.isWithinStack(index)) {
            values[index] = values[previousIndex(index)];
            index = previousIndex(index);
        }
        values[stack.start] = 0;
        stack.start = nextIndex(stack.start);
        stack.stackSize--;
    }

    private int adjustIndex(int index) {
        int max = values.length;
        return ((index % max) + max) % max;
    }

    private int nextIndex(int index) {
        return adjustIndex(index + 1);
    }

    private int previousIndex(int index) {
        return adjustIndex(index - 1);
    }

    // nested class //
    class StackInfo {
        private int start;
        private int dataSize;
        private int stackSize;

        public StackInfo(int start, int stackSize) {
            this.start = start;
            this.stackSize = stackSize;
            this.dataSize = 0;
        }

        public boolean isWithinStack(int index) {
            if (index < 0 || values.length <= index) {
                return false;
            }
            int virtualIndex = index < this.start ? index + values.length : index;
            int virtualEndIndex = this.start + this.stackSize;
            return start <= virtualIndex && virtualIndex < virtualEndIndex;
        }

        public int getLastStackIndex() {
            return adjustIndex(this.start + this.stackSize - 1);
        }

        public int getLastDataIndex() {
            return adjustIndex(this.start + this.dataSize - 1);
        }

        public int getNewDataIndex() {
            return adjustIndex(getLastDataIndex() + 1);
        }

        public boolean isFull() {
            return this.dataSize == this.stackSize;
        }

        public boolean isEmpty() {
            return this.dataSize == 0;
        }
    }
}
