package com.company;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class FizzBuzz {
    interface itf{
        public abstract void output();
    }
    abstract class fatreal{
        public void output(String m){};
        public abstract void output1(String m);
    }
    abstract class fat {
        public void output(String m){};
    }
    abstract class clz extends fatreal{

    }
    private int n;
    private void f(){};
    private void f(int n){
        System.out.println(n);
    };
    public FizzBuzz(int n) {
        this.n = n;
    }
    public static void main(String[] args){
        FizzBuzz fb = new FizzBuzz(1);
        fb.f(1);
    }
    private volatile AtomicInteger count = new AtomicInteger(1);
    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {

        while (count.get()<=n){
            if (count.get()%3==0 && count.get()%5!=0){
                System.out.println("fizz");
                count.getAndIncrement();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (count.get()<=n){
            if (count.get()%3!=0 && count.get()%5==0){
                System.out.println("buzz");
                count.getAndDecrement();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (count.get()<=n){
            if (count.get()%3==0 && count.get()%5==0){
                System.out.println("fizzbuzz");
                count.getAndIncrement();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (count.get()<=n){
            if (count.get()%3!=0 && count.get()%5!=0){
                System.out.println(count.get());
                count.getAndIncrement();
            }
        }
    }
}
