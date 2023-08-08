package rule.action.api;

import entity.definition.EntityDefinition;
import rule.action.ActionType;
import rule.action.context.api.ActionContext;

public interface Action {
    ActionType getType();
    EntityDefinition getPrimaryEntityDefinition();
    void Invoke(ActionContext context);
}
