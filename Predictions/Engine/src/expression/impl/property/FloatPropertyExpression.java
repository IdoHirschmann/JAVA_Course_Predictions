package expression.impl.property;

import entity.instance.EntityInstance;
import expression.ExpressionType;

public class FloatPropertyExpression extends AbstractPropertyExpression {
    public FloatPropertyExpression(String value) {
        super(value, ExpressionType.FLOAT);
    }

    @Override
    public String GetSimpleValue() {
        return getValue();
    }

    @Override
    public String GetExplicitValue(EntityInstance entity) throws Exception {
        return entity.getSpecificPropertyValue(getValue());
        //todo - need to change the throws Exception after we throw the right exception in getSpecificPropertyValue
    }
}