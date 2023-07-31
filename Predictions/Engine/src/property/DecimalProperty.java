package property;

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
        //todo - value should be random.
    }
    public DecimalProperty(String name){
        super(name, PropertyType.DECIMAL, false, true);
        rangeFrom = rangeTo = NO_RANGE_PROP;
        //todo - value should be random.
    }
    @Override
    public String getValue() {
        return Integer.toString(value);
    }
    @Override
    public void setValue(String value) {
        // todo - static method that will check the value type and will act accordingly
    }
}
