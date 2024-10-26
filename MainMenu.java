import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class MainMenu {
  private static ArrayList<Player> allPlayers;
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    File f = new File("players.txt");
    String input;
    try (BufferedReader br = new BufferedReader(new FileReader(f))) {
      while(true) {
        String line = br.readLine();
        if(line == null) {
          break;
        }
        playerData = line.split(",");
        //TODO change this when the constructor of player and players.txt is created to be formatted to the constructor
        allPlayers.add(new Player(playerData));
    
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    Player currentPlayer;

    while(true) {
    input = repeatedPrompt("Welcome to Language learner!\n" +
                  "Login (1)\n" +
                  "Create New User (2)" +
      switch(input) {            "exit (3)", {"1", "2", "3"}, scan);
      case (1):
        System.out.println("Please enter your username and password");
        String userName = scan.Next();
        String password = scan.Next();
        
        for(Player player : allPlayers) {
          if(player.validatePlayer(userName, Password)){
            currentPlayer = player;
            break;
          }
         }
        System.out.println("Invalid username or password")
        break;
        }
       case(2):
         //TODO create new user
       case(3):
         input = repeatedPrompt("Are you sure you would like to exit? (y/n)", {"y", "n"}, scan)
         if(input = yes) {
          return;
         }
        break;
      }
    input = repeatedPrompt("Hello, " + currentPlayer.getUsername()) +
      ", what would you like to do?\n" +
      "Practice Mandarin (1)\n" +
      "Check on " + Player.getPet().getName() + "(2)\n" +
      "Exit (3)\n", {"1","2","3"}, scan);
    switch(input) {
      case 1:
        //TODO Run matching mini game
      case 2:
        //TODO Check on pet
      case 3:
        input = repeatedPrompt("Are you sure you would like to exit? (y/n)", {"y", "n"}, scan)
        if(input.equals("y")) {
          System.out.println("Goodbye!");
          return;
        }
        break;
        

                   
                   
    
  }

  private static String repeatedPrompt(String prompt, String[] validInputs, Scanner scan) {
    while true() {
      System.out.println(prompt)
      String input = scan.nextLine().toLowerCase;
      for (String validInput : validInputs) {
        if(input.equals(validInput.toLowerCase())) {
          return input;
        }
      }
      System.out.println("Invalid Input");
    }
  }
}

