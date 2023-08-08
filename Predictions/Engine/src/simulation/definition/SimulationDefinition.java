package simulation.definition;

import entity.definition.EntityDefinition;
import property.definition.PropertyDefinition;
import rule.Rule;
import termination.Termination;

import java.util.List;
import java.util.Map;

public class SimulationDefinition {
    //Need factory to this class?
    private Map<String, EntityDefinition> entitiesDef;
    private Map<String, PropertyDefinition> environmentsDef;
    private List<Rule> rules;
    private Termination termination;

    public SimulationDefinition(Map<String, EntityDefinition> entitiesDef, Map<String, PropertyDefinition> environmentsDef, List<Rule> rules, Termination termination) {
        this.entitiesDef = entitiesDef;
        this.environmentsDef = environmentsDef;
        this.rules = rules;
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

    public Termination getTermination() {
        return termination;
    }
}