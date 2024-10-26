import java.io.*;
import java.util.ArrayList;
public class Player {
    //Fields
    private int numFood;
    private String userName;
    private String password;
    private Pet pet;

    //Constructor
    public Player() {
        this.numFood = 0;
        this.userName = null;
        this.password = null;
        this.pet = null;
    }
    public Player(String userName, String password, boolean newUser, Pet pet) {
        this.userName = userName;
        this.password = password;
        this.pet = pet;
        if (newUser) {
            this.numFood = 0;
        } else {
            File f = new File("User.txt");
            try {
                BufferedReader bfr = new BufferedReader(new FileReader(f));
                String line = bfr.readLine();
                while (line != null) {
                    if (line.substring(0, line.indexOf(",")).equals(userName)) {
                        this.numFood = Integer.parseInt(line.substring(line.indexOf(",", line.indexOf(","))));
                    }
                }
                bfr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Getters
    public int getNumFood() {
        return numFood;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Pet getPet() {
        return pet;
    }

    //Setters
    public void setNumFood(int numFood) {
        this.numFood = numFood;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    //Methods
    public static Player createPlayer(String userName, String password, String petName, String petType) {
        File f = new File("User.txt");
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
                bw.close();
                return new Player(userName, password, true, new Pet(petName, petType));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Player();
    }

    public static Player validatePlayer(String userName, String password) {
        File f = new File("User.txt");
        int index = 0;
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            String line = bfr.readLine();
            ArrayList<Pet> pets = new ArrayList<Pet>();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Pets.txt"));
            while (line != null) {
                pets.add((Pet) ois.readObject());
                index++;
                String[] info = line.split(",");
                if (info[0].equals(userName)) {
                    if (info[1].equals(password)) {
                        return new Player(userName, password, false, pets.get(index));
                    }
                }
            }
            bfr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Player();
    }
    
    public void savePlayer() {
        File f = new File("User.txt");
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            String line = bfr.readLine();
            BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
            StringBuffer inputBuffer = new StringBuffer();

            while (line != null) {
                String[] info = line.split(",");
                if (info[0].equals(userName)) {
                    line = userName + "," + password + "," + numFood;
                    inputBuffer.append(line);
                    inputBuffer.append('\n');
                    FileOutputStream fileOut = new FileOutputStream("User.txt");
                    fileOut.write(inputBuffer.toString().getBytes());
                    fileOut.close();
                    break;
                }
            }
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
