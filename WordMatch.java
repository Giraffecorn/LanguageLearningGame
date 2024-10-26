import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class WordMatch {
    //Fields
    private ArrayList<String> english = new ArrayList<String>();
    private ArrayList<String> chinese = new ArrayList<String>();

    //Constructor
    public WordMatch(String fileName) {
        File f = new File(fileName);
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            String line = bfr.readLine();

            while (line != null) {
                String[] info = line.split(",");
                this.english.add(info[0]);
                this.chinese.add(info[1]);
            }
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<String> getEnglish() {
        return english;
    }

    public ArrayList<String> getChinese() {
        return chinese;
    }
    
    public void setEnglish(ArrayList<String> english) {
        this.english = english;
    }

    public void setChinese(ArrayList<String> chinese) {
        this.chinese = chinese;
    }

    public String getRandomWord() {
        int randomLoc = (int) (Math.random() * chinese.size());
        return chinese.get(randomLoc);
    }

    public boolean match(String word, String answer) {
        for (int i = 0; i < english.size(); i++) {
            if (answer.equalsIgnoreCase(english.get(i))) {
                if (word.equals(chinese.get(i))) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}