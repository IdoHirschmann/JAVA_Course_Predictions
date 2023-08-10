package expression.impl.property;

import entity.instance.EntityInstance;
import exception.PropertyNotFoundException;
import expression.ExpressionType;
import property.instance.AbstractPropertyInstance;

public class DecimalPropertyExpression extends AbstractPropertyExpression {
    public DecimalPropertyExpression(String value, ExpressionType type) {
        super(value, ExpressionType.INT);
    }


    @Override
    public String GetExplicitValue(EntityInstance entity) {
        String res;
        AbstractPropertyInstance environment = getEnvironments().getEnvironment(getValue());

        if (environment != null) {
            res = environment.getValue();
        } else {
            res = entity.getSpecificPropertyValue(getValue());
        }

        if (res != null) {
            return res;
        } else {
            throw new PropertyNotFoundException("PropertyNotFoundException: " + getValue() + "was not found!" + " Problem occurred in class DecimalPropertyExpression");
        }
    }
}
