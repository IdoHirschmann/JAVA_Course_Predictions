package rule.action.context.impl;

import entity.instance.EntityInstance;
import property.instance.AbstractPropertyInstance;
import rule.action.context.api.ActionContext;

public class ActionContextIMPL implements ActionContext {
    //todo - both data members and methods
    @Override
    public EntityInstance getPrimaryEntityInstance() {
        return null;
    }

    @Override
    public void setEntityInstance(EntityInstance entity) {

    }

    @Override
    public void removeEntity(EntityInstance entity) {

    }

    @Override
    public AbstractPropertyInstance getEnvironmentVariable(String name) {
        return null;
    }
}
