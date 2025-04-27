package phase2.banking_system_gui;

import javax.swing.*;

public class BankAccountGUI {
    private double balance;
    private String accountHolderName;
    private String accountNumber;

    public BankAccountGUI(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        balance = 0.0;
    }

    public boolean authenticate(String enteredName, String enteredAccountNumber) {
        return accountHolderName.equals(enteredName) && accountNumber.equals(enteredAccountNumber);
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            JOptionPane.showMessageDialog(null, "Deposit amount must be greater than 0.", "Invalid Amount",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            balance += amount;
            JOptionPane.showMessageDialog(null, "Deposited Successfully! New Balance: $" + balance);
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            JOptionPane.showMessageDialog(null, "Withdrwal amount must be greater than 0.", "Invalid Amount",
                    JOptionPane.ERROR_MESSAGE);
        } else if (amount > balance) {
            JOptionPane.showMessageDialog(null, "Insufficient Balance! Current Balance: $" + balance, "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            balance -= amount;
            JOptionPane.showMessageDialog(null, "Withdrawn Successfully! New Balance: $" + balance);
        }
    }

    public void checkBalance() {
        JOptionPane.showMessageDialog(null, "Current Balance: $" + balance);
    }
}
