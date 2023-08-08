package rule.action.impl;

import entity.definition.EntityDefinition;
import expression.api.Expression;
import rule.action.ActionType;
import rule.action.api.Action;
import rule.action.context.api.ActionContext;

public class Increase extends AbstractAction{
    String propertyName;
    Expression by;

    public Increase(EntityDefinition primaryEntityDefinition, String propertyName, Expression by) {
        super(primaryEntityDefinition, ActionType.INCREASE);
        this.propertyName = propertyName;
        this.by = by;
    }

    @Override
    public void Invoke(ActionContext context) {
        //todo - remember: the property can be property in the entityInstance or environment!!
    }
}
