import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors_Arrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();

        String[] choices = {"rock", "paper", "scissors"};

        String playerChoice;

        String computerChoice;

        String playAgain = "yes";

        boolean gameCompleted = false;
        do {
            System.out.print("Enter your move (rock, paper, scissors)");
            playerChoice = scanner.nextLine().toLowerCase();

            if (!playerChoice.equals("rock") && !
                    playerChoice.equals("paper") && !
                    playerChoice.equals("scissors")) {
                System.out.println("Invalid choice");
//                this is to skip current iteration, meaning if the input is invalid then there is no need to go any further
                continue;
            }

            computerChoice = choices[random.nextInt(3)];
            System.out.printf("Computer choice %s ", computerChoice);

            if (computerChoice.equals(playerChoice)) {
                System.out.println("Its a tie");

            } else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                    (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                    (playerChoice.equals("scissors") && computerChoice.equals("paper"))) {
                System.out.println("You win!");

            } else {
                System.out.println("You lose!");
            }
            System.out.print("Play again? ");
            playAgain = scanner.nextLine();
        } while (playAgain.equals("yes"));

        System.out.println("Thanks for playing");

    }
}
