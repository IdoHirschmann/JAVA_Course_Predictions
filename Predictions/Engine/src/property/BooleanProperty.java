package property;

import java.util.concurrent.ThreadLocalRandom;

import static utills.string.StringConvertor.convertStringToBool;

public class BooleanProperty extends Property {
    private boolean value;

    public BooleanProperty(String name, boolean value) {
        super(name, PropertyType.BOOLEAN, false, false);
        this.value = value;
    }
    public BooleanProperty(String name) {
        super(name, PropertyType.BOOLEAN, false, true);
        value = ThreadLocalRandom.current().nextBoolean();
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
            throw new IllegalArgumentException(e.getMessage() + "Error occurred in setValue in BooleanProperty class");
        }
    }
}
