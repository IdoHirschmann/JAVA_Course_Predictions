package manager;

import option1.XmlFullPathDTO;
import option2.*;
import option3.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UIManager {
    private PredictionManager predictionManager = new PredictionManager();

    public void predictionMenu() {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean isXmlLoaded = false;
        boolean isSimulationRun = false;

        printPredictionWelcome();
        while (true) {
            printMenu();
            input = scanner.nextLine();
            System.out.println();

            if (input.matches("^[1-5]$")) {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1:
                        System.out.println("Load new XML file");
                        System.out.println("-----------------");
                        isXmlLoaded = isXmlLoaded || loadXmlFile(scanner);
                        break;
                    case 2:
                        if(checkIfXmlLoaded(isXmlLoaded, "Show current simulation data")) {
                            System.out.println("Show current simulation data");
                            System.out.println("----------------------------");
                            showCurrentSimulationData();
                        }
                        break;
                    case 3:
                        if(checkIfXmlLoaded(isXmlLoaded, "Run new simulation")) {
                            System.out.println("Run new simulation");
                            System.out.println("----------------------");

                            isSimulationRun = isSimulationRun || runSimulation(scanner);
                        }
                        break;
                    case 4:
                        if(checkIfSimulationRun(isSimulationRun)) {
                            System.out.println("View past simulation information");
                            System.out.println("--------------------------------");
                            // Perform action for option 4
                        }
                        break;
                    case 5:
                        System.out.println("Exiting the menu");
                        System.out.println("----------------");
                        scanner.close();
                        return;
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
            }
        }
    }
    private void printPredictionWelcome() {
        System.out.println("==============================");
        System.out.println("   Welcome to Prediction Menu");
        System.out.println("==============================");
        System.out.println();
    }
    private void printMenu() {
        System.out.println("-Menu-");
        System.out.println("  1. Load new XML file");
        System.out.println("  2. Show current simulation data");
        System.out.println("  3. Run new simulation");
        System.out.println("  4. View past simulation information");
        System.out.println("  5. Exit");
        System.out.print("Enter your choice (1-5): ");
    }

    private boolean loadXmlFile(Scanner scanner) {
        String xmlFilePath;
        System.out.print("  Please enter full path to your xml file: ");
        xmlFilePath = scanner.nextLine();
        XmlFullPathDTO xmlFullPathDTO = new XmlFullPathDTO(xmlFilePath);

        try {
            predictionManager.loadXmlData(xmlFullPathDTO);
            return true;
        }
        catch (Exception exception) {
            System.out.println("\nERROR: " + exception.getMessage() + "\n");
            return false;
        }
    }


    private void showCurrentSimulationData() {
        SimulationDefinitionDTO simulationDefinitionDTO = predictionManager.showCurrentSimulationData();
        System.out.println("-Simulation Information-\n");
        printEntities(simulationDefinitionDTO.getEntityDefinitionDTOList());
        printRules(simulationDefinitionDTO.getRulesDTOList());
        printTermination(simulationDefinitionDTO.getTerminationDTO());
    }
    private void printEntities(List<EntityDefinitionDTO> entityDefinitionDTOList) {
        int counter = 1;

        System.out.println("  Entities:");
        for (EntityDefinitionDTO entityDefinitionDTO : entityDefinitionDTOList) {
            System.out.println("   - Entity number " + counter + ":");
            System.out.println("     1) Name: ------------- " + entityDefinitionDTO.getName());
            System.out.println("     2) Population: ------- " + entityDefinitionDTO.getPopulationNumber());
            printProperties(entityDefinitionDTO.getProperties());
            counter++;
        }
    }
    private void printProperties(List<PropertyDefinitionDTO> propertyDefinitionDTOList) {
        System.out.println("     3) Properties:");
        for (PropertyDefinitionDTO propertyDefinitionDTO : propertyDefinitionDTOList) {
            System.out.println("       * Name: ------------ " + propertyDefinitionDTO.getName());
            System.out.println("       * Type: ------------ " + propertyDefinitionDTO.getType());
            if(propertyDefinitionDTO.getRangeFrom() != null) {
                System.out.println("       * Range: ----------- from " + propertyDefinitionDTO.getRangeFrom() + " to " + propertyDefinitionDTO.getRangeTo());
            }
            System.out.println("       * Is Randomize: ---- " + propertyDefinitionDTO.getRandomize() + "\n");
        }
    }
    private void printRules(List<RulesDTO> rulesDTOList) {
        int counter = 1;

        System.out.println("  Rules:");
        for (RulesDTO rulesDTO : rulesDTOList) {
            System.out.println("   - Rule number " + counter + ":");
            System.out.println("     1) Name: ---------------- " + rulesDTO.getName());
            System.out.println("     2) Ticks: --------------- " + rulesDTO.getTicks());
            System.out.println("     3) Probability: --------- " + rulesDTO.getProbability());
            System.out.println("     4) Number of actions: --- " + rulesDTO.getActionCounter());
            System.out.print("     5) Action types: -------- ");

            for (String str : rulesDTO.getActionTypes()) {
                System.out.print(str + "  ");
            }
            System.out.println();
            counter++;
        }
    }
    private void printTermination(TerminationDTO terminationDTO) {
        System.out.println("   - Terminations:");
        if(terminationDTO.getTicks() != null) {
            System.out.println("     * Ticks: --------------- " + terminationDTO.getTicks());
        }
        if(terminationDTO.getSeconds() != null) {
            System.out.println("     * Seconds: ------------- " + terminationDTO.getSeconds());
        }

        System.out.println();
    }


    private boolean runSimulation(Scanner scanner) {
        try {
            System.out.println("-Run new simulation-\n");
            EnvironmentDefinitionListDTO environmentDefinitionListDTO = runSimulationHelper1();
            SimulationFinishDTO simulationFinishDTO = runSimulationHelper2(environmentDefinitionListDTO, scanner);

            System.out.println("  Simulation finished!");
            System.out.println("   - Simulation id: -----------" + simulationFinishDTO.getSimulationID());
            System.out.println("   - Simulation stop cause: ---" + simulationFinishDTO.getSimulationStopCause());
            System.out.println();
            return true;
        }
        catch (Exception exception) {
            System.out.println("\nERROR: " + exception.getMessage() + "\n");
            return false;
        }
    }
    private EnvironmentDefinitionListDTO runSimulationHelper1() {
        return predictionManager.runSimulationStep1();
    }
    private SimulationFinishDTO runSimulationHelper2( EnvironmentDefinitionListDTO environmentDefinitionListDTO, Scanner scanner) {
        List<EnvironmentInitDTO> environmentInitDTOList = new ArrayList<>();
        for (EnvironmentDefinitionDTO environmentDefinitionDTO : environmentDefinitionListDTO.getEnvironmentDefinitionDTOList()) {
            environmentInitDTOList.add(createEnvironmentInit(environmentDefinitionDTO, scanner));
        }
        EnvironmentInitListDTO environmentsIntDTO = new EnvironmentInitListDTO(environmentInitDTOList);

        return predictionManager.runSimulationStep2(environmentsIntDTO);
    }
    private EnvironmentInitDTO createEnvironmentInit(EnvironmentDefinitionDTO environmentDefinitionDTO, Scanner scanner) {
        String name = environmentDefinitionDTO.getName();
        String type = environmentDefinitionDTO.getType();
        String from = environmentDefinitionDTO.getRangeFrom();
        String to = environmentDefinitionDTO.getRangeTo();
        String value = null;

        System.out.println("  Creating environment: " + name);
        boolean isUserInput = environmentCreationMenu(scanner);

        switch(type) {
            case "decimal":
                if(from != null) {
                    value = getIntFromUser(from, to, isUserInput, scanner);
                }
                else {
                    value = getIntFromUserNoBounds(isUserInput, scanner);
                }
                break;
            case "float":
                if(from != null) {
                    value = getFloatFromUser(from, to, isUserInput, scanner);
                }
                else {
                    value = getFloatFromUserNoBounds(isUserInput, scanner);
                }
                break;
            case "boolean":
                value = getBooleanFromUser(isUserInput, scanner);
                break;
            case "string":
                value = getStringFromUser(isUserInput, scanner);
                break;
        }

        return new EnvironmentInitDTO(environmentDefinitionDTO.getName(), value);
    }
    private boolean environmentCreationMenu(Scanner scanner) {
        while (true) {
            System.out.println("   - Do you want to put specific value?");
            System.out.println("      1) Yes");
            System.out.println("      2) No");
            System.out.print("     Enter your choice (1-2): ");
            String input = scanner.nextLine();

            if (input.matches("^[1-2]$")) {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1:
                        return true;
                    case 2:
                        return false;
                }
            }
            else {
                System.out.println("Error: Invalid input! Please enter 1 or 2\n");
            }
        }
    }
    private String getIntFromUser(String from, String to, boolean isUserInput, Scanner scanner) {
        //todo - check carefully this function
        if (isUserInput) {
            String rangePattern = "^" + from + "|" + to + "$";
            while (true) {
                System.out.print("    Please enter a decimal number between " + from + " - " + to + ": ");
                String input = scanner.nextLine();
                if (input.matches(rangePattern)) {
                    return input;
                }
               else {
                   System.out.println("Error: Invalid input! Please enter decimal number between " + from + " - " + to +".\n");
               }
           }
        }
        else {
            Random random = new Random();
            int lowerBound = (int) Math.ceil(Integer.parseInt(from));
            int upperBound = (int) Math.floor(Integer.parseInt(to));
            int randomNumber = lowerBound + random.nextInt(upperBound - lowerBound + 1);
            return Integer.toString(randomNumber);
        }
    }
    private String getIntFromUserNoBounds(boolean isUserInput, Scanner scanner) {
        if(isUserInput) {
            while (true) {
                System.out.print("    Please enter a decimal number:");
                String input = scanner.nextLine();
                if (isValidInteger(input)) {
                    return input;
                }
                else {
                    System.out.println("Error: Invalid input! Please enter decimal number.\n");
                }
            }
        }
        else {
            Random random = new Random();
            Integer randomInt = random.nextInt(100);
            return randomInt.toString();
        }
    }
    private String getFloatFromUser(String from, String to, boolean isUserInput, Scanner scanner) {
        //todo - check carefully this function
        if (isUserInput) {
            String rangePattern = "^" + from + "|" + to + "$";
            while (true) {
                System.out.print("    Please enter a float number between " + from + " - " + to + ": ");
                String input = scanner.nextLine();
                if (input.matches(rangePattern)) {
                    return input;
                }
                else {
                    System.out.println("Error: Invalid input! Please enter float number between " + from + " - " + to +".\n");
                }
            }
        }
        else {
            Random random = new Random();
            double randomNumber = Double.parseDouble(from) + (random.nextDouble() * (Double.parseDouble(to) - Double.parseDouble(from)));
            return Double.toString(randomNumber);
        }
    }
    private String getFloatFromUserNoBounds(boolean isUserInput, Scanner scanner) {
        if(isUserInput) {
            while (true) {
                System.out.print("    Please enter a float number:");
                String input = scanner.nextLine();
                if (isValidFloat(input)) {
                    return input;
                }
                else {
                    System.out.println("Error: Invalid input! Please enter float number.\n");
                }
            }
        }
        else {
            Random random = new Random();
            Float randomFloat = random.nextFloat() * 100;
            return randomFloat.toString();
        }
    }
    private String getBooleanFromUser(boolean isUserInput, Scanner scanner) {
        //todo checkkkkk
        if(isUserInput) {
            while (true) {
                System.out.print("    Please enter 1 for true / 2 for false:");
                String input = scanner.nextLine();
                if (input.matches("^[1-2]$")) {
                    int choice = Integer.parseInt(input);
                    switch (choice) {
                        case 1:
                            return "true";
                        case 2:
                            return "false";
                    }
                }
                else {
                    System.out.println("Error: Invalid input! Please enter 1 or 2.\n");
                }
            }
        }
        else {
            Random random = new Random();
            Boolean randomBoolean = random.nextBoolean();
            return randomBoolean.toString();
        }
    }
    private String getStringFromUser(boolean isUserInput, Scanner scanner) {
        if(isUserInput) {
            System.out.print("    Please enter a string:");
            return scanner.nextLine();
        }
        else {
            return randomizeString();
        }
    }




    private boolean checkIfXmlLoaded(boolean isXmlLoaded, String desireOption) {
        if(!isXmlLoaded) {
            System.out.println("ERROR: Your desire option can not be run. \n       You need to load a valid xml file before trying to " + desireOption + ".\n");
        }
        return isXmlLoaded;
    }
    private boolean checkIfSimulationRun(boolean isSimulationRun) {
        if(!isSimulationRun) {
            System.out.println("ERROR: Your desire option can not be run. \n       You need to successfully run a simulation before trying to view past simulation information.\n");
        }
        return isSimulationRun;
    }
    private boolean isValidInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private boolean isValidFloat(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private String randomizeString() {
        String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!?,_-.() ";
        int length = new Random().nextInt(50) + 1;
        StringBuilder randomString = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = new Random().nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            randomString.append(randomChar);
        }

        return randomString.toString();
    }

}
