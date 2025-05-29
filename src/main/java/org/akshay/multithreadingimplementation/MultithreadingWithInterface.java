package org.akshay.multithreadingimplementation;

public class MultithreadingWithInterface implements Runnable {
    @Override
    public void run() {
        System.out.println("Implement Runnable Implementation: code executed by thread: "
            + Thread.currentThread().getName());
    }
}
