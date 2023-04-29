import java.io.IOException;

public interface Action {

    /**
     * sign up (visit) an unregistered user
     */
    abstract void signup(UnregisteredUser user) throws IOException;

    /**
     * log in (visit) an registered user
     */
    abstract void login(RegisteredUser user);

    /**
     * display the NO. of a player
     */
    abstract void display();
}
