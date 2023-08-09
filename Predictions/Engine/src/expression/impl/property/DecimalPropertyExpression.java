package expression.impl.property;

import entity.instance.EntityInstance;
import expression.ExpressionType;
import property.instance.AbstractPropertyInstance;

public class DecimalPropertyExpression extends AbstractPropertyExpression {
    public DecimalPropertyExpression(String value, ExpressionType type) {
        super(value, ExpressionType.INT);
    }

    @Override
    public String GetSimpleValue() {
        return getValue();
    }

    @Override
    public String GetExplicitValue(EntityInstance entity) throws Exception {
        AbstractPropertyInstance environment = getEnvironments().getEnvironment(getValue());

        if(environment != null) {
            return environment.getValue();
        }

        return entity.getSpecificPropertyValue(getValue());
        //todo - need to change the throws Exception after we throw the right exception in getSpecificPropertyValue
    }
}
