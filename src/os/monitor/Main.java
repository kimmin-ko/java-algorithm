package os.monitor;

public class Main {

    public static void main(String[] args) {
        BoundedBuffer buffer = new BoundedBuffer();

        for (int i = 0; i < 100; i++) {
            Thread p1 = new Thread(produce(buffer, i));
            Thread p2 = new Thread(produce(buffer, i));
            Thread p3 = new Thread(produce(buffer, i));
            Thread c1 = new Thread(consume(buffer));

            p1.start();
            p2.start();
            p3.start();
            c1.start();
        }
    }

    private static Runnable consume(BoundedBuffer buffer) {
        return () -> {
            try {
                int item = buffer.consume();
                System.out.println("Consumer Thread: " + Thread.currentThread().getName() + ", item = " + item);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }

    private static Runnable produce(BoundedBuffer buffer, int item) {
        return () -> {
            try {
                buffer.produce(item);
                System.out.println("Producer Thread: " + Thread.currentThread().getName() + ", item = " + item);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
