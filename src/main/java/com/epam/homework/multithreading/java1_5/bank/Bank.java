package com.epam.homework.multithreading.java1_5.bank;

public class Bank {

    private final String name;

    private volatile int moneyAmount;

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