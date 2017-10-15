package com.epam.homework.multithreading.philosophers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) {
        perform_test();
    }

    private static void perform_test() {

        Spoon spoon1 = new Spoon();
        Spoon spoon2 = new Spoon();
        Spoon spoon3 = new Spoon();
        Spoon spoon4 = new Spoon();
        Spoon spoon5 = new Spoon();

        Philosopher philosopher1 = new Philosopher("Philosopher 1", spoon1, spoon5);
        Philosopher philosopher2 = new Philosopher("Philosopher 2", spoon2, spoon1);
        Philosopher philosopher3 = new Philosopher("Philosopher 3", spoon3, spoon2);
        Philosopher philosopher4 = new Philosopher("Philosopher 4", spoon4, spoon3);
        Philosopher philosopher5 = new Philosopher("Philosopher 5", spoon5, spoon4);

        ExecutorService service = Executors.newFixedThreadPool(5);
        service.submit(philosopher1);
        service.submit(philosopher2);
        service.submit(philosopher3);
        service.submit(philosopher4);
        service.submit(philosopher5);
    }
}
