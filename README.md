# Producer-Consumer in Java

This is a simple Java application that simulates the **Producer-Consumer** pattern using a **BlockingQueue** (`LinkedBlockingQueue`). The **Producer** generates messages and places them into the queue, while the **Consumer** processes the messages. It also tracks the number of successful and erroneous message processes.

## Key Classes

- **App.java**: Starts both the **Producer** and **Consumer** threads.
- **MessageQueue.java**: Manages the queue using `BlockingQueue`.
- **Producer.java**: Simulates a producer that produces messages.
- **Consumer.java**: Simulates a consumer that processes messages and counts successes/errors.

## Installation

### Clone the repository:

```bash
git clone https://github.com/imranali10/message-driven-application.git
cd message-driven-application

Build and Run the Application
If you're using Maven as the build tool, you can compile and run the application by using the following commands:

mvn clean install
mvn exec:javav

Run the project:
Once the project is built, you can run the application using Maven:

mvn exec:java -Dexec.mainClass="com.example.App"

