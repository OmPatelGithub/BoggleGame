import java.io.IOException;

/**
 * The Main class for the first Assignment in CSC207, Fall 2022
 */
public class Main {
    /**
     * Main method.
     * @param args command line arguments.
     **/
    public static void main(String[] args) throws IOException {

        //        example for signing up a user and changes the user's username and password
//        UnregisteredUser user2 = new UnregisteredUser();
//        ActOnStatus action = new ActOnStatus();
//        action.signup(user2);
//        System.out.println("hello");
//        RegisteredUser user3 = new RegisteredUser();
//        System.out.println("hello2");
//        user3.RegisterUser(user2.getName());
//        System.out.println("hello3");
//        user3.resetName("DSB");
//        user3.resetPassword(777);;

//        try {
//            user2.accept(action);
//        }
//        catch(IOException ex){
//            System.out.println("IO exception");
//        }

        BoggleGame b = new BoggleGame();
        b.giveInstructions();
        b.playGame();
    }

}
