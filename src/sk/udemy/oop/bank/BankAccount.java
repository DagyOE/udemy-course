package sk.udemy.oop.bank;

public class BankAccount {

    private String accountNumber;
    private double accountBalance;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNumber;

    public BankAccount() {
        // this. call next constructor
        this("567890",
                1.11,
                "Default name",
                "Default addres",
                "Default phone");
        System.out.println("Empty constructor called");
    }

    public BankAccount(String accountNumber, double accountBalance,
                       String customerName, String customerEmail,
                       String customerPhoneNumber) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public BankAccount(String customerName, String customerEmail, String customerPhoneNumber) {
        this("98765",
                12530.33,
                customerName,
                customerEmail,
                customerPhoneNumber);
    }

    public void depositFunds(double depositAmount) {
        this.accountBalance += depositAmount;
        System.out.println("Deposit of " + depositAmount
                + " made. New balance is " + this.accountBalance);
    }

    public void withdrawFunds(double withdrawAmount) {
        if ((this.accountBalance - withdrawAmount) > 0.0) {
            this.accountBalance -= withdrawAmount;
            System.out.println("Withdrawal of " + withdrawAmount
                    + " processed. Remaining balance is " + this.accountBalance);
        } else {
            System.out.println("Only " + this.accountBalance + " available. Withdrawal not processed");
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }
}
