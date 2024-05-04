import java.util.Scanner;
 public class BankAccount {
    private double balance;
    public   BankAccount(double initialBalance) 
    {
        this.balance = initialBalance;
    }
    public void deposit(double amount) 
    {
        balance += amount;
    }
    public boolean withdraw(double amount) 
    {
        if (amount <= balance) 
        {
            balance -= amount;
            return true;
        } else 
        {
            return false;
        }
    }
    public double checkBalance() {
        return balance;
    }
}