package entity.definition;

import property.definition.PropertyDefinition;

import java.util.Map;

public class EntityDefinition {
    private final String name;
    private Map<String, PropertyDefinition> properties;
    private final int population;

    public EntityDefinition(String name,int population ,Map<String, PropertyDefinition> properties) {
        this.name = name;
        this.properties = properties;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public PropertyDefinition getProperty(String propName) {
        return properties.get(propName);
    }

    public Map<String, PropertyDefinition> getProperties() {
        return properties;
    }
}
