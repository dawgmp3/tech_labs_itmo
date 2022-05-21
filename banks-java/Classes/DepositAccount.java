public class DepositAccount extends Account{
    private double percentage;
    private Bank bankAccount;
    public DepositAccount(Integer money, Bank bank, Client client) {
        super(money, bank, client);
        bankAccount = bank;
    }

    public double countPercentage(DepositAccount depositAccount) {
        if (depositAccount.getMoney() > bankAccount.getHighLimitDepositAcc()) {
            percentage = depositAccount.bankAccount.getHighPercentageDepositAcc();
        }

        if (depositAccount.getMoney() <= bankAccount.getLowLimitDepositAcc()) {
            percentage = depositAccount.bankAccount.getLowPercentageDepositAcc();
        }

        return percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public Bank getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Bank bankAccount) {
        this.bankAccount = bankAccount;
    }

    public @Override void withdrawMoney(Integer money) throws BanksException {
        throw new BanksException("You can not withdraw money from deposit account");
    }

    public @Override void transferMoneyToAnotherClient(Account clientCatcher, Integer moneyToSend) throws BanksException {
        throw new BanksException("You can not send money to another client from deposit account");
    }
}
