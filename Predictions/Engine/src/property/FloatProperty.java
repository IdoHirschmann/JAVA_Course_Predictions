package property;

import java.util.concurrent.ThreadLocalRandom;

import static utills.string.StringConvertor.convertStringToFloat;
import static utills.string.StringConvertor.convertStringToInt;

public class FloatProperty extends Property{
    private  float value;
    private final float rangeFrom;
    private final float rangeTo;
    public FloatProperty(String name, float from, float to, float value){
        super(name, PropertyType.FLOAT, true, false);
        rangeFrom = from;
        rangeTo = to;
        this.value = value;
    }
    public FloatProperty(String name, float value){
        super(name, PropertyType.FLOAT, false , false);
        rangeFrom = rangeTo = NO_RANGE_PROP;
        this.value = value;
    }
    public FloatProperty(String name, float from, float to){
        super(name, PropertyType.FLOAT, true, true);
        rangeFrom = from;
        rangeTo = to;
        value = from + ThreadLocalRandom.current().nextFloat() * (to - from);
    }
    public FloatProperty(String name){
        super(name, PropertyType.FLOAT, false , true);
        rangeFrom = rangeTo = NO_RANGE_PROP;
        value = ThreadLocalRandom.current().nextFloat();
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
            throw new NumberFormatException(e.getMessage() + "Error occurred in setValue in FloatProperty class");
        }
    }

}
