import java.util.Scanner;

public class BankManagementSystem { 
    // Declare scanner as a static variable
    static Scanner scanner = new Scanner(System.in);
    static Bank bank =new Bank();

    public static void main(String[] args) {
        // Display welcome message
        System.out.println("Welcome to the Bank Management System!");

        // Main menu loop
        while (true) {
            // Display options
            System.out.println("1. Login");
            System.out.println("2. Create Account");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            // Read user input
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            // Process user choice
            switch (choice) {
                case 1:
                    // Implement login functionality
                    System.out.print("Enter username: ");
                    String user = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    bank.login(user, password);
                    break;
                    case 2:
                    // Implement account creation functionality
                    System.out.print("Enter username: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String newPassword = scanner.nextLine();
                    System.out.print("Enter account type: ");
                    String newAccountType = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double newInitialBalance = scanner.nextDouble();
                    bank.createAccount(newUsername, newPassword, newAccountType, newInitialBalance);
                    break;                
                case 3:
                    // Exit the program
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
