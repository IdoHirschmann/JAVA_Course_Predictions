import manager.PredictionManager;
import property.instance.AbstractPropertyInstance;
import simulation.impl.Simulation;

import java.util.Map;

import static factory.instance.FactoryInstance.createSimulation;

public class TesterMain {
    public static void main(String[] args) {
        PredictionManager predictionManager = new PredictionManager();
        String filePath = "C:\\Users\\97252\\Desktop\\Java Course\\ex1-cigarets.xml";
        Simulation simulation = null;
        try {
            predictionManager.loadXmlData(filePath);
            simulation = createSimulation(predictionManager.getSimulationDefinition(), 0);

            simulation.getEnvironments().forEach((name,environment) -> {
                if(name.equals("cigarets-critical")) {
                    environment.setValue("900");
                }
                if(name.equals("cigarets-decrease-already-smoker")) {
                    environment.setValue("68");
                }
                if(name.equals("cigarets-increase-non-smoker")) {
                    environment.setValue("3");
                }
                if(name.equals("cigarets-increase-already-smoker")) {
                    environment.setValue("30");
                }
            });
            simulation.runSimulation();

        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
