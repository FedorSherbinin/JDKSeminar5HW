package org.example.fork;

public interface Fork {
    void acquire() throws InterruptedException;
    void release();
}