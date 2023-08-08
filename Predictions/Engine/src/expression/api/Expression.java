package expression.api;

import entity.instance.EntityInstance;

public interface Expression {
    String GetSimpleValue();
    String GetExplicitValue(EntityInstance entity) throws Exception;
}
