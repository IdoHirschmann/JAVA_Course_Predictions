package property.instance.impl;

import property.definition.PropertyDefinition;
import property.definition.PropertyType;
import property.definition.range.api.Range;
import property.instance.AbstractPropertyInstance;

import java.util.concurrent.ThreadLocalRandom;

import static utills.string.StringConvertor.convertStringToBool;

public class BooleanPropertyInstance extends AbstractPropertyInstance {
    private boolean value;

    public BooleanPropertyInstance(boolean value , String name) {
        super(name);
        this.value = value;
    }

    @Override
    public String getValue() {
        return Boolean.toString(value);
    }

    @Override
    public void setValue(String value) {
        try {
            this.value = convertStringToBool(value);
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage() + "Error occurred in setValue in BooleanPropertyInstance class");
        }
    }
}