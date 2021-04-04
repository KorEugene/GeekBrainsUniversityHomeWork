package lesson16.online;

public class MultiThreading {

    private final Object MONITOR = new Object();
    private char letter = 'A';

    /*
    1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС).
    Используйте wait/notify/notifyAll.
    */
    public static void main(String[] args) {
        MultiThreading multiThreading = new MultiThreading();

        new Thread(multiThreading::printA).start();
        new Thread(multiThreading::printB).start();
        new Thread(multiThreading::printC).start();
    }

    public void printA() {
        synchronized (MONITOR) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (letter != 'A') {
                        MONITOR.wait();
                    }
                    System.out.println(letter);
                    letter = 'B';
                    MONITOR.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (MONITOR) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (letter != 'B') {
                        MONITOR.wait();
                    }
                    System.out.println(letter);
                    letter = 'C';
                    MONITOR.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (MONITOR) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (letter != 'C') {
                        MONITOR.wait();
                    }
                    System.out.println(letter);
                    letter = 'A';
                    MONITOR.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
