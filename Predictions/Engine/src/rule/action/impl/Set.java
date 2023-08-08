package rule.action.impl;

import entity.definition.EntityDefinition;
import expression.api.Expression;
import rule.action.ActionType;
import rule.action.context.api.ActionContext;
import rule.action.impl.AbstractAction;

public class Set extends AbstractAction {
    private String property;
    private Expression value;

    public Set(EntityDefinition primaryEntityDefinition, String property, Expression value) {
        super(primaryEntityDefinition, ActionType.SET);
        this.property = property;
        this.value = value;
    }

    @Override
    public void Invoke(ActionContext context) {
        //todo - remember: the property can be property in the entityInstance or environment!!
    }
}
