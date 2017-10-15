package com.epam.homework.multithreading.philosophers;

public class Spoon {

    private boolean taken;

    public Spoon() {
        this.taken = false;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }
}
