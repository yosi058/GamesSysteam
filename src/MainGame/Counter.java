package MainGame;

public class Counter {
    private int count;

    public Counter() {
        count = 0;
    }

    public void increase(int x) {
        if (x > 0) {
            count += x;
        }
    }

    public int getCount() {
        return count;
    }

    public void set(int x) {
        count = x;
    }
}
