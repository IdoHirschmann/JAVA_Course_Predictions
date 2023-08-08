package rule.activation;

public class Activation {
    private final int ticks;
    private final float probabilty;

    public Activation(int ticks, float probabilty) {
        this.ticks = ticks;
        this.probabilty = probabilty;
    }

    public float getProbabilty() {
        return probabilty;
    }

    public int getTicks() {
        return ticks;
    }
}
