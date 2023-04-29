import java.io.*;
import java.util.Scanner;

public class RegisteredUser extends User {

    private String username;

    private int password;

    private int score;

    /**
     * Constructor
     *
     */
    public void RegisterUser(String usernamePassedIn) {
        String line = "";

        try {
            BufferedReader rd = new BufferedReader(new FileReader("info.csv"));

            while ((line = rd.readLine()) != null) {
                String[] info = line.split(", ");
                if (info[0].equals(usernamePassedIn)) {
                    this.username = info[0];
                    this.password = Integer.parseInt(info[1]);
                    this.score = Integer.parseInt(info[2]);
                    break;
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("An error occurred in looking for the file.");
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred in file IO.");
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
     * reset name
     *
     * @param newName new name of the user
     */
    public void resetName(String newName) {
        String oldName = this.username;
        this.username = newName;

        String line = "";

        try {
            BufferedReader rd = new BufferedReader(new FileReader("info.csv"));

            Scanner sc = new Scanner(new File("info.csv"));
            StringBuffer buffer = new StringBuffer();
            while (sc.hasNextLine()) {
                buffer.append(sc.nextLine() + System.lineSeparator());
            }
            String fileContents = buffer.toString();
            sc.close();

            while ((line = rd.readLine()) != null) {
                String[] info = line.split(", ");
                if (info[0].equals(oldName)) {
                    fileContents = fileContents.replaceAll(info[0], newName);
                    break;
                }
            }

            FileWriter writer = new FileWriter("info.csv");
            writer.append(fileContents);
            writer.flush();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("An error occurred in looking for the file.");
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred in file IO.");
        }
    }

    /**
     * reset password
     *
     * @param newPassword new password of the user
     */
    public void resetPassword(int newPassword) {
        int oldPassword = this.password;
        this.password = newPassword;

        String line = "";

        try {
            BufferedReader rd = new BufferedReader(new FileReader("info.csv"));

            Scanner sc = new Scanner(new File("info.csv"));
            StringBuffer buffer = new StringBuffer();
            while (sc.hasNextLine()) {
                buffer.append(sc.nextLine() + System.lineSeparator());
            }
            String fileContents = buffer.toString();
            sc.close();

            while ((line = rd.readLine()) != null) {
                String[] info = line.split(", ");
                if (info[0].equals(this.username) && info[1].equals(Integer.toString(oldPassword))) {
                    fileContents = fileContents.replaceAll(info[1], Integer.toString(newPassword));
                    break;
                }
            }

            FileWriter writer = new FileWriter("info.csv");
            writer.append(fileContents);
            writer.flush();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("An error occurred in looking for the file.");
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred in file IO.");
        }
    }

    public void updateScore() {

    }

    /**
     * accept a visitor and log in the user
     *
     * @param action
     */
    @Override
    public void accept(ActOnStatus action) throws IOException {
        action.login(this);
    }

}
