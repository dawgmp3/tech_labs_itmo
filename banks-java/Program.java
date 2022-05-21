import java.io.Console;
import java.util.Objects;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws BanksException {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank("Meow");
        CentralBank centralBank = new CentralBank();
        centralBank.BankRegistration(bank, 10, 10, 1000);
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        System.out.println("What is your surname?");
        String surname = scanner.nextLine();
        Client client = bank.makeClient(name, surname);
        System.out.println("Would you like to add address? Write 'y' or 'n'");
        String answer1 = scanner.nextLine();
        if (Objects.equals(answer1, "y"))
        {
            System.out.println("What is your address?");
            String address = scanner.nextLine();
            bank.addClientAddress(client, address);

        }

        System.out.println("Would you like to add passport?");
        String answer2 = scanner.nextLine();
        if (Objects.equals(answer2, "y"))
        {
            System.out.println("What is your passport?");
            String passport = scanner.nextLine();
            bank.addClientPassport(client, passport);
        }

        bank.addClient(client);
        System.out.println("What kind of acc would you like to open?");
        Account account = null;
        Account account1 = null;
        String answer3 = scanner.nextLine();
        if (Objects.equals(answer3, "debit") || Objects.equals(answer3, "Debit"))
        {
            System.out.println("How much money would you like to put in your acc?");
            int money = Integer.parseInt(scanner.nextLine());
            account = bank.openDebitAccount(client, money);
        }

        if (Objects.equals(answer3, "deposit") || Objects.equals(answer3, "Deposit"))
        {
            System.out.println("How much money would you like to put in your acc?");
            int money = Integer.parseInt(scanner.nextLine());
            account = bank.openDepositAccount(client, money);
        }

        if (Objects.equals(answer3, "credit") || Objects.equals(answer3, "Credit"))
        {
            System.out.println("How much money would you like to borrow?");
            int money = Integer.parseInt(scanner.nextLine());
            account = bank.openCreditAccount(client, money);
        }

        System.out.println("Would you like to see how much money you'll have in a year?");
        String answer4 = scanner.nextLine();
        if (Objects.equals(answer4, "y"))
        {
            System.out.println(account.toSeeHowMuchInSomeYears(bank, 1));
        }

        System.out.println("Would you like to open second account?");
        String answer5 = scanner.nextLine();
        if (Objects.equals(answer5, "y"))
        {
            System.out.println("How much money would you like to put in your acc?");
            int money = Integer.parseInt(scanner.nextLine());
            account1 = bank.openDebitAccount(client, money);
        }

        System.out.println("Would you like to transfer money?");
        String answer6 = scanner.nextLine();
        if (Objects.equals(answer6, "y"))
        {
            System.out.println("How much?");
            int money = Integer.parseInt(scanner.nextLine());
            account.transferMoneyToAnotherClient(account1, money);
            int moneyInAcc = account1.getMoney();
            System.out.println(moneyInAcc);
        }

        System.out.println("Would you like to withdraw money?");
        String answer7 = scanner.nextLine();
        if (answer7 == "y")
        {
            System.out.println("How much?");
            int money = Integer.parseInt(scanner.nextLine());
            account.withdrawMoney(money);
            int moneyInAcc = account.getMoney();
            System.out.println(moneyInAcc);
        }
    }
}