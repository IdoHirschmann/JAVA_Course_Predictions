package rule.action.impl;

import entity.definition.EntityDefinition;
import expression.api.Expression;
import rule.action.ActionType;
import rule.action.context.api.ActionContext;

public class Decrease extends AbstractAction {
    String propertyName;
    Expression by;

    public Decrease(EntityDefinition primaryEntityDefinition, String propertyName, Expression by) {
        super(primaryEntityDefinition, ActionType.DECREASE);
        this.propertyName = propertyName;
        this.by = by;
    }

    @Override
    public void Invoke(ActionContext context) {
        //todo - remember: the property can be property in the entityInstance or environment!!
    }
}
