package rule.action.impl.numeric.calculation;

import entity.definition.EntityDefinition;
import expression.api.Expression;
import rule.action.ActionType;
import rule.action.context.api.ActionContext;

public class Divide extends AbstractCalculation {
    public Divide(EntityDefinition primaryEntityDefinition, String resultProp, Expression firstArgument, Expression secondArgument) {
        super(primaryEntityDefinition, ActionType.DIVIDE, resultProp, firstArgument, secondArgument);
    }

    @Override
    public void Invoke(ActionContext context) {
        //todo - remember: the property can be property in the entityInstance or environment!!
    }
}
