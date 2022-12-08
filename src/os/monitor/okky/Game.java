package os.monitor.okky;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    public static void main(String[] args) throws InterruptedException {
        Number number = new Number();

        while (true) {
            Thread m1 = new Thread(new MyRunnable(number));
            m1.setName("Thread One");
            Thread m2 = new Thread(new MyRunnable(number));
            m2.setName("Thread Two");
            Thread m3 = new Thread(new MyRunnable(number));
            m3.setName("Thread Three");

            m1.start();
            m1.join();

            if (number.isEnd()) {
                break;
            }

            m2.start();
            m2.join();

            if (number.isEnd()) {
                break;
            }

            m3.start();
            m3.join();

            if (number.isEnd()) {
                break;
            }
        }
    }

    static class MyRunnable implements Runnable {

        private Number number;

        public MyRunnable(Number number) {
            this.number = number;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();

            int random = new Random().nextInt(3) + 1;

            List<Integer> values = new ArrayList<>();
            for (int i = 0; i < random; i++) {
                int increase = this.number.increase();
                values.add(increase);
                if (number.isEnd()) {
                    break;
                }
            }
            System.out.println(name + "의 출력: " + values);

            if (number.isEnd()) {
                System.out.println(name + "가 패배하였습니다.");
            }
        }
    }

}
