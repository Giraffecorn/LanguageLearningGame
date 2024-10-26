import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class MainMenu {
  private static ArrayList<Player> allPlayers;
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String input;
    Player currentPlayer;
    WordMatch wordMatch = new WordMatch("Food.txt");
    while(true) {
      input = repeatedPrompt("Welcome to Language Learner!\nLogin (1)\nCreate New User (2)\nExit (3)", {"1", "2", "3"}, scan);
      switch(input) {            
      case (1):
        System.out.println("Please enter your username and password");
        String userName = scan.Next();
        String password = scan.Next();
        currentPlayer = player.validatePlayer(userName, Password);
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
      }
        if(currentPlayer.username == null) {
          System.out.println("Invalid username or password");
        } else {
          break;
        }
      }
    }
    input = repeatedPrompt("Hello, " + currentPlayer.getUsername()) +
      ", what would you like to do?\n" +
      "Practice Mandarin (1)\n" +
      "Check on " + Player.getPet().getName() + "(2)\n" +
      "Exit (3)\n", {"1","2","3"}, scan);
    switch(input) {
      case 1:
        System.out.println("You will be prompted with foods in Mandarin, type the food name in English to earn food for your pet.\n" +
                           "Enter exit at any time to return to the main menu.");
        while(true) {
          String word = wordMatch.getRandomWord
          System.out.println(word);
          input = scan.nextLine();
          if(input.toLowerCase().equals("exit")) break;
          if(wordMatch.match(word, input)) {
            currentPlayer.addFood(1);
            System.out.println("Correct! You have " + currentPlayer.getFood() + " food.")
          } else {
            System.out.println("Incorrect!");
          }
        }
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

