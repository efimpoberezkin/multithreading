package com.epam.homework.multithreading.java1_5.bank;

public class BankUser implements Runnable {

    final private String name;
    final private Bank bank;
    final private int withdrawalAmount;

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
            synchronized (bank) {
                if (bank.hasMoney(withdrawalAmount)) {
                    System.out.println(String.format(
                            "%s: \u2713 Funds of bank %s: %d. Bank has sufficient funds. Withdrawing %d.",
                            name, bank.getName(), bank.getMoneyAmount(), withdrawalAmount));
                    bank.getMoney(withdrawalAmount);
                    System.out.println(String.format(
                            "%s: Withdrawal operation complete. Withdrew %d from bank %s. Funds of bank: %d.",
                            name, withdrawalAmount, bank.getName(), bank.getMoneyAmount()));
                } else {
                    System.out.println(String.format(
                            "%s: \u2717 Funds of bank %s: %d. Bank has insufficient funds. Could not withdraw %d.",
                            name, bank.getName(), bank.getMoneyAmount(), withdrawalAmount));
                }
            }
        }
    }
}