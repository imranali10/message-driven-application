package com.imranali;
public class Consumer implements Runnable {
    private final MessageQueue queue;
    private int successCount = 0;
    private int errorCount = 0;

    public Consumer(MessageQueue queue) {
        this.queue = queue;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public int getErrorCount() {
        return errorCount;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = queue.consume();

                if (message.isEmpty()) {
                    errorCount++;
                    System.err.println("Error processing message: " + message);
                } else {
                    successCount++;
                    System.out.println("Successfully processed message: " + message);
                }

                if (queue.isEmpty()) {
                    break;  // Break loop if the queue is empty
                }
            }

            // success / failure message summary
            System.out.println("Total messages processed successfully: " + successCount);
            System.out.println("Total errors encountered: " + errorCount);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Consumer interrupted");
        }
    }
}
