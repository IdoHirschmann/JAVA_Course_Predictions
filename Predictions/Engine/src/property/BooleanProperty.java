package property;

public class BooleanProperty extends Property {
    private boolean value;

    public BooleanProperty(String name, boolean value) {
        super(name, PropertyType.BOOLEAN, false, false);
        this.value = value;
    }
    public BooleanProperty(String name) {
        super(name, PropertyType.BOOLEAN, false, true);
        //todo
    }
    @Override
    public String getValue() {
        return Boolean.toString(value);
    }

    @Override
    public void setValue(String value) {
        //todo
    }
}
