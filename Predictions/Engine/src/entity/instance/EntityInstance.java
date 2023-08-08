package entity.instance;

import property.definition.PropertyDefinition;
import property.instance.AbstractPropertyInstance;

import java.util.Map;

public class EntityInstance {
    private Map<String, AbstractPropertyInstance> properties;

    public String getSpecificPropertyValue (String propertyName) throws Exception {
        AbstractPropertyInstance propertyInstance = properties.get(propertyName);

        if(propertyInstance != null) {
            return propertyInstance.getValue();
        }
        else {
            throw new Exception();
            //todo - need to throw here the right exception
        }
    }

    //todo - think about properties init

}
