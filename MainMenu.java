import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class MainMenu {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String input;
    Player currentPlayer = null;
    WordMatch wordMatch = new WordMatch("Food.txt");
    String[] arr = {"1", "2", "3"};
    String[] ynArr = {"y", "n"};
    while(true) {
      input = repeatedPrompt("Welcome to Language Learner!\nLogin (1)\nCreate New User (2)\nExit (3)", arr, scan);
      switch(input) {            
      case ("1"):
        System.out.println("Please enter your username and password");
        String userName = scan.next();
        String password = scan.next();
        currentPlayer = Player.validatePlayer(userName, password);
        if(currentPlayer.getUserName() == null) {
          System.out.println("Invalid username or password");
          continue;
        }
        break;
        
       case("2"):
         System.out.println("Enter your username");
         String newUsername = scan.nextLine();
         System.out.println("Enter your password");
         String newPassword = scan.nextLine();
         System.out.println("What would you like to call your pet?");
         String newPetName = scan.nextLine();
         System.out.println("What type of pet do you want?");
         String newPetType = scan.nextLine();
         currentPlayer = Player.createPlayer(newUsername, newPassword, newPetName, newPetType);
         break;
       case("3"):
         input = repeatedPrompt("Are you sure you would like to exit? (y/n)", ynArr, scan);
         if(input.equals("y")) {
           return;
         } else {
           continue;
         }

      }
      break;
    }

    String petName = currentPlayer.getPet().getName();
    while(true) {
      input = repeatedPrompt("Hello " + currentPlayer.getUserName() + ", what would you like to do?\n" + "Practice Mandarin (1)\n" + "Check on " + petName + " (2)\n" + "Exit (3)\n", arr, scan);
      switch (input) {
        case "1":
          System.out.println("You will be prompted with foods in Mandarin, type the food name in English to earn food for your pet.\n" +
                  "Enter exit at any time to return to the main menu.");
          while (true) {
            String word = wordMatch.getRandomWord();
            System.out.println(word);
            input = scan.nextLine();
            if (input.equalsIgnoreCase("exit")) break;
            if (wordMatch.match(word, input)) {
              currentPlayer.addFood(1);
              System.out.println("Correct! You have " + currentPlayer.getNumFood() + " food.");
            } else {
              System.out.println("Incorrect!");
            }
          }
          break;
        case "2":
          while(true) {
            input = repeatedPrompt(currentPlayer.getPet().statusCheck() + "\nFeed (1)\nExit (2)", new String[]{"1", "2"}, scan);
            if(input.equals("1")) {
              if(currentPlayer.getNumFood() > 0) {
                while(true) {
                  System.out.println("How much would you like to feed " + currentPlayer.getNumFood() + "?");
                  input = scan.nextLine();
                  try{
                    int numToFeed = Integer.parseInt(input);
                    currentPlayer.getPet().feed(numToFeed);
                    currentPlayer.addFood(-numToFeed);
                    System.out.print("You have " + currentPlayer.getNumFood() + " food.");
                    break;
                  } catch(NumberFormatException e) {
                    System.out.println("Invalid input, please enter an integer");
                    continue;
                  }
                }


              } else {
                System.out.println("You don't have enough food.");
              }
            } else if(input.equals("2")) {
              break;
            }
          }
          break;

        case "3":
          input = repeatedPrompt("Are you sure you would like to exit? (y/n)", ynArr, scan);
          if (input.equals("y")) {
            System.out.println("Goodbye!");
            return;
          }
          break;
      }
    }
  }

  private static String repeatedPrompt(String prompt, String[] validInputs, Scanner scan) {
    while (true) {
      System.out.println(prompt);
      String input = scan.nextLine().toLowerCase();
      for (String validInput : validInputs) {
        if(input.equals(validInput.toLowerCase())) {
          return input;
        }
      }
      System.out.println("Invalid Input");
    }
  }
}