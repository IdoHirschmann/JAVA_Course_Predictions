package rule.action.impl.numeric;

import entity.definition.EntityDefinition;
import expression.ExpressionType;
import expression.api.Expression;
import property.instance.AbstractPropertyInstance;
import rule.action.ActionType;
import rule.action.context.api.ActionContext;


import static utills.helperFunction.Helper.isDecimal;
import static utills.helperFunction.Helper.isFloat;

public class Increase extends AbstractNumericAction {
    private Expression by;

    public Increase(EntityDefinition primaryEntityDefinition, String resultProp, Expression by) {
        super(primaryEntityDefinition, ActionType.INCREASE, resultProp);
        this.by = by;
    }

    @Override
    public void Invoke(ActionContext context) throws Exception {
        //todo - exception (change the throws type)
        AbstractPropertyInstance property = extractProperty(context);
        Number newPropertyValue = extractANumber(context);

        if(by.getType() == ExpressionType.INT) {
            if(isDecimal(newPropertyValue.toString())) {
                newPropertyValue = newPropertyValue.intValue() + Integer.parseInt(by.GetExplicitValue(context.getPrimaryEntityInstance()));
            }
            else {
                newPropertyValue = newPropertyValue.floatValue() + Integer.parseInt(by.GetExplicitValue(context.getPrimaryEntityInstance()));
            }
        }
        else if (by.getType() == ExpressionType.FLOAT) {
            if(isFloat(newPropertyValue.toString())) {
                newPropertyValue = newPropertyValue.floatValue() + Float.parseFloat(by.GetExplicitValue(context.getPrimaryEntityInstance()));
            }
            else {
                //todo - exception (try to reduce float from int property)
            }
        }
        else {
            //todo - exception (by is not number)
        }

        if(property.isInRange(newPropertyValue)) {
            property.setValue(newPropertyValue.toString());
        }
        else {
            //todo - ask aviad
        }
    }
}
