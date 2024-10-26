import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Player {
    //Fields
    private int numFood;
    private String userName;
    private String password;

    public static String createPlayer(String userName, String password) {
        File f = new File("user.txt");
        boolean exist = false;
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            String line = bfr.readLine();

            while (line != null) {
                String[] info = line.split(",");
                if (info[0].equals(userName)) {
                    exist = true;
                    break;
                }
            }
            bfr.close();
            if (!exist) {
                BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
                bw.write(userName + "," + password);
                bw.newLine();
                bw.close();
                return "User Successfully Created!";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "User Already Exist, Please Try Again!";
    }

    public static boolean validatePlayer(String userName, String password) {
        File f = new File("user.txt");
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            String line = bfr.readLine();

            while (line != null) {
                String[] info = line.split(",");
                if (info[0].equals(userName)) {
                    if (info[1].equals(password)) {
                        return true;
                    }
                }
            }
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}