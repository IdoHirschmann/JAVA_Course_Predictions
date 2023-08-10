package property.definition.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public Boolean IsInRange(double value) {
        if (value >= from && value <= to) {
            return true;
        } else {
            return false;
        }
    }
}
