package com.imranali;

public class App {
    public static void main(String[] args) throws InterruptedException {
        MessageQueue queue = new MessageQueue(10);

        // start both producer and consumer threads
        Producer producer = new Producer(queue, 10);
        Thread producerThread = new Thread(producer);
        producerThread.start();

        Consumer consumer = new Consumer(queue);
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
    }
}

