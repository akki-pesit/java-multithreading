package org.akshay.threadruns;

import org.akshay.multithreadingimplementation.MultithreadingWithInterface;
import org.akshay.multithreadingimplementation.MultithreadingWithThread;

public class SimpleThreadExecution {
    public void runThreads() {
        System.out.println("Thread t1 Started: " + Thread.currentThread().getName());
        MultithreadingWithInterface runnableObj = new MultithreadingWithInterface();
        Thread t1 = new Thread(runnableObj);
        t1.start();

        System.out.println("Thread t2 Started: " + Thread.currentThread().getName());
        MultithreadingWithThread t2 = new MultithreadingWithThread();
        t2.start();
    }
}
