package property.instance.impl;

import property.definition.PropertyType;
import property.definition.range.Range;
import property.instance.AbstractPropertyInstance;

import static utills.string.StringConvertor.convertStringToFloat;

public class FloatPropertyInstance extends AbstractPropertyInstance {
    private  float value;

    public FloatPropertyInstance(String name, Range range, float value){
        super(name,range);
        this.value = value;
    }

    @Override
    public PropertyType getType() {
        return PropertyType.FLOAT;
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
