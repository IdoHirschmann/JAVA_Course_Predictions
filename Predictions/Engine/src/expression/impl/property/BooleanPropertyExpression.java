package expression.impl.property;

import entity.instance.EntityInstance;
import expression.ExpressionType;

public class BooleanPropertyExpression extends AbstractPropertyExpression {
    public BooleanPropertyExpression(String value) {
        super(value, ExpressionType.BOOLEAN);
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
