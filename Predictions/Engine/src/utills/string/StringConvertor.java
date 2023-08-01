package utills.string;

public abstract class StringConvertor {
    public static int convertStringToInt(String valueToConvert)
    {
        try {
            return Integer.parseInt(valueToConvert);
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException( "Method ConvertStringToInt failed! Problem " + e.getMessage() + ". Please enter decimal number. ");
        }
    }

    public static float convertStringToFloat(String valueToConvert)
    {
        try {
            return Float.parseFloat(valueToConvert);
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException( "Method ConvertStringToFloat failed! Problem " + e.getMessage() + ". Please enter float number. ");
        }
    }

    public static boolean convertStringToBool(String valueToConvert)
    {
        boolean res;

        res = (valueToConvert.equalsIgnoreCase("true") || valueToConvert.equalsIgnoreCase("false"));

        if(!res) {
            throw new IllegalArgumentException("Method ConvertStringToBool failed! Problem from input: " + valueToConvert + ". Please enter True or False. ");
        }
        else{
            return Boolean.parseBoolean(valueToConvert); //will not throw any ex because checked above completely
        }
    }
}
