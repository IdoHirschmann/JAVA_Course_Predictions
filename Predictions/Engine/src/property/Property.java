package property;

import java.util.Objects;

public abstract class Property {
    private final String name;
    private final PropertyType type;
    private final boolean isRanged;

    protected static final int NO_RANGE_PROP = 0;
    private final boolean isRandomInit;

    public Property(String name, PropertyType type, boolean isRanged, boolean isRandomInit) {
        this.name = name;
        this.type = type;
        this.isRanged = isRanged;
        this.isRandomInit = isRandomInit;
    }

    public boolean isRanged() {
        return isRanged;
    }

    public boolean isRandomInit() {
        return isRandomInit;
    }

    public PropertyType getType() {
        return type;
    }

    public abstract String getValue();

    public abstract void setValue(String value);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Objects.equals(name, property.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
