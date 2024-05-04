import java.util.*;
public class ATM 
{
    private BankAccount account;
    private Scanner scanner;
    public ATM(BankAccount account) 
    {
        this.account = account;
        scanner = new Scanner(System.in);
    }
    public void displayMenu() 
    {
        int choice;
        do 
        {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }
    private void withdraw() 
    {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount <= 0) 
        {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }
        if (account.withdraw(amount)) 
        {
            System.out.println("Withdrawal successful. Remaining balance: " + account.checkBalance());
        } else 
        {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    private void deposit() 
    {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount <= 0) 
        {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }
        account.deposit(amount);
        System.out.println("Deposit successful. Updated balance: " + account.checkBalance());
    }
    private void checkBalance() {
        System.out.println("Current balance: " + account.checkBalance());
    }

    public static void main(String[] args) 
    {
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);
        atm.displayMenu();
    }
}
