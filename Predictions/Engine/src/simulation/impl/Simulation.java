package simulation.impl;

import entity.instance.EntityInstanceManager;
import property.instance.AbstractPropertyInstance;
import rule.Rule;
import rule.action.context.api.ActionContext;
import rule.action.context.impl.ActionContextImpl;
import simulation.api.EnvironmentsSimulation;
import termination.Termination;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static utills.helperFunction.Helper.setCurrentSimulation;

public class Simulation implements EnvironmentsSimulation {
    private Map<String, EntityInstanceManager> entityManager;
    private final Map<String, AbstractPropertyInstance> environments;
    private final List<Rule> rules;
    private final Termination termination;
    private String formattedDate;
    private final int identifyNumber;

    public Simulation(Map<String, EntityInstanceManager> entityManager, Map<String, AbstractPropertyInstance> environments, List<Rule> rules, Termination termination, int identifyNumber) {
        this.entityManager = entityManager;
        this.environments = environments;
        this.rules = rules;
        this.termination = termination;
        this.identifyNumber = identifyNumber;

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy | HH:mm:ss");
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
        long startTime = System.currentTimeMillis();
        long maxRuntimeMilliseconds;
        Integer ticks = termination.getTicks();
        Integer seconds = termination.getSeconds();
        Integer currTick = 1;

        if(ticks != null && seconds != null){
            maxRuntimeMilliseconds = seconds * 1000;

            for(; currTick <= ticks ; currTick++){
                if (System.currentTimeMillis() - startTime >= maxRuntimeMilliseconds) {
                    break;
                }
                simulationIteration(currTick);
            }
        } else if (ticks == null && seconds !=null) {
            boolean timesUp = false;
            maxRuntimeMilliseconds = seconds * 1000;

            while (!timesUp){
                if (System.currentTimeMillis() - startTime >= maxRuntimeMilliseconds) {
                    timesUp = true;
                    break;
                }
                simulationIteration(currTick);
                currTick++;
            }
        }else {
            for(; currTick <= ticks ; currTick++){
                simulationIteration(currTick);
            }
        }
    }

    private void simulationIteration(Integer currTick) {
        for (Rule rule : rules) {
            if(rule.isActivatable(currTick)){
                rule.activate(entityManager);
            }
        }
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
