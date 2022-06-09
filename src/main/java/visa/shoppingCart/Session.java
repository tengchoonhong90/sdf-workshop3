package visa.shoppingCart;

import java.io.Console;
import java.util.List;

public class Session {
    
    public static final String LIST = "list";
    public static final String CARTS = "carts";
    public static final String ADD = "add";
    public static final String DELETE = "delete";
    public static final String LOAD = "load";
    public static final String USERS = "users";
    public static final String SAVE = "save";
    public static final String LOGIN = "login";
    public static final String END = "end";

    private Repository repository;
    private Cart currCart;

    public Session(Repository repo) {
        this.repository = repo;
    }

    public void start() {
        Console cons = System.console();
        boolean stop = false;
        currCart = new Cart("Anonymous");

        while(!stop) {
            String input= cons.readLine("> ");
            String delimiter = ("[ ,]+");
            String[] terms = input.split(delimiter);
            
            switch(terms[0]) {
                case CARTS:
                    System.out.println("List of Shopping carts");
                    //list carts db files
                    //TODO
                break;

                case LIST:
                    System.out.printf("Items in %s's shopping cart\n", currCart.getUsername());
                    printList(currCart.getContents());
                break;

                case ADD:
                    int before = currCart.getContents().size();
                    for (int i = 1; i < terms.length; i++)
                        currCart.add(terms[i]);
                    int addedCount = currCart.getContents().size() - before;
                    System.out.printf("Added %d items(s) to %s;s cart\n", addedCount, currCart.getUsername());
                break;

                case DELETE:
                    int idx = Integer.parseInt(terms[1]);
                    String item = currCart.delete(idx);
                    System.out.printf("Removed %s from %s's cart", item, currCart.getUsername());
                break;

                case LOAD:
                    //currCart = reps
                    //TODO
                break;

                case USERS:
                    //TODO
                break;

                case SAVE:
                    //TODO
                break;

                case LOGIN:
                    currCart = new Cart(terms[1]);
                break;

                case END:
                    stop = true;
                break;

                default:
                    System.err.printf("Unknown input: %s\n", terms[0]);
            }
            System.out.println("");
        }
        System.out.println("Thank you for shopping with us");
    }

    public void printList(List<String> list) {
        if(list.size() <=0) {
            System.out.println("No records found");
            return;
        }

        for (int i = 1; i < list.size(); i++) {
            System.out.printf("%d. %s\n", (i+1), list.get(i));
        }
    }
}