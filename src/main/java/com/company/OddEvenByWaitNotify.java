package com.company;

import java.util.concurrent.TimeUnit;

/**
 * 使用wait-notify 实现奇偶打印
 * @author yiren
 */
public class OddEvenByWaitNotify {
    private static final Object lock = new Object();
    private static int count = 0;
    private static final int MAX_COUNT = 100;
    private static int c = 0;

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (count <= MAX_COUNT ) {
                    synchronized (lock) {
                        try {
                            System.out.println(Thread.currentThread().getName() + ": " + count++);
                            lock.notifyAll();
                            // 如果任务还没结束 就让出锁 自己休眠
                            lock.wait();
                            System.out.println(Thread.currentThread().getName() +" release" + (c++));
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread t = new Thread(){
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        t.start();
        thread1.start();
        thread2.start();
    }
}

