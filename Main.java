package Project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Account acc1 = new SavingsAccount("001", 1000000.0);
        Account acc2 = new SavingsAccount("002", 500000.0);

        Customer user1 = new Customer("Lee", acc1);
        Customer user2 = new Customer("Doe", acc2);

        ATMService atm = new ATMService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== ATM MENU ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                	System.out.println("Account under name: " +user1.getName());
                    System.out.println("Balance: " + user1.getAccount().getBalance());
                    break;

                case 2:
                    System.out.print("Amount: ");
                    atm.deposit(user1.getAccount(), sc.nextDouble());
                    break;

                case 3:
                    System.out.print("Amount: ");
                    atm.withdraw(user1.getAccount(), sc.nextDouble());
                    break;

                case 4:
                    System.out.print("Amount: ");
                    atm.transfer(user1, user2, sc.nextDouble());
                    break;

                case 5:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

