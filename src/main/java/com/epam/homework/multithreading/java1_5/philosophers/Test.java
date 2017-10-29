package com.epam.homework.multithreading.java1_5.philosophers;

public class Test {

    public static void main(String[] args) {
        performTest();
    }

    private static void performTest() {

        Spoon spoon1 = new Spoon();
        Spoon spoon2 = new Spoon();
        Spoon spoon3 = new Spoon();
        Spoon spoon4 = new Spoon();
        Spoon spoon5 = new Spoon();

        /*
         * Using resources hierarchy method: resources are ordered between each other,
         * they are being taken in this order and returned in reverse order.
         * Specifically, for each philosopher the spoon he takes first is the one with lower order
         * and the one he returns first is the one with the higher order.
         */
        Philosopher philosopher1 = new Philosopher("Philosopher 1", spoon1, spoon5);
        Philosopher philosopher2 = new Philosopher("Philosopher 2", spoon1, spoon2);
        Philosopher philosopher3 = new Philosopher("Philosopher 3", spoon2, spoon3);
        Philosopher philosopher4 = new Philosopher("Philosopher 4", spoon3, spoon4);
        Philosopher philosopher5 = new Philosopher("Philosopher 5", spoon4, spoon5);

        new Thread(philosopher1).start();
        new Thread(philosopher2).start();
        new Thread(philosopher3).start();
        new Thread(philosopher4).start();
        new Thread(philosopher5).start();
    }
}
