package Project;

import java.util.Comparator;
import java.util.List;

public class BankService {

    private AccountRepository repository;

    public BankService(AccountRepository repository) {
        this.repository = repository; // DIP
    }

    public void createAccount(String number, String name, double balance) {
        repository.add(new SavingsAccount(number, name, balance));
    }

    public void updateOwnerName(String number, String newName) {
        Account acc = repository.findByAccountNumber(number);
        if (acc != null) acc.setOwnerName(newName);
    }

    public void deposit(String number, double amount) {
        Account acc = repository.findByAccountNumber(number);
        if (acc != null) acc.deposit(amount);
    }

    public boolean withdraw(String number, double amount) {
        Account acc = repository.findByAccountNumber(number);
        return acc != null && acc.withdraw(amount);
    }

    public boolean transfer(String from, String to, double amount) {
        Account src = repository.findByAccountNumber(from);
        Account dest = repository.findByAccountNumber(to);

        if (src != null && dest != null && src.withdraw(amount)) {
            dest.deposit(amount);
            return true;
        }
        return false;
    }

    // SORTING
    public void sortByBalance() {
        repository.getAll()
                .sort(Comparator.comparingDouble(Account::getBalance));
    }

    public List<Account> getAllAccounts() {
        return repository.getAll();
    }
}

