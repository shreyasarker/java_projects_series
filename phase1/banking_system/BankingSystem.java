package phase1.banking_system;

import java.util.Scanner;

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Bank!");
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        BankAccount account = new BankAccount(name, accountNumber, 0);

        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter amount to deposit: ");
                double amount = scanner.nextDouble();
                account.deposit(amount);
            } else if (choice == 2) {
                System.out.print("Enter amount to withdraw: ");
                double amount = scanner.nextDouble();
                account.withdraw(amount);
            } else if (choice == 3) {
                account.checkBalance();
            } else if (choice == 4) {
                System.out.println("Thank you for using the bank. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Try again!");
            }
        }
        scanner.close();
    }
}
