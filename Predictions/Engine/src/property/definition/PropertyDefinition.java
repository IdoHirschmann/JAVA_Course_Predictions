package property.definition;

import property.definition.range.Range;
import property.definition.value.Value;

import java.util.Objects;

public class PropertyDefinition {
    private final String name;
    private final PropertyType type;
    private final Range range;
    private final Value value;
    protected static final int NO_RANGE_PROP = 0;


    public PropertyDefinition(String name, PropertyType type,Value value ,Range range) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.range = range;
    }

    public PropertyType getType() {
        return type;
    }

    public Range getRange() {
        return range;
    }

    public String getName() {
        return name;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyDefinition property = (PropertyDefinition) o;
        return Objects.equals(name, property.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
