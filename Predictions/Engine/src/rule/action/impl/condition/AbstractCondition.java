package rule.action.impl.condition;


import entity.definition.EntityDefinition;
import rule.action.ActionType;
import rule.action.context.api.ActionContext;
import rule.action.impl.AbstractAction;

import java.util.List;

public abstract class AbstractCondition extends AbstractAction {
    private List<AbstractAction> Then;
    private List<AbstractAction> Else;

    public AbstractCondition(EntityDefinition primaryEntityDefinition, ActionType type, List<AbstractAction> Then, List<AbstractAction> Else) {
        super(primaryEntityDefinition, type);
        this.Then = Then;
        this.Else = Else;
    }

    protected void invokeThen(ActionContext context) {
        if (Then != null) {
            Then.forEach(action -> action.Invoke(context));
        }
    }

    protected void invokeElse(ActionContext context) {
        if (Else != null) {
            Else.forEach(action -> action.Invoke(context));
        }
    }

    protected abstract boolean runCondition(ActionContext context);

    @Override
    public void Invoke(ActionContext context) {
        if(runCondition(context)){
            invokeThen(context);
        }else {
            invokeElse(context);
        }
    }
}
