package property.definition.range;

public class Range {
    private Number from;
    private Number to;

    public Range(Number from, Number to) {
        this.from = from;
        this.to = to;
    }

    public Number getFrom() {
        return from;
    }

    public Number getTo() {
        return to;
    }

    public Boolean IsInRange(Number value) {
        double doubleValue = value.doubleValue();
        double doubleFrom = from.doubleValue();
        double doubleTo = to.doubleValue();

        if (doubleValue >= doubleFrom && doubleValue <= doubleTo) {
            return true;
        } else {
            return false;
        }
    }
}
