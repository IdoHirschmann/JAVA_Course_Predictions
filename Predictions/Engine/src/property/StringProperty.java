package property;

public class StringProperty extends Property{
    private String value;

    public StringProperty(String name, String value) {
        super(name, PropertyType.STRING, false, false);
        this.value = value;
    }
    public StringProperty(String name) {
        super(name, PropertyType.STRING, false, true);
        //todo
    }
    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
