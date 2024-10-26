import java.io.Serializable;
public class Pet implements Serializable{
  private String name;
  private String type;
  private int happiness;

  public Pet(String name, String type) {
    this.name = name;
    this.type = type;
    happiness = 50;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public int getHappiness() {
    return happiness;
  }
  public void loseHappiness(int n) {
    if (happiness - n > 0) {
      happiness -= n;
    } else {
      happiness = 0;
    }
  }
  public String statusCheck() {
    if (happiness > 90) {
      return name + " is very happy!";
    } else if (happiness > 75) {
      return name + " could be happier..";
    } else if (happiness > 40) {
      return name + " is not happy :( ";
    } else {
      return name + " is devastated.";
    }
  }
  public void feed(int n) {
    if (happiness + n < 100){
      happiness += n;
    } else {
      happiness = 100;
    }
  }

  public String toString() {
    String s = "Name: " + name + "Type: " + type + "Happiness: " + happiness;
    return s;
  }
  
}
