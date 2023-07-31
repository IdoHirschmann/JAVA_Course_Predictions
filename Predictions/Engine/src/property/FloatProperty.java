package property;

public class FloatProperty extends Property{
    private float value;
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
        //todo - value should be random.
    }
    public FloatProperty(String name){
        super(name, PropertyType.FLOAT, false , true);
        rangeFrom = rangeTo = NO_RANGE_PROP;
        //todo - value should be random.
    }
    @Override
    public String getValue() {
        return Float.toString(value);
    }
    @Override
    public void setValue(String value) {
        //todo-  static method that will check the value type and will act accordingly
    }

}
