package rule.action.impl.condition;


import entity.definition.EntityDefinition;
import rule.action.ActionType;
import rule.action.context.api.ActionContext;
import rule.action.impl.AbstractAction;

import java.util.List;

public abstract class AbstractCondition extends AbstractAction {
    private List<AbstractAction> then;
    private List<AbstractAction> elsE;

    public AbstractCondition(EntityDefinition primaryEntityDefinition, ActionType type, List<AbstractAction> then, List<AbstractAction> elsE) {
        super(primaryEntityDefinition, type);
        this.then = then;
        this.elsE = elsE;
    }

    private void InvokeThen(ActionContext context) {
        then.forEach(action -> action.Invoke(context));
    }

    private void InvokeElsE(ActionContext context) {
        elsE.forEach(action -> action.Invoke(context));
    }

    protected abstract boolean runCondition(ActionContext context);
}
