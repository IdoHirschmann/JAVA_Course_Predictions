package factory.instance;

import property.definition.PropertyDefinition;
import property.instance.AbstractPropertyInstance;
import property.instance.impl.StringPropertyInstance;

public abstract class FactoryPropertyInstance {

    private AbstractPropertyInstance createPropertyInstance(PropertyDefinition propertyDefinition) {

        switch (propertyDefinition.getType()) {
            case DECIMAL:
                return createDecimalPropInstance(propertyDefinition);
            case FLOAT:
                return createFloatPropInstance(propertyDefinition);
            case BOOLEAN:
                return createBooleanPropInstance(propertyDefinition);
            default:
                return createStringPropInstance(propertyDefinition);
        }
    }
    private AbstractPropertyInstance createStringPropInstance(PropertyDefinition propertyDefinition) {
        String value;
        if(propertyDefinition.getValue().isRandomInitialize()) {
            //todo
            return null;
        }
        else {
            value = propertyDefinition.getValue().getInit();
        }

        return new StringPropertyInstance(propertyDefinition.getName(), value);
    }
    private AbstractPropertyInstance createBooleanPropInstance(PropertyDefinition propertyDefinition) {
        return null;
    }
    private AbstractPropertyInstance createFloatPropInstance(PropertyDefinition propertyDefinition) {
        return null;
    }
    private AbstractPropertyInstance createDecimalPropInstance(PropertyDefinition propertyDefinition) {
        return null;
    }
}
