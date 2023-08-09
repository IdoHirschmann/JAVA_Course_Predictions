package simulation.definition;

import entity.definition.EntityDefinition;
import expression.impl.property.AbstractPropertyExpression;
import property.definition.PropertyDefinition;
import rule.Rule;
import termination.Termination;

import java.util.List;
import java.util.Map;

public class SimulationDefinition {
    //Need factory to this class?
    private final Map<String, EntityDefinition> entitiesDef;
    private final Map<String, PropertyDefinition> environmentsDef;
    private final List<Rule> rules;
    private final AbstractPropertyExpression propertyExpression;
    private final Termination termination;

    public SimulationDefinition(Map<String, EntityDefinition> entitiesDef, Map<String, PropertyDefinition> environmentsDef, List<Rule> rules,AbstractPropertyExpression propertyExpression, Termination termination) {
        this.entitiesDef = entitiesDef;
        this.environmentsDef = environmentsDef;
        this.rules = rules;
        this.propertyExpression= propertyExpression;
        this.termination = termination;
    }

    public Map<String, EntityDefinition> getEntitiesDef() {
        return entitiesDef;
    }

    public Map<String, PropertyDefinition> getEnvironmentsDef() {
        return environmentsDef;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public AbstractPropertyExpression getPropertyExpression() {
        return propertyExpression;
    }

    public Termination getTermination() {
        return termination;
    }
}
