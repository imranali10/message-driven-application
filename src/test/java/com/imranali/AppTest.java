package com.imranali;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    private MessageQueue queue;

    @BeforeEach
    void setUp() {
        queue = new MessageQueue(10);
    }

    @Test
    void testProducerConsumerForSuccess() throws InterruptedException {
        // Produce 5 messages and expect 5 successful processes
        Producer producer = new Producer(queue, 5);
        Consumer consumer = new Consumer(queue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

        // Check that all messages were processed successfully
        assertEquals(5, consumer.getSuccessCount());
        assertEquals(0, consumer.getErrorCount());
    }

    @Test
    void testProducerConsumerForFailure() throws InterruptedException {
        // check failure by introducing empty messages
        queue.produce("");
        queue.produce("");

        // Produce 5 messages and expect 2 errors (null and empty)
        Producer producer = new Producer(queue, 5);
        Consumer consumer = new Consumer(queue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

        // Expect 0 success and 2 errors
        assertEquals(0, consumer.getSuccessCount());
        assertEquals(2, consumer.getErrorCount());
    }
}

