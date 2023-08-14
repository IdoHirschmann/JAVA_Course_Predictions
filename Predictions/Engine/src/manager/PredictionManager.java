package manager;

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

    public void loadXmlData(String filePath) throws JAXBException, IOException {
        //todo - need to change the input to DTO (the string its just for testing)
        simulationDefinition = xmlLoader.loadXmlData(filePath);
    }
}
