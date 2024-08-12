class BankAccount {
    private int accountNumber;
    private double balance;
    private String accountHolderName;

    public BankAccount(int accountNumber, double balance, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolderName = accountHolderName;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public double checkBalance() {
        return balance;
    }

    public void displayAccountDetails() {
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(123456, 1000.0, "Alice");
        BankAccount account2 = new BankAccount(654321, 500.0, "Bob");

        account1.deposit(500.0);
        account1.withdraw(200.0);

        account2.deposit(100.0);
        account2.withdraw(600.0);

        System.out.println("Account 1 Details:");
        account1.displayAccountDetails();

        System.out.println("\nAccount 2 Details:");
        account2.displayAccountDetails();
    }
}