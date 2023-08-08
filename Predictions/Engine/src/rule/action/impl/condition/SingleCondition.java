package rule.action.impl.condition;

import entity.definition.EntityDefinition;
import expression.api.Expression;
import rule.action.ActionType;
import rule.action.context.api.ActionContext;
import rule.action.impl.AbstractAction;
import rule.action.impl.condition.enums.OperatorType;

import java.util.List;

public class SingleCondition extends AbstractCondition {
    private String property;
    private Expression value;
    private OperatorType operator;

    public SingleCondition(EntityDefinition primaryEntityDefinition, List<AbstractAction> then, List<AbstractAction> elsE, String property, Expression value, OperatorType operator) {
        super(primaryEntityDefinition, ActionType.SINGLE_CONDITION, then, elsE);
        this.property = property;
        this.value = value;
        this.operator = operator;
    }

    @Override
    protected boolean runCondition(ActionContext context) {
        return false;
        //todo
    }

    @Override
    public void Invoke(ActionContext context) {
        //todo - remember: the property can be property in the entityInstance or environment!!
    }
}
