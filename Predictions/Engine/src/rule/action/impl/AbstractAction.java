package rule.action.impl;

import entity.definition.EntityDefinition;
import rule.action.ActionType;
import rule.action.api.Action;

public abstract class AbstractAction implements Action {
    private EntityDefinition primaryEntityDefinition;
    private ActionType type;

    public AbstractAction(EntityDefinition primaryEntityDefinition, ActionType type) {
        this.primaryEntityDefinition = primaryEntityDefinition;
        this.type = type;
    }

    @Override
    public EntityDefinition getPrimaryEntityDefinition() {
        return primaryEntityDefinition;
    }

    @Override
    public ActionType getType() {
        return type;
    }
}
