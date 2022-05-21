import java.util.UUID;

public abstract class Account {
    private Integer money;
    private UUID id;
    private Bank bank;
    private Client client;
    public Account(Integer money, Bank bank, Client client) {
        this.money = money;
        id = UUID.randomUUID();
        this.bank = bank;
        this.client = client;
    }

    public Integer getMoney() {
        return money;
    }

    public void putMoneyInAcc(Integer money) {
        this.money = this.money + money;
    }

    public Integer toSeeHowMuchInSomeMonths(Bank bank, Integer amountOfMonth) throws BanksException {
        return addPercentage(bank.getPersentage(), amountOfMonth);
    }

    public Integer toSeeHowMuchInSomeYears(Bank bank, Integer amountOfYears) throws BanksException {
        return addPercentage(bank.getPersentage() * 12, amountOfYears);
    }

    public Integer addPercentage(Integer percent, Integer time) {
        int finalMoney = money;
        for (int i = 0; i < time; i++) {
            finalMoney += money * percent / 100;
        }

        return finalMoney;
    }

    public void withdrawMoney(Integer money) throws BanksException {
        if (!client.checkIsDoubtful()) {
            if (money > this.money) {
                throw new BanksException("client can not withdraw money above limit");
            }
        }

        if (this.money >= money) {
            this.money = this.money - money;
            bank.createTransaction(money, null, this);
        }
        else {
            throw new BanksException("Not enough money");
        }
    }

    public Bank getBank() {
        return bank;
    }

    public void transferMoneyToAnotherClient(Account accountCatcher, Integer moneyToSend) throws BanksException {
        if (!client.checkIsDoubtful()) {
            if (moneyToSend > getBank().getLimit()) {
                throw new BanksException("Client can not send money because he is doubtful");
            }
        }

        if (getMoney() >= moneyToSend) {
            withdrawMoney(moneyToSend);
            accountCatcher.putMoneyInAcc(moneyToSend);
        }

        bank.createTransaction(moneyToSend, accountCatcher, this);
    }

    public void update(Account account, Integer percentage) {
        Bank bank = account.bank;
        bank.setPersentage(percentage);
    }
}
