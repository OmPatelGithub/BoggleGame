import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ActOnStatus implements Action{
    private int accountNo = 0;

    /**
     * Constructor
     *
     */
    public void ActOnStatus() {
        ActOnStatus action = new ActOnStatus();
    }

    /**
     * sign up (visit) an unregistered user
     */
    public void signup(UnregisteredUser user) throws IOException {
        boolean created = false;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Create your username: ");
        String username = scanner.nextLine();

        try {
            File file = new File("info.csv");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String[] data = reader.nextLine().split(", ");
                if (data[0].equals(username)) {
                    created = true;
                    System.out.println("You already have an account :)");
                    break;
                }
            }
            reader.close();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (!created) {
            System.out.println("Create your password, please only use numbers: ");
            int password = Integer.parseInt(scanner.nextLine());
            user.RegisterUser(username, password);
            accountNo++;
        }

    }

    /**
     * log in (visit) a registered user.
     *
     * if a user has already signup, then terminate the process.
     */
    public void login(RegisteredUser user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your username: ");
        String usernameCheck = scanner.nextLine();

        int passwordFromFile = 0;

        try {
            File file = new File("info.csv");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String[] data = reader.nextLine().split(", ");
                if (data[0].equals(usernameCheck)) {
                    passwordFromFile = Integer.parseInt(data[1]);
                }
            }
            reader.close();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Input your password: ");
        int passwordCheck = Integer.parseInt(scanner.nextLine());

        while (passwordCheck != passwordFromFile) {
            System.out.println("Password Incorrect. Try enter again: ");
            passwordCheck = Integer.parseInt(scanner.nextLine());
        }

        user.RegisterUser(usernameCheck);
    }

    /**
     * display the NO. of a player
     */
    public void display() {
        System.out.println("No. of the player: " + accountNo);
    }
}
