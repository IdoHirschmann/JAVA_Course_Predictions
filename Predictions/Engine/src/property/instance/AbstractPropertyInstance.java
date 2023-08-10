package property.instance;

import property.definition.range.Range;

public abstract class AbstractPropertyInstance {
    private final String name;
    private final Range range;

    public AbstractPropertyInstance(String name) {
        this.name = name;
        this.range = null;
    }

    public Range getRange() {
        return range;
    }

    public AbstractPropertyInstance(String name, Range range) {
        this.name = name;
        this.range = range;
    }

    public Boolean isInRange(Number number) {
        return range.IsInRange(number.doubleValue());
    }

    public abstract void setValue(String value);
    public abstract String getValue();
}
