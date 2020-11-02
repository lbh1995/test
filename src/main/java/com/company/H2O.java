package com.company;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class H2O {
    public H2O() {

    }
    private volatile Semaphore h = new Semaphore(2);
    private volatile Semaphore o = new Semaphore(1);
    private volatile CyclicBarrier h2o = new CyclicBarrier(3);
    //CountDownLatch latch = null;
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        while (true){
            synchronized (this){
                if (h.availablePermits()==0&&o.availablePermits()==0){
                    releaseHydrogen.run();
                    break;
                }
            }
        }
        try {
            h2o.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        h.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire();
        while (true){
            synchronized (this){
                if (h.availablePermits()==0&&o.availablePermits()==0){
                    releaseOxygen.run();
                    break;
                }
            }
        }
        try {
            h2o.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        o.release();
    }
}
