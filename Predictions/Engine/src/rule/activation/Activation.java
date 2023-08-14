package rule.activation;

public class Activation {
    private Integer ticks = 1;
    private Double probabilty = 1.0;

    public Activation() {
    }

    public Activation(Integer ticks, Double probabilty) {
        if(ticks != null) {
            this.ticks = ticks;
        }
        if(probabilty != null) {
            this.probabilty = probabilty;
        }
    }

    public Double getProbabilty() {
        return probabilty;
    }

    public Integer getTicks() {
        return ticks;
    }
}
