package expression.impl.function;

import entity.instance.EntityInstance;
import expression.ExpressionType;

public class RandomFunctionExpression extends AbstractFunctionExpression {
    private int randomArgument;
    public RandomFunctionExpression(String value) {
        super(value, ExpressionType.INT);

        String[] str = new String[]{value};
        randomArgument = Integer.parseInt(str[7]);
        //todo - check if really coorect
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
