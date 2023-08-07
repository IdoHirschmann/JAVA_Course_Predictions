package property.instance;

import property.definition.range.api.Range;

import java.util.Random;

public abstract class AbstractPropertyInstance {
    private final String name;
    private final Range range;

    public AbstractPropertyInstance(String name) {
        this.name = name;
        this.range = null;
    }

    public AbstractPropertyInstance(String name, Range range) {
        this.name = name;
        this.range = range;
    }

    public abstract void setValue(String value);
    public abstract String getValue();
}
