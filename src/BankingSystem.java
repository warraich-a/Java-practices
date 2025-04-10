import java.util.Scanner;

public class BankingSystem {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        double balance = 0;
        int choice;
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("**************");
            System.out.println("Banking System");
            System.out.println("**************");


            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("**************");

            System.out.println("Type a number between (1-4)");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> showBalance(balance);
                case 2 -> balance += deposit();
                case 3 -> balance -= withdraw(balance);
                case 4 -> isRunning = false;
                default -> System.out.println("Invalid entry");
            }
        }
        System.out.println("**************");
        System.out.println("Thank you");
        System.out.println("**************");
    }

    public static void showBalance(double balance) {
        System.out.println("*****************");
        System.out.printf("%.2f$\n", balance);
        System.out.println("*****************");

    }

    public static double deposit() {
        double amount;
        System.out.print("Enter the amount to be deposited: ");
        amount = scanner.nextDouble();

        if (amount < 0) {
            System.out.println("The amount cannot be in negative");
            return 0;
        } else {
            return amount;
        }
    }


    public static double withdraw(double balance) {
        double amount;
        System.out.println("Enter the amount to be withdrawn");
        amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient balance");
            return 0;
        } else if (amount < 0) {
            System.out.println("Amount cannot be negative");
            return 0;
        } else {
            return amount;
        }
    }
}