import manager.PredictionManager;
import property.instance.AbstractPropertyInstance;
import simulation.impl.Simulation;

import java.util.Map;

import static factory.instance.FactoryInstance.createSimulation;

public class TesterMain {
    public static void main(String[] args) {
        PredictionManager predictionManager = new PredictionManager();
        String filePath = "C:\\Users\\97252\\Desktop\\Java Course\\master-ex1.xml";
        Simulation simulation = null;
        try {
            predictionManager.loadXmlData(filePath);
            simulation = createSimulation(predictionManager.getSimulationDefinition(), 0);

            simulation.getEnvironments().forEach((name,environment) -> {
                if(name.equals("e1")) {
                    environment.setValue("45");
                }
                if(name.equals("e2")) {
                    environment.setValue("true");
                }
                if(name.equals("e3")) {
                    environment.setValue("72.8");
                }
                if(name.equals("e4")) {
                    environment.setValue("ido");
                }
            });
            simulation.runSimulation();

        }
        catch (Exception exception) {
            System.out.println(exception);
        }

    }
}
