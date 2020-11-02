package com.company;

import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 * 用wait notify实现生产者消费者模式
 * @author yiren
 */
public class ProducerConsumer {

    public static void main(String[] args) {
        EventStorage storage = new EventStorage();
        Thread producerThread = new Thread(new Producer(storage));
        Thread consumerThread = new Thread(new Consumer(storage));
        producerThread.start();
        consumerThread.start();

    }

    private static class Producer implements Runnable{
        EventStorage storage;

        public Producer(EventStorage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                storage.put();
            }
        }
    }
    private static class Consumer implements Runnable{
        EventStorage storage;

        public Consumer(EventStorage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                storage.take();
            }
        }
    }

    private static class EventStorage {
        private int maxSize;
        private LinkedList<LocalDateTime> storage;

        public EventStorage() {
            maxSize = 10;
            storage = new LinkedList<>();
        }

        public synchronized void put() {
            while (storage.size() == maxSize) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            storage.add(LocalDateTime.now());
            System.out.println("storage has " + storage.size() + " product(s).");
            this.notify();
        }

        public synchronized void take() {
            while (storage.size() == 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("get date " + storage.poll() + ", storage has " + storage.size() + " product(s).");
            this.notify();
        }
    }
}

