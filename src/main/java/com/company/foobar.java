package com.company;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class foobar {
    class FooBar {
        private int n;

        public FooBar(int n) {
            this.n = n;
        }

        CyclicBarrier cb = new CyclicBarrier(2);
        volatile AtomicInteger count = new AtomicInteger(0);
        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (true){
                    if (count.get()%2!=0) wait();
                    if (count.get()%2!=0) continue;
                    break;
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                count.getAndIncrement();
                notifyAll();
                try {
                    cb.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (true){
                    if (count.get()%2==0) wait();
                    if (count.get()%2==0) continue;
                    break;
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                count.getAndIncrement();
                notifyAll();
                try {
                    cb.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
