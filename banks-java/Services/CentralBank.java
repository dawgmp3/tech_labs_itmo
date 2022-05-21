import java.util.ArrayList;
import java.util.List;

public class CentralBank
{
    private List<Bank> _allBanks = new ArrayList<Bank>();
    public Bank BankRegistration(Bank bank, Integer percentage, Integer comission, Integer limit) {
        bank.setPersentage(percentage);
        bank.setCommission(comission);
        bank.setLimit(limit);
        return bank;
    }

    public void cancelTransactionTransfer(Transaction transaction, Bank bank) throws BanksException {
        Transaction transactionToCancell = bank.getTransactions().stream()
                .filter(transactionInBank -> transactionInBank.getId() == transaction.getId()).findFirst().orElse(null);
        if (transactionToCancell != null && transaction.Status) {
            transactionToCancell.getAccountSender().putMoneyInAcc(transaction.getAmountOfMoney());
            transactionToCancell.getAccountCatcher().withdrawMoney(transaction.getAmountOfMoney());
            transactionToCancell.Status = false;
        }
    }

    public void cancelTransactionWithdraw(Transaction transaction, Bank bank) {
        Transaction transactionToCancell = bank.getTransactions().stream()
                .filter(transactionInBank -> transactionInBank.getId() == transaction.getId()).findFirst().orElse(null);
        if (transactionToCancell != null && transaction.Status) {
            transactionToCancell.getAccountSender().putMoneyInAcc(transaction.getAmountOfMoney());
            transactionToCancell.Status = false;
        }
    }

    public void changePercentage(Bank bank, Integer percentage) {
        bank.setPersentage(percentage);
    }

    public void changeLimits(Bank bank, Integer limit) {
        bank.setLimit(limit);
    }
}