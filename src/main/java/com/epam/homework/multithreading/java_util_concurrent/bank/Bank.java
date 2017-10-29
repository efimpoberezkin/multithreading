package com.epam.homework.multithreading.java_util_concurrent.bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    //поле может быть final
    private String name;
    //В будущем стоит изучить необходимость использования volatile для подобных переменных
    //В реальном продакшене без volatile это не будет работать
    private int moneyAmount;
    //Рекомендуется все final поля (aka. конфигурацию-сервисы) объявлять выше не final,
    //отделяя таким образом поля состояния от полей от конфигурации
    //поле может быть final
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
                        "%s: <Bank message> \u2713 Funds: %d. Bank has sufficient funds. Giving %d to client.",
                        userName, moneyAmount, amount));
                moneyAmount -= amount;
                System.out.println(String.format(
                        "%s: <Bank message> Withdrawal operation complete. Gave %d to client. Funds: %d.",
                        userName, amount, moneyAmount));
            } else {
                System.out.println(String.format(
                        "%s: <Bank message> \u2717 Funds: %d. Bank has insufficient funds. Could not give %d to client.",
                        userName, moneyAmount, amount));
            }

        } finally {
            lock.unlock();
        }
    }

    //Ошибка - метод производит незащищённый конкурентный доступ к данным.
    private boolean hasMoney(int amount) {
        return moneyAmount >= amount;
    }
}