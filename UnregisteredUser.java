import java.io.*;

public class UnregisteredUser extends User {

    private String username;

    private int password;

    private int score;

    /**
     * Constructor
     *
     * @param username username of the player
     */
    public void RegisterUser(String username, int password) throws IOException {
        this.username = username;
        this.password = password;
        this.score = 0;

        String Spassword = ((Integer) (this.password)).toString();
        String Sscore = ((Integer) (this.score)).toString();

        String[] information = {this.username, Spassword, Sscore};

        BufferedWriter bw = null;
        FileWriter fw = null;
        int infoIndex = 0;

        try {
            fw = new FileWriter("info.csv", true);
            bw = new BufferedWriter(fw);

            for (String element : information) {
                bw.write(element);
                if (infoIndex < 2) {
                    bw.write(", ");
                }
                infoIndex++;

            }

            bw.write("\n");

        }
        catch (IOException e) {
            System.out.println("File input error!");
        }
        finally {
            try {
                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            }
            catch (IOException ex) {
                System.out.println("File input error!");
            }
        }
    }

    /**
     * get name
     *
     * @return name of the user
     */
    public String getName() {
        return this.username;
    }

    /**
     * get password
     *
     * @return password of the user
     */
    public int getPassword() {
        return this.password;
    }

    /**
     * get score
     *
     * @return score of the user
     */
    public int getScore() {
        return this.score;
    }

    /**
     * accept a visitor and sign up the user
     *
     * @param action
     */
    @Override
    public void accept(ActOnStatus action) throws IOException {
        try {
            action.signup(this);
        }
        catch(IOException ex){
            System.out.println("IO exception");
        }
    }
}
