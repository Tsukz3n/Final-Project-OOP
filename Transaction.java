package Project;

public class Transaction<T extends Account> {
    private T from;
    private T to;
    private double amount;

    public Transaction(T from, T to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public boolean execute() {
        if (from.withdraw(amount)) {
            to.deposit(amount);
            return true;
        }
        return false;
    }
}

