package rule.activation;

public class Activation {
    private final int ticks;
    private final double probabilty;

    public Activation(int ticks, double probabilty) {
        this.ticks = ticks;
        this.probabilty = probabilty;
    }

    public double getProbabilty() {
        return probabilty;
    }

    public int getTicks() {
        return ticks;
    }
}
