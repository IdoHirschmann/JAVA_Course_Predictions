package rule.action.impl.condition;

import entity.definition.EntityDefinition;
import rule.action.ActionType;
import rule.action.context.api.ActionContext;
import rule.action.impl.AbstractAction;
import rule.action.impl.condition.enums.LogicType;

import java.util.List;

public class MultipleCondition extends AbstractCondition {
    private List<AbstractCondition> conditions;
    private LogicType logic;

    public MultipleCondition(EntityDefinition primaryEntityDefinition, List<AbstractAction> then, List<AbstractAction> elsE, List<AbstractCondition> conditions, LogicType logic) {
        super(primaryEntityDefinition, ActionType.MULTIPLE_CONDITION, then, elsE);
        this.conditions = conditions;
        this.logic = logic;
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
