package com.imranali;

public class Producer implements Runnable {
    private final MessageQueue queue;
    private final int messageCount;

    public Producer(MessageQueue queue, int messageCount) {
        this.queue = queue;
        this.messageCount = messageCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= messageCount; i++) {
                String message = "message " + i;
                queue.produce(message);
                System.out.println("Produced message: " + message);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Producer interrupted");
        }
    }
}

