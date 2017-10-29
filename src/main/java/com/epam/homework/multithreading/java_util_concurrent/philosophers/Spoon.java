package com.epam.homework.multithreading.java_util_concurrent.philosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Spoon {

    final private Lock lock = new ReentrantLock();

    private Philosopher currentPhilosopher;

    public void use(Philosopher philosopher) {
        lock.lock();
        currentPhilosopher = philosopher;
    }

    public void release(Philosopher philosopher) {
        if (philosopher == currentPhilosopher) {
            lock.unlock();
        }
    }
}
