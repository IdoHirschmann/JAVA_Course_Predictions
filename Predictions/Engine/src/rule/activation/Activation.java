package rule.activation;

public class Activation {
    private Integer ticks = 1;
    private Double probability = 1.0;

    public Activation() {
    }

    public Activation(Integer ticks, Double probabilty) {
        if(ticks != null) {
            this.ticks = ticks;
        }
        if(probabilty != null) {
            this.probability = probabilty;
        }
    }

    public Double getProbability() {
        return probability;
    }

    public Integer getTicks() {
        return ticks;
    }
}
