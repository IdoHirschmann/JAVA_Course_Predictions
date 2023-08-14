import manager.PredictionManager;
import simulation.impl.Simulation;

import static factory.instance.FactoryInstance.createSimulation;

public class TesterMain {
    public static void main(String[] args) {
        PredictionManager predictionManager = new PredictionManager();
        String filePath = "C:\\Users\\97252\\Desktop\\Java Course\\ex1-cigarets.xml";

        try {
            predictionManager.loadXmlData(filePath);
        } catch (Exception exception) {
            System.out.println(exception);
        }

        Simulation simulation = createSimulation(predictionManager.getSimulationDefinition(), 0);
    }
}
