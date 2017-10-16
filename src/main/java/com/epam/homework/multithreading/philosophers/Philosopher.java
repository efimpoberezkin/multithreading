package com.epam.homework.multithreading.philosophers;

import static java.lang.Thread.sleep;

public class Philosopher implements Runnable {

    private String name;
    private Spoon firstSpoon;
    private Spoon secondSpoon;
    private boolean hasFirstSpoon;
    private boolean hasSecondSpoon;

    public Philosopher(String name, Spoon leftSpoon, Spoon rightSpoon) {
        this.name = name;
        this.firstSpoon = leftSpoon;
        this.secondSpoon = rightSpoon;
        hasFirstSpoon = false;
        hasSecondSpoon = false;
    }

    private void takeFirstSpoon() {
        synchronized (firstSpoon) {
            if (!firstSpoon.isTaken()) {
                firstSpoon.setTaken(true);
                hasFirstSpoon = true;
            }
        }
    }

    private void takeSecondSpoon() {
        synchronized (secondSpoon) {
            if (!secondSpoon.isTaken()) {
                secondSpoon.setTaken(true);
                hasSecondSpoon = true;
            }
        }
    }

    private void releaseFirstSpoon() {
        if (hasFirstSpoon) {
            firstSpoon.setTaken(false);
            hasFirstSpoon = false;
        }
    }

    private void releaseSecondSpoon() {
        if (hasSecondSpoon) {
            secondSpoon.setTaken(false);
            hasSecondSpoon = false;
        }
    }

    public void run() {
        System.out.println(name + " thinking");

        while (true) {
            if (hasFirstSpoon && hasSecondSpoon) {
                System.out.println(name + " eating");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + " thinking");
                releaseFirstSpoon();
                releaseSecondSpoon();
            }
            do {
                takeFirstSpoon();
            } while (!hasFirstSpoon);
            do {
                takeSecondSpoon();
            } while (!hasSecondSpoon);
        }
    }
}