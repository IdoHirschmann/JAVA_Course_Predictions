package rule.action.impl;

import entity.definition.EntityDefinition;
import expression.api.Expression;
import rule.action.ActionType;
import rule.action.context.api.ActionContext;
import rule.action.impl.AbstractAction;

public class Set extends AbstractAction {
    private final String property;
    private final Expression value;

    public Set(EntityDefinition primaryEntityDefinition, String property, Expression value) {
        super(primaryEntityDefinition, ActionType.SET);
        this.property = property;
        this.value = value;
    }

    @Override
    public void Invoke(ActionContext context) {
        context.getPrimaryEntityInstance().getProperty(property).setValue(value.GetExplicitValue(context.getPrimaryEntityInstance()));
    }
}
