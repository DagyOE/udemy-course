package sk.udemy.oop.bank;

public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount bobsBankAccount = new BankAccount("12345600",
                0,
                "Bob Brown",
                "bob@bob.com",
                "(087) 123-4567");

        BankAccount defaultBankAccount = new BankAccount();

        System.out.println(bobsBankAccount.getAccountNumber());
        System.out.println(bobsBankAccount.getCustomerName());
        System.out.println(bobsBankAccount.getAccountBalance());

        bobsBankAccount.withdrawFunds(100.0);
        bobsBankAccount.depositFunds(50.0);
        bobsBankAccount.withdrawFunds(100.0);
        bobsBankAccount.depositFunds(51.0);
        bobsBankAccount.withdrawFunds(100.0);

        BankAccount timsBankAccount = new BankAccount("Tim Horton",
                "tim@horton.com",
                "(421) 901-4562");
    }
}
