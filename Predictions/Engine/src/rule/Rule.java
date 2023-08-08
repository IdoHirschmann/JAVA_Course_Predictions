package rule;

import rule.action.context.api.ActionContext;
import rule.action.impl.AbstractAction;
import rule.activation.Activation;

import java.util.List;
import java.util.Random;

public class Rule {
    private String name;
    private Activation activation;
    private List<AbstractAction> actions;

    public Rule(String name, Activation activation, List<AbstractAction> actions) {
        this.name = name;
        this.activation = activation;
        this.actions = actions;
    }

    public void activate(ActionContext context)
    {
        actions.forEach(action -> action.Invoke(context));
    }

    public boolean isActivate(int currTick) {
        Random random = new Random();

        //todo let is check if i done it correctly
        if(currTick % activation.getTicks() == 0 && random.nextFloat() < activation.getProbabilty()) {
            return true;
        } else {
            return false;
        }
    }
}
