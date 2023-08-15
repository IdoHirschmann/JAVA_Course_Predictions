package rule.action.context.impl;

import entity.instance.EntityInstance;
import entity.instance.EntityInstanceManager;
import property.instance.AbstractPropertyInstance;
import rule.action.context.api.ActionContext;

import java.util.Map;

//todo - remmber to update the context before every action

public class ActionContextImpl implements ActionContext {
    private EntityInstance primaryEntity;
    private EntityInstanceManager entityManager;

    public ActionContextImpl() {
        primaryEntity = null;
        entityManager = null;
    }

    @Override
    public void setEntityManager(EntityInstanceManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public EntityInstance getPrimaryEntityInstance() {
        return primaryEntity;
    }

    @Override
    public void setPrimaryEntityInstance(EntityInstance entity) {
        this.primaryEntity = entity;
    }

    @Override
    public void removeEntity(EntityInstance entity) {
        entityManager.killEntity(entity);
    }

}
