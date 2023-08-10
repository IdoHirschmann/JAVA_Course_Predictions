package factory.definition;

import property.definition.PropertyDefinition;
import property.definition.range.Range;
import property.definition.value.PropertyDefinitionValue;
import schema.generated.PRDProperty;

public abstract class FactoryDefinition {
    public static PropertyDefinition createPropertyDefinition(PRDProperty PRDProperty) {
        Range range = new Range(PRDProperty.getPRDRange().getFrom(), PRDProperty.getPRDRange().getTo());
        PropertyDefinitionValue value = new PropertyDefinitionValue(PRDProperty.getPRDValue().isRandomInitialize(),PRDProperty.getPRDValue().getInit());
        String type = new String(PRDProperty.getType());

        if(!type.equals("decimal") && !type.equals("boolean"))
        switch(type) {
            case "decimal":
               break;
        }

        return null;
    }
}
