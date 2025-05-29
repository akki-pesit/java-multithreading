package org.akshay.problems;

public class OddEven {
    public Integer counter = 0;

    public void printOddEven() {
        Thread printOdd = new Thread(() -> {
            while (true) {
                try {
                    printOddF();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread printEven = new Thread(() -> {
            while (true) {
                try {
                    printEvenF();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        printOdd.start();
        printEven.start();
    }

    private synchronized void printEvenF() throws InterruptedException {
        while (counter % 2 == 0) {
            wait();
        }

        counter++;
        System.out.printf("Even func: %d\n", counter);
        notifyAll();
    }

    private synchronized void printOddF() throws InterruptedException {
        while (counter % 2 != 0) {
            wait();
        }

        counter++;
        System.out.printf("Odd func: %d\n", counter);
        notifyAll();
    }
}
