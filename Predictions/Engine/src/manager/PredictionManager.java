package manager;

import option1.XmlFullPathDTO;
import option2.SimulationDefinitionDTO;
import option3.*;
import simulation.impl.Simulation;
import simulation.definition.SimulationDefinition;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PredictionManager {
    private SimulationDefinition simulationDefinition;
    private List<Simulation> simulations;
    private XmlLoader xmlLoader;

    public PredictionManager() {
        simulationDefinition = null;
        simulations = new ArrayList<>();
        xmlLoader = new XmlLoader();
    }

    public void loadXmlData(XmlFullPathDTO xmlFullPathDTO) throws JAXBException, IOException {
        SimulationDefinition newSimulationDefinition = xmlLoader.loadXmlData(xmlFullPathDTO.getFullPathXML());
        this.simulationDefinition = newSimulationDefinition;
    }


    public EnvironmentDefinitionListDTO runSimulationStep1() {

        return null;
        //todo ^^^^
    }

    public SimulationFinishDTO runSimulationStep2(EnvironmentInitListDTO environmentInitListDTO) {
        //todo
        return null;
    }

    public SimulationDefinitionDTO showCurrentSimulationData() {
        //todo

        return null;
    }

    public SimulationDefinition getSimulationDefinition() {
        return simulationDefinition;
    }
}
