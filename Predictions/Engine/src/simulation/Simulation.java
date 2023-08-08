package simulation;

import entity.definition.EntityDefinition;
import entity.instance.EntityInstanceManager;
import property.definition.PropertyDefinition;
import property.instance.AbstractPropertyInstance;
import rule.Rule;
import termination.Termination;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Simulation {
    //Need factory to this class?
    private Map<String, EntityInstanceManager> entityManager;
    private Map<String, AbstractPropertyInstance> environments;
    private List<Rule> rules;
    private Termination termination;
    private LocalDate simulationStartTime;
    private int identifyNumber;

    public Simulation(Map<String, EntityInstanceManager> entityManager, Map<String, AbstractPropertyInstance> environments, List<Rule> rules, Termination termination, int identifyNumber) {
        this.entityManager = entityManager;
        this.environments = environments;
        this.rules = rules;
        this.termination = termination;
        this.identifyNumber = identifyNumber;
        simulationStartTime = LocalDate.now();
    }
    public void RunSimulation() {
        //todo - holy moly :(
    }
}
