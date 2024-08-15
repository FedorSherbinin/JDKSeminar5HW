package org.example.philosopher;

import org.example.fork.Fork;

import java.util.concurrent.atomic.AtomicInteger;

public class PhilosopherImpl implements Philosopher {
    private final Fork leftFork;
    private final Fork rightFork;
    private final int id;
    private final AtomicInteger mealsCount = new AtomicInteger(0);
    private static final int MEALS = 3;

    public PhilosopherImpl(Fork leftFork, Fork rightFork, int id) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < MEALS; i++) {
                think();
                eat();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void think() throws InterruptedException {
        System.out.println("Философ " + id + " думает.");
        Thread.sleep((int) (Math.random() * 1000));
    }

    @Override
    public void eat() throws InterruptedException {
        leftFork.acquire();
        rightFork.acquire();

        System.out.println("Философ " + id + " ест.");
        Thread.sleep((int) (Math.random() * 1000));

        mealsCount.incrementAndGet();

        leftFork.release();
        rightFork.release();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getMealsCount() {
        return mealsCount.get();
    }
}
