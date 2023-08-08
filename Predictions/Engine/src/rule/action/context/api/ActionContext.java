package rule.action.context.api;

import entity.instance.EntityInstance;
import property.instance.AbstractPropertyInstance;

public interface ActionContext {
    EntityInstance getPrimaryEntityInstance();
    void setEntityInstance(EntityInstance entity);
    void removeEntity(EntityInstance entity);
    AbstractPropertyInstance getEnvironmentVariable(String name);
}
