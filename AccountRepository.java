package Project;

import java.util.*;

public class AccountRepository<T extends Account> {

    private List<T> accounts = new ArrayList<>();

    // CREATE
    public void add(T account) {
        accounts.add(account);
    }

    // READ
    public List<T> getAll() {
        return accounts;
    }

    // SEARCH
    public T findByAccountNumber(String number) {
        for (T acc : accounts) {
            if (acc.getAccountNumber().equals(number)) {
                return acc;
            }
        }
        return null;
    }

    // DELETE
    public boolean delete(String number) {
        T acc = findByAccountNumber(number);
        return acc != null && accounts.remove(acc);
    }
}