package rule.action.impl.numeric.calculation;

import entity.definition.EntityDefinition;
import expression.ExpressionType;
import expression.api.Expression;
import rule.action.ActionType;
import rule.action.context.api.ActionContext;

import static utills.string.StringConvertor.convertStringToFloat;
import static utills.string.StringConvertor.convertStringToInt;

public class Multiply extends AbstractCalculation {
    public Multiply(EntityDefinition primaryEntityDefinition, String resultProp, Expression firstArgument, Expression secondArgument) {
        super(primaryEntityDefinition, ActionType.MULTIPLY, resultProp, firstArgument, secondArgument);
    }

    @Override
    public void Invoke(ActionContext context) {
        Number result;

        //todo- ask aviad if in the creating of the actions will we already check the acutal value of the expressions so here well have them both as numbers
        if(getFirstArgument().getType() == ExpressionType.FLOAT || getSecondArgument().getType() == ExpressionType.FLOAT){
            result = convertStringToFloat(getFirstArgument().GetExplicitValue(context.getPrimaryEntityInstance())) *
                    convertStringToFloat(getSecondArgument().GetExplicitValue(context.getPrimaryEntityInstance()));
        }
        else{
            result = convertStringToInt(getFirstArgument().GetExplicitValue(context.getPrimaryEntityInstance())) *
                    convertStringToInt(getSecondArgument().GetExplicitValue(context.getPrimaryEntityInstance()));
        }

        extractProperty(context).setValue(result.toString());
    }
}
