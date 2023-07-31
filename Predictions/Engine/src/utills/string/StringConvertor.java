package utills.string;

public abstract class StringConvertor {
    public static int convertStringToInt(String valueToConvert)
    {
        try {
            return Integer.parseInt(valueToConvert);
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException();
            //todo- throw our ex
        }
    }

    public static float convertStringToFloat(String valueToConvert)
    {
        try {
            return Float.parseFloat(valueToConvert);
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException();
            //todo- throw our ex
        }
    }

    public static boolean convertStringToBool(String valueToConvert)
    {
        boolean res;

        res = (valueToConvert.equalsIgnoreCase("true") || valueToConvert.equalsIgnoreCase("false"));

        if(!res) {
            throw new RuntimeException();//todo-change
            //todo- throw
        }
        else{
            return Boolean.parseBoolean(valueToConvert); //will not throw any ex because checked above completely
        }
    }
}
