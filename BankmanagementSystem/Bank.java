import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void createAccount(String username, String password, String accountType, double initialBalance) {
        // Generate a unique 6-digit account number
        int accountNumber = generateAccountNumber();

        // Create a new Account object
        Account newAccount = new Account(username, password, accountType, initialBalance, accountNumber);
        
        // Add the new account to the list of accounts
        accounts.add(newAccount);
        
        System.out.println("Account created successfully! Account Number: " + accountNumber);
    }

    public void login(String username, String password) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                System.out.println("Login Successful");
                showDetails(account);
                return;
            }
        }
        System.out.println("Invalid username or password");
    }
    private void showDetails(Account account) {
        System.out.println("Username: " + account.getUsername());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Type: " + account.getAccountType());
        System.out.println("Balance: " + account.getBalance());
    }


    private int generateAccountNumber() {
        // Generate a unique 6-digit account number
        int accountNumber;
        do {
            accountNumber = (int) (Math.random() * 900000) + 100000;
        } while (isAccountNumberExists(accountNumber));
        return accountNumber;
    }

    private boolean isAccountNumberExists(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        
        // Example usage:
        bank.createAccount("user1", "password1", "Savings", 1000);
        bank.createAccount("user2", "password2", "Checking", 2000);
        
        bank.login("user1", "password1");
        bank.login("user2", "password2");
        bank.login("user3", "password3"); // Invalid credentials
    }
}

class Account {
    private String username;
    private String password;
    private String accountType;
    private double balance;
    private int accountNumber;

    public Account(String username, String password, String accountType, double balance, int accountNumber) {
        this.username = username;
        this.password = password;
        this.accountType = accountType;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
