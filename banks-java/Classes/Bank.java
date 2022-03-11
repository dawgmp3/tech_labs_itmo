import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Client> doubtfulClients = new ArrayList<>();
    private String name;
    private Integer percentage;
    private Integer commission;
    private List<Client> clients;
    private Integer limit;
    private Integer highLimitDepositAcc;
    private Integer lowLimitDepositAcc;
    private Integer percentageHighLimit;
    private Integer percentageLowLimit;
    private List<Transaction> transactions;
    public Bank(String name) {
        this.name = name;
        percentageLowLimit = 0;
        percentageHighLimit = 0;
        lowLimitDepositAcc = 0;
        highLimitDepositAcc = 0;
        clients = new ArrayList<>();
        percentage = 0;
        commission = 0;
        limit = 0;
        transactions = new ArrayList<>();
    }

    public void createTransaction(Integer money, Account catcherAccount, Account senderAccount) {
        Transaction transaction = new Transaction(money, catcherAccount, senderAccount);
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setHighLimitDepositAcc(Integer amountOfMoney) {
        highLimitDepositAcc = amountOfMoney;
    }

    public void setLowLimitDepositAcc(Integer amountOfMoney) {
        lowLimitDepositAcc = amountOfMoney;
    }

    public void setHighPercentageDepositAcc(Integer percentage) {
        percentageHighLimit = percentage;
    }

    public void setLowPercentageDepositAcc(Integer percentage) {
        percentageLowLimit = percentage;
    }

    public Integer getHighLimitDepositAcc() {
        return highLimitDepositAcc;
    }

    public Integer getLowLimitDepositAcc() {
        return lowLimitDepositAcc;
    }

    public Integer getHighPercentageDepositAcc() {
        return percentageHighLimit;
    }

    public Integer getLowPercentageDepositAcc() {
        return percentageLowLimit;
    }

    public String getName() {
        return name;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void setPersentage(Integer percentage) {
        this.percentage = percentage;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public Integer getPersentage() {
        return percentage;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    public Account openCreditAccount(Client client, Integer amountOfMoneyToBorrow) {
        var creditAccount = new CreditAccount(amountOfMoneyToBorrow, client.clientBank, client);
        client.clientAccounts.add(creditAccount);
        return creditAccount;
    }

    public Account openDebitAccount(Client client, Integer money) {
        Account debitAccount = new DebitAccount(money, client.clientBank, client);
        client.clientAccounts.add(debitAccount);
        return debitAccount;
    }

    public Account openDepositAccount(Client client, Integer moneyToPutInAcc) {
        var depositAccount = new DepositAccount(moneyToPutInAcc, client.clientBank, client);
        client.clientAccounts.add(depositAccount);
        return depositAccount;
    }

    public void giveCommissionToCreditAccount(CreditAccount account) {
        if (account.AmountOfMoneyNeedToReturn < 0) {
            account.AmountOfMoneyNeedToReturn = account.AmountOfMoneyNeedToReturn +
                    (commission / 100 * account.AmountOfMoneyNeedToReturn);
        }
    }

    public void givePercentagesToDebitAccount(DebitAccount debitAccount) {
        debitAccount.putMoneyInAcc(percentage / 100 * debitAccount.getMoney());
    }

    public void givePercentagesToDepositAccount(DepositAccount depositAccount) {
        depositAccount.putMoneyInAcc(percentage / 100 * depositAccount.getMoney());
    }

    public Client makeClient(String name, String surname) {
        Client newClient = new Client(name, surname, null, null, null);
        newClient.clientBank = this;
        doubtfulClients.add(newClient);
        return newClient;
    }

    public void addClientAddress(Client client, String address) {
        client.clientAddress = address;
    }

    public void addClientPassport(Client client, String passport) {
        client.clientPassport = passport;
    }

    public void updateBanks() {
        for (var client : clients) {
            for (Account acc : client.clientAccounts) {
                giveCommissionToCreditAccount((CreditAccount) acc);
            }

            for (Account acc : client.clientAccounts) {
                givePercentagesToDebitAccount((DebitAccount) acc);
            }

            for (Account acc : client.clientAccounts) {
                givePercentagesToDepositAccount((DepositAccount) acc);
            }
        }
    }
}
