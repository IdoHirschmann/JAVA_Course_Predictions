package rule.action.impl.calculation;

import entity.definition.EntityDefinition;
import expression.api.Expression;
import rule.action.ActionType;
import rule.action.impl.AbstractAction;

public abstract class AbstractCalculation extends AbstractAction {
    private String resultProp;
    private Expression firstArgument;
    private Expression secondArgument;

    public AbstractCalculation(EntityDefinition primaryEntityDefinition, ActionType type, String resultProp, Expression firstArgument, Expression secondArgument) {
        super(primaryEntityDefinition, type);
        this.resultProp = resultProp;
        this.firstArgument = firstArgument;
        this.secondArgument = secondArgument;
    }
}
