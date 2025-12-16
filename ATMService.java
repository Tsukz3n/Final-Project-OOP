package Project;

public class ATMService {

    public void deposit(Account account, double amount) {
        account.deposit(amount);
        System.out.println("Deposit successful.");
    }

    public void withdraw(Account account, double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void transfer(Account from, Account to, double amount) {
        Transaction<Account> transaction = new Transaction<>(from, to, amount);
        if (transaction.execute()) {
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed.");
        }
    }
}
