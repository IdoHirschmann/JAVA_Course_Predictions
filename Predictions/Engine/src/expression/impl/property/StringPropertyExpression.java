package expression.impl.property;

import entity.instance.EntityInstance;
import exception.PropertyNotFoundException;
import expression.ExpressionType;
import property.instance.AbstractPropertyInstance;

public class StringPropertyExpression extends AbstractPropertyExpression {
    public StringPropertyExpression(String value) {
        super(value, ExpressionType.STRING);
    }

    @Override
    public String GetExplicitValue(EntityInstance entity) {
        String res = entity.getSpecificPropertyValue(getValue());
        if(res == null) {
            throw new PropertyNotFoundException("PropertyNotFoundException: " + getValue() + "was not found!\n" +
                    "       Please make sure the property you enter to an action is in the right entity. Problem occurred in class StringPropertyExpression");
        }

        return res;
    }
}
