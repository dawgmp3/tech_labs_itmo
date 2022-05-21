import java.util.UUID;

public class Transaction {
    private Integer amountOfMoney;
    private Account AccountCatcher;
    private Account AccountSender;

    public Integer getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(Integer amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public Account getAccountCatcher() {
        return AccountCatcher;
    }

    public void setAccountCatcher(Account accountCatcher) {
        AccountCatcher = accountCatcher;
    }

    public Account getAccountSender() {
        return AccountSender;
    }

    public void setAccountSender(Account accountSender) {
        AccountSender = accountSender;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    private UUID Id;
    boolean Status;
    public Transaction(Integer amountOfMoney, Account catcherAccount, Account senderAccount) {
        this.amountOfMoney = amountOfMoney;
        AccountCatcher = catcherAccount;
        AccountSender = senderAccount;
        Id = UUID.randomUUID();
        Status = true;
    }
}
