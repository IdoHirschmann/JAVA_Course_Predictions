package expression.impl.property;

import entity.instance.EntityInstance;
import exception.PropertyNotFoundException;
import expression.ExpressionType;
import property.instance.AbstractPropertyInstance;

public class FloatPropertyExpression extends AbstractPropertyExpression {
    public FloatPropertyExpression(String value) {
        super(value, ExpressionType.FLOAT);
    }


    @Override
    public String GetExplicitValue(EntityInstance entity) {
        String res;
        AbstractPropertyInstance environment = getEnvironments().getEnvironment(getValue());

        if(environment != null) {
            res = environment.getValue();
        } else {
            res = entity.getSpecificPropertyValue(getValue());
        }

        if(res != null) {
            return res;
        } else {
            throw new PropertyNotFoundException("PropertyNotFoundException: " + getValue() + "was not found!" + " Problem occurred in class FloatPropertyExpression");
        }
    }
}
