package com.epam.homework.multithreading.philosophers;

import static java.lang.Thread.sleep;

public class Philosopher implements Runnable {

    private String name;
    private Spoon leftSpoon;
    private Spoon rightSpoon;
    private boolean hasLeftSpoon;
    private boolean hasRightSpoon;

    public Philosopher(String name, Spoon leftSpoon, Spoon rightSpoon) {
        this.name = name;
        this.leftSpoon = leftSpoon;
        this.rightSpoon = rightSpoon;
        hasLeftSpoon = false;
        hasRightSpoon = false;
    }

    private void takeLeftSpoon() {
        synchronized (leftSpoon) {
            if (!leftSpoon.isTaken()) {
                leftSpoon.setTaken(true);
                hasLeftSpoon = true;
            }
        }
    }

    private void takeRightSpoon() {
        synchronized (rightSpoon) {
            if (!rightSpoon.isTaken()) {
                rightSpoon.setTaken(true);
                hasRightSpoon = true;
            }
        }
    }

    private void releaseLeftSpoon() {
        if (hasLeftSpoon) {
            leftSpoon.setTaken(false);
            hasLeftSpoon = false;
        }
    }

    private void releaseRightSpoon() {
        if (hasRightSpoon) {
            rightSpoon.setTaken(false);
            hasRightSpoon = false;
        }
    }

    public void run() {
        System.out.println(name + " thinking");

        while (true) {
            if (hasLeftSpoon && hasRightSpoon) {
                System.out.println(name + " eating");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + " thinking");
                releaseLeftSpoon();
                releaseRightSpoon();
            }
            do {
                takeLeftSpoon();
            } while (!hasLeftSpoon);
            do {
                takeRightSpoon();
            } while (!hasRightSpoon);
        }
    }
}