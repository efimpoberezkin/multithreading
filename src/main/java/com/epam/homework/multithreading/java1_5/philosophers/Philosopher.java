package com.epam.homework.multithreading.java1_5.philosophers;

import static java.lang.Thread.sleep;

public class Philosopher implements Runnable {

    private final String name;
    private final Spoon firstSpoon;
    private final Spoon secondSpoon;

    public Philosopher(String name, Spoon leftSpoon, Spoon rightSpoon) {
        this.name = name;
        this.firstSpoon = leftSpoon;
        this.secondSpoon = rightSpoon;
    }

    @Override
    public void run() {
        System.out.println(name + " thinking");

        while (true) {
            synchronized (firstSpoon) {
                synchronized (secondSpoon) {
                    System.out.println(name + " eating");
                    pause();
                    System.out.println(name + " thinking");
                }
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