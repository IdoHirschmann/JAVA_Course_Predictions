package termination;

public class Termination {
    private final int ticks;
    private final int seconds;

    public Termination(int ticks, int seconds) {
        this.ticks = ticks;
        this.seconds = seconds;
    }

    public int getTicks() {
        return ticks;
    }

    public int getSeconds() {
        return seconds;
    }
}
