package com.company;

/**
 * wait和notify的基本用法
 * 1. 代码的执行顺序
 * 2. wait释放锁
 *
 * @author yiren
 */
public class Wait {
    private final static Object object = new Object();
    static class ThreadOne extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                try {
                    System.out.println(Thread.currentThread().getName() + " in run before wait");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " in run after wait");
            }
        }
    }
    static class ThreadTwo extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + " in run before notify");
                object.notify();
                System.out.println(Thread.currentThread().getName() + " in run after notify");
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ThreadOne threadOne = new ThreadOne();
        ThreadTwo threadTwo = new ThreadTwo();
        threadOne.start();
        Thread.sleep(100);
        threadTwo.start();
    }
}

