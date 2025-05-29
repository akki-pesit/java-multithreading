package org.akshay.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExample {
    private static final int BUFFER_CAPACITY = 5;
    public static final int CONSUMER_LAG = 1000;
    public static final int PRODUCER_LAG = 500;
    private final Queue<Integer> buffer = new LinkedList<>();
    private final Object lock = new Object();

    class Producer implements Runnable {
        private int value = 0;

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (buffer.size() == BUFFER_CAPACITY) {
                        try {
                            System.out.println("Buffer full. Producer waiting...");
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    buffer.add(value);
                    System.out.println("Produced: " + value);
                    value++;

                    lock.notifyAll();

                    try {
                        Thread.sleep(PRODUCER_LAG); // Simulate time to produce
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (buffer.isEmpty()) {
                        try {
                            System.out.println("Buffer empty. Consumer waiting...");
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    int data = buffer.poll();
                    System.out.println("Consumed: " + data);

                    lock.notifyAll();

                    try {
                        Thread.sleep(CONSUMER_LAG); // Simulate time to consume
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public void start() {
        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());

        producerThread.start();
        consumerThread.start();
    }
}
