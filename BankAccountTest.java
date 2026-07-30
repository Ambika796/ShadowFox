import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest
{
    @Test
    void testDeposit()
    {
        BankAccount account =
            new BankAccount("ACC1001", "Ambika", 5000);

        account.deposit(1000);

        assertEquals(6000, account.getBalance());
    }


    @Test
    void testWithdraw()
    {
        BankAccount account =
            new BankAccount("ACC1001", "Ambika", 5000);

        account.withdraw(1000);

        assertEquals(4000, account.getBalance());
    }


    @Test
    void testBalance()
    {
        BankAccount account =
            new BankAccount("ACC1001", "Ambika", 5000);

        assertEquals(5000, account.getBalance());
    }


    @Test
    void testTransactionHistory()
    {
        BankAccount account =
            new BankAccount("ACC1001", "Ambika", 5000);

        account.deposit(1000);

        assertEquals(2,
            account.getTransactionHistory().size());
    }


    @Test
    void testInvalidDeposit()
    {
        BankAccount account =
            new BankAccount("ACC1001", "Ambika", 5000);

        assertThrows(
            IllegalArgumentException.class,
            () -> account.deposit(0)
        );
    }


    @Test
    void testInsufficientBalance()
    {
        BankAccount account =
            new BankAccount("ACC1001", "Ambika", 5000);

        assertThrows(
            IllegalArgumentException.class,
            () -> account.withdraw(6000)
        );
    }
}