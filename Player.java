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
            File f2 = new File("Pets.txt");
            try {
                BufferedReader bfr = new BufferedReader(new FileReader(f));
                BufferedReader bfr2 = new BufferedReader(new FileReader(f2));
                String line = bfr.readLine();
                String line2 = bfr2.readLine();
                int count = 0;
                while (line != null) {

                    if (line.substring(0, line.indexOf(",")).equals(userName)) {
                        String[] playerData = line.split(",");
                        this.numFood = Integer.parseInt(playerData[2]);
                        String[] petData = line2.split(",");
                        this.pet = new Pet(petData[0], petData[1]);
                    }
                    line = bfr.readLine();
                    line2 = bfr2.readLine();
                    count++;
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

    public void addFood(int num) {
        this.numFood += num;
    }

    //Methods
    public static Player createPlayer(String userName, String password, String petName, String petType) {
        File f = new File("User.txt");
        File f2 = new File("Pets.txt");
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
                line = bfr.readLine();
            }
            bfr.close();
            if (!exist) {
                BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
                bw.write(userName + "," + password + ",0\n");
                BufferedWriter bw2 = new BufferedWriter(new FileWriter(f2, true));
                bw2.write(petName + "," + petType + ",50\n");
                bw.close();
                bw2.close();
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
            while (line != null) {
                index++;
                String[] info = line.split(",");
                if (info[0].equals(userName)) {
                    if (info[1].equals(password)) {
                        return new Player(userName, password, false, new Pet("",""));
                    }
                }
                line = bfr.readLine();
            }
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Player();
    }
    
    public void savePlayer() {
        File f = new File("User.txt");
        File f2 = new File("Pets.txt");
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            String line = bfr.readLine();
            BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
            StringBuffer inputBuffer = new StringBuffer();

            BufferedWriter bw2 = new BufferedWriter(new FileWriter(f2));

            int count = 1;
            while (line != null) {
                String[] info = line.split(",");

                if (info[0].equals(userName)) {
                    line = userName + "," + password + "," + numFood;
                    inputBuffer.append(line);
                    inputBuffer.append('\n');
                    FileOutputStream fileOut = new FileOutputStream("User.txt");
                    fileOut.write(inputBuffer.toString().getBytes());
                    fileOut.close();
                    String petString = getPet().getName() + "," + getPet().getType() + "," + getPet().getHappiness();
                    ModifyFile("Pets.txt", petString, count);
                    break;
                }
                line = bfr.readLine();
            }
            bfr.close();
            count++;
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void ModifyFile(String filePath, String newContent, int lineNumber) {
        try {
            // Read the file content into a list
            ArrayList<String> lines = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();

            // Modify the specific line
            if (lineNumber >= 0 && lineNumber < lines.size()) {
                lines.set(lineNumber, newContent);
            } else {
                System.out.println("Invalid line number.");
                return;
            }

            // Write the modified content back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            for (String l : lines) {
                writer.write(l);
                writer.newLine();
            }
            writer.close();

            System.out.println("File updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
