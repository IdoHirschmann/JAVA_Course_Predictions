package manager;

import simulation.Simulation;
import simulation.definition.SimulationDefinition;

import java.util.ArrayList;
import java.util.List;

public class PredictionManager {
    SimulationDefinition simulationDefinition;
    List<Simulation> simulations;

    public PredictionManager() {
        simulationDefinition = null;
        simulations = new ArrayList<>();
    }
}
