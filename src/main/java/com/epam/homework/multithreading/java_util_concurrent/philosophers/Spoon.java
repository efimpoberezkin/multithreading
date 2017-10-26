package com.epam.homework.multithreading.java_util_concurrent.philosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Spoon {

    public Lock lock = new ReentrantLock();
}
