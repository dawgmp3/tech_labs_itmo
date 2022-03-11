public class DebitAccount extends Account{
    private Client clientOfAccount;
    private Bank bankOfAccount;
    private Integer amountOfMoney;

    public Client getClientOfAccount() {
        return clientOfAccount;
    }

    public void setClientOfAccount(Client clientOfAccount) {
        this.clientOfAccount = clientOfAccount;
    }

    public Bank getBankOfAccount() {
        return bankOfAccount;
    }

    public void setBankOfAccount(Bank bankOfAccount) {
        this.bankOfAccount = bankOfAccount;
    }

    public Integer getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(Integer amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public DebitAccount(Integer money, Bank bank, Client client) {
        super(money, bank, client);
        amountOfMoney = money;
        bankOfAccount = bank;
        clientOfAccount = client;
    }
}
