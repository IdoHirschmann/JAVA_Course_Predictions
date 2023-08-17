import manager.PredictionManager;
import manager.UIManager;
import option1.XmlFullPathDTO;
import simulation.impl.Simulation;

import static factory.instance.FactoryInstance.createSimulation;

public class TesterMain {
    public static void main(String[] args) {
//        PredictionManager predictionManager = new PredictionManager();
//        String filePath = "C:\\Users\\97252\\Desktop\\Java Course\\ex1-cigarets.xml";
//        XmlFullPathDTO xmlFullPathDTO = new XmlFullPathDTO(filePath);
//        Simulation simulation = null;
//        try {
//            predictionManager.loadXmlData(xmlFullPathDTO);
//            simulation = createSimulation(predictionManager.getSimulationDefinition(), 0);
//
//            simulation.getEnvironments().forEach((name,environment) -> {
//                if(name.equals("cigarets-critical")) {
//                    environment.setValue("1900");
//                }
//                if(name.equals("cigarets-decrease-already-smoker")) {
//                    environment.setValue("55");
//                }
//                if(name.equals("cigarets-increase-non-smoker")) {
//                    environment.setValue("3");
//                }
//                if(name.equals("cigarets-increase-already-smoker")) {
//                    environment.setValue("55");
//                }
//            });
//            simulation.runSimulation();
//
//            System.out.println("finished!");
//        }
//        catch (Exception exception) {
//            System.out.println(exception);
//        }
        UIManager uiManager = new UIManager();
        uiManager.predictionMenu();
    }
}
