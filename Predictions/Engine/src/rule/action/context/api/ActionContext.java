package rule.action.context.api;

import entity.instance.EntityInstance;
import entity.instance.EntityInstanceManager;
import property.instance.AbstractPropertyInstance;

public interface ActionContext {
    EntityInstance getPrimaryEntityInstance();
    void setEntityManager(EntityInstanceManager entityManager);
    void setPrimaryEntityInstance(EntityInstance entity);
    void removeEntity(EntityInstance entity);
}
