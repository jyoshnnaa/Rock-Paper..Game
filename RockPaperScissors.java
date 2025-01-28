import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        String[] choices = {"Rock", "Paper", "Scissors"};
        
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("Choose: Rock, Paper, or Scissors");

        while (true) {
            System.out.print("Enter your choice (Rock, Paper, Scissors). Type 'exit' to quit: ");
            String userChoice = sc.nextLine().trim();
            
            if (userChoice.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for playing! Goodbye.");
                break;
            }

            if (!isValidChoice(userChoice, choices)) {
                System.out.println("Invalid choice. Please choose Rock, Paper, or Scissors.");
                continue;
            }

            int computerChoiceIndex = r.nextInt(3);
            String computerChoice = choices[computerChoiceIndex];

            System.out.println("Your choice: " + userChoice);
            System.out.println("Computer's choice: " + computerChoice);

            String result = determineWinner(userChoice, computerChoice);
            System.out.println(result);
        }

        sc.close();
    }

    public static boolean isValidChoice(String choice, String[] choices) {
        for (String validChoice : choices) {
            if (validChoice.equalsIgnoreCase(choice)) {
                return true;
            }
        }
        return false;
    }

    public static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equalsIgnoreCase(computerChoice)) {
            return "It's a tie!";
        }

        switch (userChoice.toLowerCase()) {
            case "rock":
                return (computerChoice.equalsIgnoreCase("Scissors")) ? "You win!" : "You lose!";
            case "paper":
                return (computerChoice.equalsIgnoreCase("Rock")) ? "You win!" : "You lose!";
            case "scissors":
                return (computerChoice.equalsIgnoreCase("Paper")) ? "You win!" : "You lose!";
            default:
                return "Error: Invalid game logic.";
        }
    }
}
