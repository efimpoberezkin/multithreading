package com.epam.homework.multithreading.java_util_concurrent.philosophers;

import static java.lang.Thread.sleep;

public class Philosopher implements Runnable {

    private String name;
    private Spoon firstSpoon;
    private Spoon secondSpoon;

    public Philosopher(String name, Spoon leftSpoon, Spoon rightSpoon) {
        this.name = name;
        this.firstSpoon = leftSpoon;
        this.secondSpoon = rightSpoon;
    }

    @Override
    public void run() {
        System.out.println(name + " thinking");

        while (true) {
            firstSpoon.lock.lock();
            try {
                secondSpoon.lock.lock();
                try {
                    System.out.println(name + " eating");
                    pause();
                    System.out.println(name + " thinking");
                } finally {
                    secondSpoon.lock.unlock();
                }
            } finally {
                firstSpoon.lock.unlock();
            }
            pause();
        }
    }

    private void pause() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}