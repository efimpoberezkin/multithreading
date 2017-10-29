package com.epam.homework.multithreading.java_util_concurrent.philosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Spoon {

    private Lock lock = new ReentrantLock();
    private Philosopher currentPhilosopher;

    public void use(Philosopher philosopher) {
        lock.lock();
        currentPhilosopher = philosopher;
    }

    public void release(Philosopher philosopher) {
        //Этот if не защищает от того, что неавторизованный философ опустит ложку.
        //Неатомарное исполнение 12-3 строки и 19-20 могут привести к этому
        if (philosopher == currentPhilosopher) {
            lock.unlock();
        }
        //Если придерживаться этого решения, то:
        //1. нужно делать что-то типа compareAndSet
        //2. нужно выставлять в null значение currentPhilosopher на release
    }
}
