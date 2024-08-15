package org.example.philosopher;

public interface Philosopher extends Runnable {
    void think() throws InterruptedException;

    void eat() throws InterruptedException;

    int getId();
    int getMealsCount();
}
