import java.util.Scanner;

public class BankApp
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        BankAccount account =
            new BankAccount(
                "ACC1001",
                "Ambika",
                5000
            );

        int choice;

        do
        {
            System.out.println("\n===== BANK ACCOUNT SYSTEM =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Account Details");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();


            try
            {
                switch(choice)
                {
                    case 1:

                        System.out.print("Enter deposit amount: ₹");
                        double depositAmount =
                            scanner.nextDouble();

                        account.deposit(depositAmount);

                        System.out.println(
                            "Amount deposited successfully!"
                        );

                        break;


                    case 2:

                        System.out.print("Enter withdrawal amount: ₹");
                        double withdrawalAmount =
                            scanner.nextDouble();

                        account.withdraw(withdrawalAmount);

                        System.out.println(
                            "Amount withdrawn successfully!"
                        );

                        break;


                    case 3:

                        System.out.println(
                            "Current Balance: ₹"
                            + account.getBalance()
                        );

                        break;


                    case 4:

                        System.out.println(
                            "\n===== TRANSACTION HISTORY ====="
                        );

                        for(String transaction :
                            account.getTransactionHistory())
                        {
                            System.out.println(transaction);
                        }

                        break;


                    case 5:

                        System.out.println(
                            "\nAccount Number: "
                            + account.getAccountNumber()
                        );

                        System.out.println(
                            "Account Holder: "
                            + account.getAccountHolderName()
                        );

                        System.out.println(
                            "Balance: ₹"
                            + account.getBalance()
                        );

                        break;


                    case 6:

                        System.out.println(
                            "Thank you for using Bank System!"
                        );

                        break;


                    default:

                        System.out.println(
                            "Invalid choice!"
                        );
                }
            }
            catch(IllegalArgumentException e)
            {
                System.out.println(
                    "Error: " + e.getMessage()
                );
            }

        }
        while(choice != 6);


        scanner.close();
    }
}