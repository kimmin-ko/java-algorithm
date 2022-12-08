package os.monitor.okky;

public class Number {

    private int number = 1;

    public synchronized int increase() {
        return ++this.number;
    }

    public boolean isEnd() {
        return this.number == 31;
    }

}
