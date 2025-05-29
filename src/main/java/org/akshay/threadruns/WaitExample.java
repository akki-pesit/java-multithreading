package org.akshay.threadruns;

import org.akshay.multithreadingimplementation.MultithreadingWithInterface;
import org.akshay.multithreadingimplementation.SleepsThread;

public class WaitExample {
    final Object lock = new Object();
    public void runThreads() throws InterruptedException {
        System.out.println("Wait Example started: " + Thread.currentThread().getName());
        Object lock = new Object();

        // Start the thread that will wait
        SleepsThread sleepsThread = new SleepsThread(lock);
        Thread t1 = new Thread(sleepsThread);
        t1.start();

        // Sleep to ensure t1 gets to wait() first
        Thread.sleep(1000);

        // Main thread will notify
        synchronized (lock) {
            System.out.println("Main: Notifying sleeps thread...");
            lock.notify();
        }

        // Wait for t1 to complete
        t1.join();
    }
}
