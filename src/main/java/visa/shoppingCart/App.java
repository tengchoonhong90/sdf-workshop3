package visa.shoppingCart;

public class App 
{
    private static String defaultDb= "/Users/tengchoonhong/Desktop/visa/day_3/sdf-workshop3/fruitsdb";
    public static void main( String[] args )
    {
        // print out first argument db name use to create the directory
        if(args.length > 0)
            if(args[0] != null){
                System.out.println( args[0] );
                App.defaultDb = args[0];
            }
        System.out.println( defaultDb );
        Repository repo = new Repository(defaultDb);
        Session session = new Session(repo);
        session.start();

    }
}