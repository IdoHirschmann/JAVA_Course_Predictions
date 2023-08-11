package simulation.impl;

import entity.instance.EntityInstanceManager;
import expression.impl.property.AbstractPropertyExpression;
import property.instance.AbstractPropertyInstance;
import rule.Rule;
import simulation.api.EnvironmentsSimulation;
import termination.Termination;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static utills.helperFunction.Helper.setCurrentSimulation;

public class Simulation implements EnvironmentsSimulation {
    //Need factory to this class?
    private Map<String, EntityInstanceManager> entityManager;
    private final Map<String, AbstractPropertyInstance> environments;
    private List<Rule> rules;
    private Termination termination;
    private String formattedDate;
    private int identifyNumber;

    public Simulation(Map<String, EntityInstanceManager> entityManager, Map<String, AbstractPropertyInstance> environments, List<Rule> rules, Termination termination, int identifyNumber) {
        this.entityManager = entityManager;
        this.environments = environments;
        this.rules = rules;
        this.termination = termination;
        this.identifyNumber = identifyNumber;

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy | HH.mm.ss");
        formattedDate = now.format(formatter);
    }

    public AbstractPropertyInstance getEnvironment(String environmentName) {
        return environments.get(environmentName);
    }

    public Map<String, AbstractPropertyInstance> getEnvironments() {
        return environments;
    }

    public void runSimulation() {
        setCurrentSimulation(this); //this is the first thing you do when running the simulation
        //todo - holy moly :(
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Simulation that = (Simulation) o;
        return identifyNumber == that.identifyNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifyNumber);
    }
}
