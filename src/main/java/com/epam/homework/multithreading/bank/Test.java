package com.epam.homework.multithreading.bank;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        perform_test();
    }

    private static void perform_test() {

        /*
         * For easy reproducibility of incorrect withdrawal exception all users of a specific bank
         * continuously withdraw fixed amount of money which gives no remainder when dividing bank money amount by it
         */

        Bank bank = new Bank("Test Bank", 10000);
        List<Thread> userThreads = formUserThreadsForBank(bank, 30, 100);

        for (Thread thread : userThreads) {
            thread.start();
        }
    }

    private static List<Thread> formUserThreadsForBank(Bank bank, int amountOfUsers, int withdrawalAmount) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < amountOfUsers; i++) {
            BankUser bankUser = new BankUser("User " + (i + 1), bank, withdrawalAmount);
            threads.add(new Thread(bankUser));
        }
        return threads;
    }
}