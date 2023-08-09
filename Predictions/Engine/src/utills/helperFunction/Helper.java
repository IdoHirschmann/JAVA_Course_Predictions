package utills.helperFunction;

import property.instance.AbstractPropertyInstance;
import simulation.impl.Simulation;

import java.util.Random;

public abstract class Helper {
    private static Simulation currentSimulation;
    public static Integer random(int value){
        Random random = new Random();

        return random.nextInt(value + 1) - 1;
    }

    public static void setCurrentSimulation(Simulation i_CurrentSimulation) {
        currentSimulation = i_CurrentSimulation;
    }

    public static String environment(String name){
        AbstractPropertyInstance environmentVariable = currentSimulation.getEnvironments().get(name);

        if(environmentVariable == null){
            //todo - throw non exist environment variable ref
            throw new RuntimeException();
        }

        return environmentVariable.getValue();
    }

    public static Boolean isDecimal(String toCheck) {
        try{
            Integer.parseInt(toCheck);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
    public static Boolean isFloat(String toCheck) {
        try{
            Float.parseFloat(toCheck);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}
