
public class Main {
    public static void main(String[] args) {

        try{
            ronGay();
        }
        catch ( NumberFormatException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void ronGay() {
        try
        {
            int x = Integer.parseInt("ron ha gay");
        }
        catch (NumberFormatException e)
        {
            throw e;
        }
    }


}
