package os.monitor;

public class BoundedBuffer {

    private final int[] buffer = new int[3];
    private int count = 0;

    public synchronized void produce(int item) throws InterruptedException {
        while (isFull()) {
            // 현재 스레드가 condition variable 의 waiting queue 로 이동
            // producer thread 의 mutex lock 반환
            System.out.println("FULL BUFFER !!");
            wait();
        }
        buffer[count++] = item;

        // waiting queue 에 대기중인 스레드를 모두 깨움
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (isEmpty()) {
            // 현재 스레드가 condition variable 의 waiting queue 로 이동
            // consumer thread 의 mutex lock 반환
            System.out.println("EMPTY BUFFER !!");
            wait();
        }

        int item = buffer[--count];
        notifyAll();
        return item;
    }

    private boolean isEmpty() {
        return count == 0;
    }

    private boolean isFull() {
        return count == 3;
    }

}
