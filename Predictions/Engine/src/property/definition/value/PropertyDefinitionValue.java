package property.definition.value;

public class PropertyDefinitionValue {
    private final boolean randomInitialize;
    private final String init;

    public PropertyDefinitionValue(boolean randomInitialize, String init) {
        this.randomInitialize = randomInitialize;
        this.init = init;
    }

    public boolean isRandomInitialize() {
        return randomInitialize;
    }
    public String getInit() {
        return init;
    }
}
