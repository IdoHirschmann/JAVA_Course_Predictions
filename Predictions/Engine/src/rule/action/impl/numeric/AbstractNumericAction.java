package rule.action.impl.numeric;

import entity.definition.EntityDefinition;
import property.instance.AbstractPropertyInstance;
import rule.action.ActionType;
import rule.action.context.api.ActionContext;
import rule.action.impl.AbstractAction;

import static utills.helperFunction.Helper.isDecimal;

public abstract class AbstractNumericAction extends AbstractAction {
    private String resultProp;

    public AbstractNumericAction(EntityDefinition primaryEntityDefinition, ActionType type, String resultProp) {
        super(primaryEntityDefinition, type);
        this.resultProp = resultProp;
    }

    protected Number extractANumber(ActionContext context) {
        AbstractPropertyInstance property = context.getEnvironmentVariable(resultProp);
        String propertyValue;

        if(property == null) {
            property = context.getPrimaryEntityInstance().getProperty(resultProp);
        }

        if(property != null) {
            propertyValue = property.getValue();
            if (IsANumber(property)) {

                if(isDecimal(propertyValue)){
                    return Integer.parseInt(propertyValue);
                } else {
                    return Float.parseFloat(propertyValue);
                }

            } else {
                throw new RuntimeException();
                //todo - exception (not a number)
            }
        }
        else {
            throw new RuntimeException();
            //todo - exception (property not exist)
        }
    }

    protected AbstractPropertyInstance extractProperty(ActionContext context) {
        AbstractPropertyInstance res = context.getEnvironmentVariable(resultProp);

        if(res == null) {
            res = context.getPrimaryEntityInstance().getProperty(resultProp);
        }

        if(res != null) {
            return res;
        }
        else {
            throw new RuntimeException();
            //todo - exception (not existing property)
        }
    }

    protected Boolean IsANumber(AbstractPropertyInstance property) {
        String propertyVal = property.getValue();
        return propertyVal.matches("-?\\d+(\\.\\d+)?");
        //todo - check if really work
    }
}
