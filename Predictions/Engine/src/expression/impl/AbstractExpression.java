package expression.impl;

import expression.ExpressionType;
import expression.api.Expression;

public abstract class AbstractExpression implements Expression {
    private final String value;
    private ExpressionType type;

    protected String getValue() {
        return value;
    }

    public AbstractExpression(String value, ExpressionType type) {
        this.value = value;
        this.type = type;
    }

    protected void setType(ExpressionType type) {
        this.type = type;
    }

    public ExpressionType getType() {
        return type;
    }
}
