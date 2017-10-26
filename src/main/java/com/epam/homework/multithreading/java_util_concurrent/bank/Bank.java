package com.epam.homework.multithreading.java_util_concurrent.bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    private String name;
    private int moneyAmount;

    public Lock lock = new ReentrantLock();

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

    public void getMoney(int amount) {
        if (moneyAmount >= amount) {
            moneyAmount -= amount;
        } else {
            throw new IncorrectWithdrawalException("Credit of bank is exceeded.");
        }
    }

    public boolean hasMoney(int amount) {
        return moneyAmount >= amount;
    }
}