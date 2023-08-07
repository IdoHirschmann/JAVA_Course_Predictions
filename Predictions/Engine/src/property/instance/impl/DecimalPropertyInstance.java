package property.instance.impl;
import property.definition.PropertyDefinition;
import property.definition.PropertyType;
import property.definition.range.api.Range;
import property.instance.AbstractPropertyInstance;

import java.util.concurrent.ThreadLocalRandom;

import static utills.string.StringConvertor.convertStringToInt;

public class DecimalPropertyInstance extends AbstractPropertyInstance {
    private int value;

    public DecimalPropertyInstance(String name, Range range, int value){
        super(name,range);
        this.value = value;
    }
    @Override
    public String getValue() {
        return Integer.toString(value);
    }
    @Override
    public void setValue(String value) {
        try {
            this.value = convertStringToInt(value);
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException(e.getMessage() + "Error occurred in setValue in DecimalPropertyInstance class");
        }
    }
}