package phase2.banking_system_gui;

import javax.swing.*;

public class MainGui {

    private static BankAccountGUI bankAccount;

    public static void main(String[] args) {

        bankAccount = new BankAccountGUI("John Doe", "123456789");

        showLoginScreen();
    }

    private static void showLoginScreen() {
        JFrame loginFrame = new JFrame("Login - Banking System");
        loginFrame.setSize(350, 200);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLayout(null);

        JLabel nameLabel = new JLabel("Account Holder Name:");
        nameLabel.setBounds(20, 20, 150, 30);
        JTextField nameField = new JTextField();
        nameField.setBounds(180, 20, 140, 30);

        JLabel accountNumberLabel = new JLabel("Account Number:");
        accountNumberLabel.setBounds(20, 60, 150, 30);
        JTextField accountNumberField = new JTextField();
        accountNumberField.setBounds(180, 60, 140, 30);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(120, 110, 100, 30);

        loginButton.addActionListener(e -> {
            String enteredName = nameField.getText();
            String enteredAccountNumber = accountNumberField.getText();

            if (bankAccount.authenticate(enteredName, enteredAccountNumber)) {
                loginFrame.dispose();
                showBankingScreen();
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Authentication Failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        loginFrame.add(nameLabel);
        loginFrame.add(nameField);
        loginFrame.add(accountNumberLabel);
        loginFrame.add(accountNumberField);
        loginFrame.add(loginButton);

        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
    }

    private static void showBankingScreen() {
        JFrame bankFrame = new JFrame("Welcome to your Bank Account");
        bankFrame.setSize(500, 400);
        bankFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bankFrame.setLayout(null);

        JLabel welcomeLabel = new JLabel("User Profile");
        welcomeLabel.setBounds(50, 20, 200, 30);

        JLabel nameLabel = new JLabel("Name: " + bankAccount.getAccountHolderName());
        nameLabel.setBounds(50, 60, 300, 25);

        JLabel accountNumberLabel = new JLabel("Account Number: " + bankAccount.getAccountNumber());
        accountNumberLabel.setBounds(50, 90, 300, 25);

        JButton depositeButton = new JButton("Deposit");
        depositeButton.setBounds(50, 150, 150, 40);
        depositeButton.addActionListener(e -> {
            String amountString = JOptionPane.showInputDialog(bankFrame, "Enter amount to deposit:");
            if (amountString != null) {
                try {
                    double amount = Double.parseDouble(amountString);
                    bankAccount.deposit(amount);
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(bankFrame, "Invalid Amount!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(250, 150, 150, 40);
        withdrawButton.addActionListener(e -> {
            String amountString = JOptionPane.showInputDialog(bankFrame, "Enter amount to withdraw:");
            if (amountString != null) {
                try {
                    double amount = Double.parseDouble(amountString);
                    bankAccount.withdraw(amount);
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(bankFrame, "Invalid Amount!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setBounds(50, 220, 150, 40);
        checkBalanceButton.addActionListener(e -> bankAccount.checkBalance());

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(250, 220, 150, 40);
        logoutButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(bankFrame, "Are you sure you want to logout?", "Logout",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                bankFrame.dispose();
                showLoginScreen();
            }
        });

        bankFrame.add(welcomeLabel);
        bankFrame.add(nameLabel);
        bankFrame.add(accountNumberLabel);
        bankFrame.add(depositeButton);
        bankFrame.add(withdrawButton);
        bankFrame.add(checkBalanceButton);
        bankFrame.add(logoutButton);

        bankFrame.setLocationRelativeTo(null);
        bankFrame.setVisible(true);
    }
}
