package rule;

import entity.definition.EntityDefinition;
import entity.instance.EntityInstance;
import entity.instance.EntityInstanceManager;
import rule.action.api.Action;
import rule.action.context.api.ActionContext;
import rule.action.context.impl.ActionContextImpl;
import rule.action.impl.Kill;
import rule.activation.Activation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Rule {
    private String name;
    private Activation activation;
    private List<Action> actions;
    private ActionContext context;

    public Rule(String name, Activation activation, List<Action> actions) {
        this.name = name;
        this.activation = activation;
        this.actions = actions;
        context = new ActionContextImpl();
    }

    public void activate(Map<String, EntityInstanceManager> entityInstanceManagerMap)
    {
        actions.forEach(action -> runAction(action, entityInstanceManagerMap));
    }

    private void runAction(Action action , Map<String, EntityInstanceManager> entityInstanceManagerMap) {
        String entityMangerName = action.getPrimaryEntityDefinition().getName();
        EntityInstanceManager primaryEntity =  entityInstanceManagerMap.get(entityMangerName);

        context.setEntityManager(primaryEntity);

        for (EntityInstance entityInstance : primaryEntity.getEntityInstanceList()) {
            context.setPrimaryEntityInstance(entityInstance);
            action.Invoke(context);
        }

        entityKiller(primaryEntity);
    }

    private void entityKiller(EntityInstanceManager primaryEntity) {
        List<EntityInstance> res = new ArrayList<>();

        for (EntityInstance entityInstance : primaryEntity.getEntityInstanceList()) {
            if(!entityInstance.getToKill()) {
                res.add(entityInstance);
            }
        }

        primaryEntity.setEntityInstanceList(res);
    }

    public boolean isActivatable(int currTick) {
        Random random = new Random();

        //todo let is check if i done it correctly
        if(currTick % activation.getTicks() == 0 && random.nextFloat() < activation.getProbability()) {
            return true;
        } else {
            return false;
        }
    }
}
