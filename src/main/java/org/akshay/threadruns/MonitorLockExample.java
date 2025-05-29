package org.akshay.threadruns;

public class MonitorLockExample {

    public class Tasks {
        // synchronized puts a monitor lock on this object
        public synchronized void task1() {
            try {
                System.out.println("inside task1");
                for (int i = 0; i < 10; i++) {
                    System.out.print("---" + i);
                    Thread.sleep(1000);
                }
                System.out.println("\ntask1 completed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public void task2() {
            System.out.println("task2, before synchronized");
            // This synchronized block will wait for task1 or t1 to release lock
            synchronized (this) {
                System.out.println("task2, inside synchronized");
            }
        }

        public void task3() {
            // This task will simply run without caring about lock
            System.out.println("task3");
        }
    }

    public void runThread() throws InterruptedException {
        System.out.println("Monitor lock started: " + Thread.currentThread().getName());
        Tasks tasks = new Tasks();

        // Lambda way of creating threads, remember Runnable is a functional interface
        Thread t1 = new Thread(tasks::task1);
        Thread t2 = new Thread(tasks::task2);
        Thread t3 = new Thread(tasks::task3);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
