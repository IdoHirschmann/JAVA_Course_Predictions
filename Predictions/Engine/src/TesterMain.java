import manager.PredictionManager;

public class TesterMain {
    public static void main(String[] args) {
        PredictionManager predictionManager = new PredictionManager();
        String filePath = "C:\\Users\\97252\\Desktop\\Java Course\\ex1-cigarets.xml";

        try {
            predictionManager.loadXmlData(filePath);
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
