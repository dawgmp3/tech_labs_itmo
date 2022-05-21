import java.util.ArrayList;
import java.util.List;

public class Client {
    public String clientName;
    public String clientSurname;
    public String clientAddress;
    public String clientPassport;
    public Bank clientBank;
    public List<Account> clientAccounts;
    public Client(String name, String surname, String address, String passport, Bank bank) {
        clientName = name;
        clientSurname = surname;
        clientAddress = address;
        clientPassport = passport;
        clientBank = bank;
        clientAccounts = new ArrayList<>();
    }

        public boolean checkIsDoubtful() {
            if (clientPassport != null && clientAddress != null) {
                return true;
            }

            return false;
        }
}


