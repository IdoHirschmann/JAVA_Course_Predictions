package rule.action.context.impl;

import entity.instance.EntityInstance;
import entity.instance.EntityInstanceManager;
import property.instance.AbstractPropertyInstance;
import rule.action.context.api.ActionContext;

import java.util.Map;

public class ActionContextImpl implements ActionContext {
    private EntityInstance primaryEntity;
    private EntityInstanceManager entityManager;
    private final Map<String, AbstractPropertyInstance> environmentVar;

    public ActionContextImpl(Map<String, AbstractPropertyInstance> environmentVar) {
        this.environmentVar = environmentVar;
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

    @Override
    public AbstractPropertyInstance getEnvironmentVariable(String name) {
        return environmentVar.get(name);
    }
}
