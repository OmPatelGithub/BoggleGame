import java.io.IOException;

public abstract class User {
    
    private String username;

    private int password;

    private int score;

    /**
     * All User must accept actions, for registration or signing up purposes
     *
     * @param action Action (used to evaluate registration)
     */
    abstract void accept(ActOnStatus action) throws IOException;
}
