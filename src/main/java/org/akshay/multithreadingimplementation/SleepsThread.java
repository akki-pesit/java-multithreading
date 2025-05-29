package org.akshay.multithreadingimplementation;

public class SleepsThread implements Runnable {
// Wait and notify should be called inside a synchronised block only

    public final Object lock;
    public SleepsThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                lock.wait();
                System.out.println("Sleeps thread started for 2 sec: " + Thread.currentThread().getName());
                for (int i=0; i<5; i++){
                    System.out.print("---" + i);
                    Thread.sleep(1000);
                }
                System.out.println("\nSleeps thread ended: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock.notify();
        }
    }
}
