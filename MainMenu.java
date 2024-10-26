import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class MainMenu {
  private static ArrayList<Player> allPlayers;
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String input;
    Player currentPlayer;
    while(true) {
    input = repeatedPrompt("Welcome to Language Learner!\n" +
                  "Login (1)\n" +
                  "Create New User (2)" +
      switch(input) {            "exit (3)", {"1", "2", "3"}, scan);
      case (1):
        System.out.println("Please enter your username and password");
        String userName = scan.Next();
        String password = scan.Next();
        currentPlayer = player.validatePlayer(userName, Password));
        break;
        
       case(2):
         System.out.println("Enter your username");
         String newUsername = scan.nextline();
         System.out.println("Enter your password");
         String newPassword = scan.nextLine();
         System.out.println("What would you like to call your pet?");
         String newPetName = scan.nextLine();
         System.out.println("What type of pet do you want?");
         String newPetType = scan.nextLine();
         currentPlayer = createNewPlayer(newUsername, newPassword, newPetName, newPetType);
       case(3):
         input = repeatedPrompt("Are you sure you would like to exit? (y/n)", {"y", "n"}, scan);
         if(input = yes) {
          return;
         }
        break;
        if(currentPlayer.username == null) {
          System.out.println("Invalid username or password");
        } else {
          break;
        }
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
      System.out.println(prompt);
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

