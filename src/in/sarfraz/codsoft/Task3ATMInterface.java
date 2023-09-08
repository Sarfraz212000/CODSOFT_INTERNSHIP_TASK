package in.sarfraz.codsoft;

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Quit");
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Enter your choice (1/2/3/4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Withdrawal failed. Insufficient funds or invalid amount.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    if (account.deposit(depositAmount)) {
                        System.out.println("Deposit successful.");
                    } else {
                        System.out.println("Deposit failed. Invalid amount.");
                    }
                    break;
                case 3:
                    double balance = account.checkBalance();
                    System.out.println("Your balance is: $" + balance);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option (1/2/3/4).");
            }
        }
    }
}

public class Task3ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your initial account balance: $");
        double initialBalance = scanner.nextDouble();
        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);
        atm.run();
        scanner.close();
    }
}
