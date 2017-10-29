package com.epam.homework.multithreading.java_util_concurrent.philosophers;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Spoon {

    final private Lock lock = new ReentrantLock();

    private AtomicReference<Philosopher> currentPhilosopher = new AtomicReference<>();

    public void use(Philosopher philosopher) {
        lock.lock();
        currentPhilosopher.set(philosopher);
    }

    public void release(Philosopher philosopher) {
        if (currentPhilosopher.compareAndSet(philosopher, null)) {
            lock.unlock();
        }
    }
}
