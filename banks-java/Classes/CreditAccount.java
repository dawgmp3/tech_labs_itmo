public class CreditAccount extends Account{
    Integer AmountOfMoneyNeedToReturn;
    Integer AmountOfMoneyToBorrow;
    public CreditAccount(Integer money, Bank bank, Client client) {
        super(money, bank, client);
        AmountOfMoneyToBorrow = money;
        AmountOfMoneyNeedToReturn = money;
    }
    public void withdrawMoney(Integer money) {
        getBank().giveCommissionToCreditAccount(this);
    }

    public @Override void transferMoneyToAnotherClient(Account accountCatcher, Integer moneyToSend) throws BanksException {
        throw new BanksException("You can not withdraw money from credit acc");
    }

    public @Override Integer toSeeHowMuchInSomeMonths(Bank bank, Integer amountOfMonth) throws BanksException {
        throw new BanksException("You can not count because it is credit acc");
    }

    public @Override Integer toSeeHowMuchInSomeYears(Bank bank, Integer amountOfYears) throws BanksException {
        throw new BanksException("You can not count because it is credit acc");
    }
}
