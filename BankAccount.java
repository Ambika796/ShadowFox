import java.util.ArrayList;

public class BankAccount
{
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    private ArrayList<String> transactionHistory;


    public BankAccount(String accountNumber,
                       String accountHolderName,
                       double initialBalance)
    {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;

        transactionHistory = new ArrayList<>();

        transactionHistory.add(
            "Account created with balance: ₹" + initialBalance
        );
    }


    public void deposit(double amount)
    {
        if(amount <= 0)
        {
            throw new IllegalArgumentException(
                "Deposit amount must be greater than zero"
            );
        }

        balance = balance + amount;

        transactionHistory.add(
            "Deposited: ₹" + amount
        );
    }


    public void withdraw(double amount)
    {
        if(amount <= 0)
        {
            throw new IllegalArgumentException(
                "Withdrawal amount must be greater than zero"
            );
        }

        if(amount > balance)
        {
            throw new IllegalArgumentException(
                "Insufficient balance"
            );
        }

        balance = balance - amount;

        transactionHistory.add(
            "Withdrawn: ₹" + amount
        );
    }


    public double getBalance()
    {
        return balance;
    }


    public ArrayList<String> getTransactionHistory()
    {
        return transactionHistory;
    }


    public String getAccountNumber()
    {
        return accountNumber;
    }


    public String getAccountHolderName()
    {
        return accountHolderName;
    }
}