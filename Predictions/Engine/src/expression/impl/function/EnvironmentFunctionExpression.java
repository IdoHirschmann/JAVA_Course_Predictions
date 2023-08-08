package expression.impl.function;

import entity.instance.EntityInstance;
import expression.ExpressionType;

import java.util.stream.Stream;

public class EnvironmentFunctionExpression extends AbstractFunctionExpression {
    private String EnvironmentName;

    public EnvironmentFunctionExpression(String value) {
        super(value, null);
        EnvironmentName = GetEnvironmentNameFromValue();

        String checkerType = GetExplicitValue(null);
        setType(getType(checkerType));
    }

    private String GetEnvironmentNameFromValue() {
        return Stream.of(getValue())
                .map(s -> s.replaceAll("environment\\((.*?)\\)", "$1"))
                .findFirst()
                .orElse("");

        //todo - check if really work :o
    }

    private ExpressionType getType(String val) {
        try {
            Integer.parseInt(val);
            return ExpressionType.INT;
        } catch (NumberFormatException e) {
            // Not an integer
        }

        try {
            Float.parseFloat(val);
            return ExpressionType.FLOAT;
        } catch (NumberFormatException e) {
            // Not a float
        }

        if (val.equalsIgnoreCase("true") || val.equalsIgnoreCase("false")) {
            return ExpressionType.BOOLEAN;
        }

        return ExpressionType.STRING;
    }

    @Override
    public String GetSimpleValue() {
        return getValue();
    }

    @Override
    public String GetExplicitValue(EntityInstance entity) {
        return null;

        //todo - after we make the random function
    }
}
