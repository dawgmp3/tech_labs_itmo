import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BanksTests {
    private CentralBank _centralBank;
    final double delta = 0.00000001;

    @Before
    public void setUp(){
        _centralBank = new CentralBank();
    }

    @Test(expected = BanksException.class)
    public void WithdrawMoneyWhenClientHasNoMoney() throws BanksException{
        Bank bank = new Bank("ProtectorOfMoney");
        _centralBank.BankRegistration(bank, 10, 10, 100000);
        Client client = bank.makeClient("Misha", "Makarov");
        bank.addClient(client);
        Account debitAccount = bank.openDebitAccount(client, 100);
        debitAccount.withdrawMoney(1000);
    }

    @Test(expected = BanksException.class)
    public void WithdrawMoneyFromDepositAcc() throws BanksException{
        Bank bank = new Bank("ProtectorOfMoney");
        _centralBank.BankRegistration(bank, 10, 10, 100000);
        Client client = bank.makeClient("Misha", "Makarov");
        bank.addClient(client);
        Account depositAccount = bank.openDepositAccount(client, 100);
        depositAccount.withdrawMoney(10);
    }

    @Test(expected = BanksException.class)
    public void TransferMoneyToAnotherClientFromDepositAcc() throws BanksException{
        Bank bank = new Bank("ProtectorOfMoney");
        _centralBank.BankRegistration(bank, 10, 10, 10000);
        Client client = bank.makeClient("Misha", "Makarov");
        bank.addClient(client);
        Account depositAccount = bank.openDepositAccount(client, 100);
        Bank bank2 = new Bank("Meow");
        _centralBank.BankRegistration(bank2, 20, 20, 100000);
        Client client2 = bank.makeClient("Masha", "Marievna");
        bank.addClient(client2);
        Account depositAccount2 = bank.openDepositAccount(client2, 100);
        depositAccount.transferMoneyToAnotherClient(depositAccount2, 10);
    }

    @Test(expected = BanksException.class)
    public void WithdrawMoneyFromDoubtfulAcc() throws BanksException{
        Bank bank = new Bank("ProtectorOfMoney");
        _centralBank.BankRegistration(bank, 10, 10, 100);
        Client client = bank.makeClient("Misha", "Makarov");
        bank.addClient(client);
        Account depositAccount = bank.openDepositAccount(client, 1000000);
        depositAccount.withdrawMoney(10000);
    }

    @Test
    public void TransferMoney() throws BanksException {
        Bank bank = new Bank("Meow");
        _centralBank.BankRegistration(bank, 10, 10, 1000000);
        Client client = bank.makeClient("Misha", "Makarov");
        bank.addClient(client);
        bank.addClientPassport(client,"45678");
        bank.addClientAddress(client, "Kirova");
        Account debitAccount = bank.openDebitAccount(client, 10000);
        Bank bank1 = new Bank("Bark");
        _centralBank.BankRegistration(bank1, 10, 10, 1000000);
        Client client1 = bank.makeClient("Misha", "Makarov");
        bank.addClient(client);
        Account debitAccount1 = bank.openDebitAccount(client1, 1000);
        debitAccount.transferMoneyToAnotherClient(debitAccount1, 2);
        Assert.assertEquals(1002, debitAccount1.getMoney(), delta);
    }

    @Test
    public void FutureAmountOfMoneyInAYear() throws BanksException {
        Bank bank = new Bank("Meow");
        _centralBank.BankRegistration(bank, 10, 10, 1000000);
        Client client = bank.makeClient("Misha", "Makarov");
        bank.addClient(client);
        Account depositAccount = bank.openDepositAccount(client, 10);
        int amountOfMoney = depositAccount.toSeeHowMuchInSomeYears(bank, 1);
        Assert.assertEquals(22, amountOfMoney);
    }
}
