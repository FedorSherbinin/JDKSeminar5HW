package org.example;

import org.example.fork.Fork;
import org.example.fork.ForkImpl;
import org.example.philosopher.Philosopher;
import org.example.philosopher.PhilosopherImpl;

public class Main {
    public static void main(String[] args) {
        int numberOfPhilosophers = 5;
        Fork[] forks = new Fork[numberOfPhilosophers];
        for (int i = 0; i < numberOfPhilosophers; i++) {
            forks[i] = new ForkImpl();
        }

        Philosopher[] philosophers = new Philosopher[numberOfPhilosophers];
        for (int i = 0; i < numberOfPhilosophers; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % numberOfPhilosophers];
            philosophers[i] = new PhilosopherImpl(leftFork, rightFork, i + 1);
        }

        Thread[] threads = new Thread[numberOfPhilosophers];
        for (int i = 0; i < numberOfPhilosophers; i++) {
            threads[i] = new Thread(philosophers[i]);
            threads[i].start();
        }

        for (int i = 0; i < numberOfPhilosophers; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        for (Philosopher philosopher : philosophers) {
            System.out.println("Философ " + philosopher.getId() + " поел " + philosopher.getMealsCount() + " раз(а).");
        }
    }
}
