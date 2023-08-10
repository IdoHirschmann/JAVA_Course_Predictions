package entity.definition;

import property.definition.PropertyDefinition;

import java.util.Map;

public class EntityDefinition {
    private final String name;
    private Map<String, PropertyDefinition> properties;

    public EntityDefinition(String name, Map<String, PropertyDefinition> properties) {
        this.name = name;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

}
