package com.epam.homework.multithreading.java_util_concurrent.bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    private String name;
    private int moneyAmount;
    private Lock lock = new ReentrantLock();

    public Bank(String name, int moneyAmount) {
        this.name = name;
        this.moneyAmount = moneyAmount;
    }

    public String getName() {
        return name;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void getMoney(int amount, String userName) {
        lock.lock();
        try {
            if (hasMoney(amount)) {
                System.out.println(String.format(
                        "%s: \u2713 Funds of bank %s: %d. Bank has sufficient funds. Withdrawing %d.",
                        userName, name, moneyAmount, amount));
                moneyAmount -= amount;
                System.out.println(String.format(
                        "%s: Withdrawal operation complete. Withdrew %d from bank %s. Funds of bank: %d.",
                        userName, amount, name, moneyAmount));
            } else {
                System.out.println(String.format(
                        "%s: \u2717 Funds of bank %s: %d. Bank has insufficient funds. Could not withdraw %d.",
                        userName, name, moneyAmount, amount));
            }

        } finally {
            lock.unlock();
        }
    }

    private boolean hasMoney(int amount) {
        return moneyAmount >= amount;
    }
}