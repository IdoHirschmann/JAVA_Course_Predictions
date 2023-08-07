package entity.definition;

import property.definition.PropertyDefinition;

import java.util.Map;

public class EntityDefinition {
    private final String name;
    private Map<String, PropertyDefinition> properties;

    public EntityDefinition(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //todo - think about properties init
}
