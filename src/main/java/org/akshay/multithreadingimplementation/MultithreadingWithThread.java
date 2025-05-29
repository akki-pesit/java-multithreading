package org.akshay.multithreadingimplementation;

public class MultithreadingWithThread extends Thread {
    @Override
    public void run() {
        System.out.println("Extend Thread Implementation: code executed by thread: "
            + Thread.currentThread().getName());
    }

}
