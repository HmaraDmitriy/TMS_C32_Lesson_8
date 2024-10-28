package com.teachmeskills.lesson_8.model.account;

public class Account {

    String accountNumber;
    double amount;

    public Account(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
    public double getBalance() {
        return amount;
    }

    public void setBalance(double balance) {
        this.amount = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
