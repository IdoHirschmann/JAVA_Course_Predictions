package property;
import java.util.concurrent.ThreadLocalRandom;

import static utills.string.StringConvertor.convertStringToInt;

public class DecimalProperty extends Property{
    private int value;
    private final int rangeFrom;
    private final int rangeTo;
    public DecimalProperty(String name, int from, int to, int value){
        super(name, PropertyType.DECIMAL, true, false);
        rangeFrom = from;
        rangeTo = to;
        this.value = value;
    }
    public DecimalProperty(String name, int value){
        super(name, PropertyType.DECIMAL, false , false);
        rangeFrom = rangeTo = NO_RANGE_PROP;
        this.value = value;
    }
    public DecimalProperty(String name, int from, int to){
        super(name, PropertyType.DECIMAL, true, true);

        rangeFrom = from;
        rangeTo = to;
        value = ThreadLocalRandom.current().nextInt(from, to + 1);
    }
    public DecimalProperty(String name){
        super(name, PropertyType.DECIMAL, false, true);
        rangeFrom = rangeTo = NO_RANGE_PROP;
        value = ThreadLocalRandom.current().nextInt();
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
            throw new NumberFormatException(e.getMessage() + "Error occurred in setValue in DecimalProperty class");
        }
    }
}
