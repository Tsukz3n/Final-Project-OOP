package Project;

import java.util.*;

public class AccountRepository {
    private List<Account> accounts = new ArrayList<>();

    // CREATE
    public void add(Account account) {
        accounts.add(account);
    }

    // READ
    public List<Account> getAll() {
        return accounts;
    }

    // SEARCH
    public Account findByAccountNumber(String number) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(number)) {
                return acc;
            }
        }
        return null;
    }

    // DELETE
    public boolean delete(String number) {
        Account acc = findByAccountNumber(number);
        return acc != null && accounts.remove(acc);
    }
}

