package com.epam.homework.multithreading.java_util_concurrent.bank;

public class BankUser implements Runnable {

    private String name;
    private Bank bank;
    private int withdrawalAmount;

    public BankUser(String name, Bank bank, int withdrawalAmount) {
        this.name = name;
        this.bank = bank;
        this.withdrawalAmount = withdrawalAmount;
    }

    @Override
    public void run() {
        while (bank.getMoneyAmount() > 0) {
            System.out.println(String.format(
                    "%s: Going to withdraw %d from bank %s. Funds of bank: %d.",
                    name, withdrawalAmount, bank.getName(), bank.getMoneyAmount()));
            bank.getMoney(withdrawalAmount, name);
        }
    }
}