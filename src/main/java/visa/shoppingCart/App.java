package visa.shoppingCart;

public class App 
{
    private static String defaultDb = "db";
    public static void main( String[] args )
    {
        //print out first argument db name used to create the directory
        if (args[0] != null) {
            System.out.println(args[0]);
            App.defaultDb = args[0];

        }
        System.out.println(defaultDb);

    }
}
