package org.akshay.threadruns;

import org.akshay.multithreadingimplementation.MultithreadingWithInterface;
import org.akshay.multithreadingimplementation.MultithreadingWithThread;

public class JoinExample {
    public void runThreads() throws InterruptedException {
        System.out.println("Join Example: Thread t1 Started: " + Thread.currentThread().getName());
        MultithreadingWithInterface runnableObj = new MultithreadingWithInterface();
        Thread t1 = new Thread(runnableObj);
        t1.start();

        System.out.println("Join Example: Thread t2 Started: " + Thread.currentThread().getName());
        MultithreadingWithThread t2 = new MultithreadingWithThread();
        t2.start();

        // Main thread will wait for both t1 and t2 to finish
        t1.join();
        t2.join();
    }
}
