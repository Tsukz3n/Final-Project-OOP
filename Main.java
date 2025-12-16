package Project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService bank = new BankService(new AccountRepository());

        while (true) {
            System.out.println("\n=== BANK MENU ===");
            System.out.println("1. Create Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Update Account Name");
            System.out.println("4. Delete Account");
            System.out.println("5. Deposit");
            System.out.println("6. Withdraw");
            System.out.println("7. Transfer");
            System.out.println("8. Search Account");
            System.out.println("9. Sort by Balance");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> {
                    System.out.print("Account No: ");
                    String no = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Balance: ");
                    double bal = sc.nextDouble();
                    bank.createAccount(no, name, bal);
                }

                case 2 -> bank.getAllAccounts().forEach(a ->System.out.println(a.getAccountNumber()+ " | " + a.getOwnerName()+ " | " + a.getBalance()));

                case 3 -> {
                    System.out.print("Account No: ");
                    bank.updateOwnerName(sc.nextLine(),
                            sc.nextLine());
                }

                case 4 -> {
                    System.out.print("Account No: ");
                    bank.getAllAccounts().removeIf(a ->a.getAccountNumber().equals(sc.nextLine()));
                }

                case 5 -> {
                    System.out.print("Account No: ");
                    String no = sc.nextLine();
                    System.out.print("Amount: ");
                    bank.deposit(no, sc.nextDouble());
                }

                case 6 -> {
                    System.out.print("Account No: ");
                    String no = sc.nextLine();
                    System.out.print("Amount: ");
                    System.out.println(bank.withdraw(no, sc.nextDouble())? "Success" : "Failed");
                }

                case 7 -> {
                    System.out.print("From: ");
                    String from = sc.nextLine();
                    System.out.print("To: ");
                    String to = sc.nextLine();
                    System.out.print("Amount: ");
                    System.out.println(
                            bank.transfer(from, to, sc.nextDouble())
                                    ? "Transferred" : "Failed");
                }

                case 8 -> {
                    System.out.print("Account No: ");
                    var acc = bank.getAllAccounts().stream().filter(a -> a.getAccountNumber().equals(sc.nextLine())).findFirst();
                    acc.ifPresentOrElse(a -> System.out.println(a.getOwnerName()+ " | " + a.getBalance()),() -> System.out.println("Not found"));
                }

                case 9 -> {
                    bank.sortByBalance();
                    System.out.println("Sorted by balance.");
                }

                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
            }
        }
    }
}


