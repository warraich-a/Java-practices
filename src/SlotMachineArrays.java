import java.util.Random;
import java.util.Scanner;

public class SlotMachineArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Initialize starting balance
        int balance = 100;
        int bet;
        int payout = 0;

        String[] row;  // To store the result of a spin

        // Step 2: Display welcome message and slot symbols
        System.out.println("***************************");
        System.out.println("   Welcome to java slot   ");
        System.out.println("Symbols:  🍒 🍉 🍋 🔔 💥");
        System.out.println("***************************");

        // Step 3: Main game loop - continues until balance is 0 or user quits
        while (balance > 0) {

            System.out.println("Current balance: $" + balance);
            System.out.print("Place your bet amount: ");
            bet = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            // Step 4: Validate bet
            if (bet > balance) {
                System.out.println("Insufficient funds");
                continue;
            } else if (bet < 0) {
                System.out.println("Bet cant be negative");
                continue;
            } else {
                balance -= bet; // Deduct bet from balance
            }

            // Step 5: Perform spin and display result
            System.out.println("Spinning...");
            row = spinRow();      // Spin the slot machine
            printRow(row);        // Show the symbols

            // Step 6: Calculate payout based on result
            payout = getPayout(row, bet);
            if (payout > 0){
                System.out.println("You won $ "+ payout);
                balance += payout; // Add winnings to balance
            }
            else {
                System.out.println("Sorry you lost");
            }

            // Step 7: Ask user to continue or exit
            System.out.print("Do you want to play again?");
            String playagain = scanner.nextLine().toUpperCase();

            if(!playagain.equals("Y")){
                break; // Exit loop
            }
        }

        // Step 8: Game over message
        System.out.println("Game over, your balance is $" + balance);
        scanner.close();
    }

    // This method determines the payout based on matching symbols
    private static int getPayout(String[] row, int bet) {
        // All three symbols match
        if (row[0].equals(row[1]) && row[1].equals(row[2])) {
            return switch (row[0]) {
                case "🍒" -> bet * 3;
                case "🍉" -> bet * 4;
                case "🍋" -> bet * 5;
                case "🔔" -> bet * 10;
                case "💥" -> bet * 20;
                default -> 0;
            };
        }
        // First two symbols match
        else if (row[0].equals(row[1])) {
            return switch (row[1]) {
                case "🍒" -> bet * 2;
                case "🍉" -> bet * 3;
                case "🍋" -> bet * 4;
                case "🔔" -> bet * 5;
                case "💥" -> bet * 10;
                default -> 0;
            };
        }
        // Last two symbols match
        else if (row[1].equals(row[2])) {
            return switch (row[2]) {
                case "🍒" -> bet * 2;
                case "🍉" -> bet * 3;
                case "🍋" -> bet * 4;
                case "🔔" -> bet * 5;
                case "💥" -> bet * 10;
                default -> 0;
            };
        }

        // No matching symbols
        return 0;
    }

    // This method randomly generates 3 symbols for a spin
    private static String[] spinRow() {
        String[] symbols = {"🍒", "🍉", "🍋", "🔔", "💥"};  // Available symbols
        String[] row = new String[3]; // One row with 3 symbols

        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            row[i] = symbols[random.nextInt(symbols.length)];
        }

        return row;
    }

    // This method prints the slot machine row in a formatted way
    static void printRow(String[] row) {
        System.out.println("**************");
//        String.join is a useful method, with this you can join each String data so basically per record
//         with whatever char you want, so here with " | "
        // Join the symbols with " | " for a slot-style look
        System.out.println(" " + String.join(" | ", row));
        System.out.println("**************");
    }
}
