package org.example.fork;

import java.util.concurrent.Semaphore;

public class ForkImpl implements Fork {
    private final Semaphore semaphore;

    public ForkImpl() {
        this.semaphore = new Semaphore(1);
    }

    @Override
    public void acquire() throws InterruptedException {
        semaphore.acquire();
    }

    @Override
    public void release() {
        semaphore.release();
    }
}
