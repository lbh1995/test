package com.company;

import java.util.concurrent.atomic.AtomicInteger;

public class ShareTest {
    private static class MyRun implements Runnable {
        private volatile AtomicInteger ato = new AtomicInteger(100);
        @Override
        public void run() {
            while (true) {
                if (ato.get() <= 0) {
                    break;
                }
                int tmp = ato.decrementAndGet();
                System.out.println(Thread.currentThread() + " : " + tmp);
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyRun run = new MyRun();
        Thread thread1 = new Thread(run, "线程1");
        Thread thread2 = new Thread(run, "线程2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("over");
    }
}
