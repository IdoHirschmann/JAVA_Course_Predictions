package property.instance.impl;

import property.definition.PropertyDefinition;
import property.definition.PropertyType;
import property.definition.range.api.Range;
import property.instance.AbstractPropertyInstance;

import java.util.concurrent.ThreadLocalRandom;

import static utills.string.StringConvertor.convertStringToFloat;

public class FloatPropertyInstance extends AbstractPropertyInstance {
    private  float value;

    public FloatPropertyInstance(String name, Range range, float value){
        super(name,range);
        this.value = value;
    }

    @Override
    public String getValue() {
        return Float.toString(value);
    }
    @Override
    public void setValue(String value) {
        try {
            this.value = convertStringToFloat(value);
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException(e.getMessage() + "Error occurred in setValue in FloatPropertyInstance class");
        }
    }

}
