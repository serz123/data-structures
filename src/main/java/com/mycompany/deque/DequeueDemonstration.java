package com.mycompany.deque;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DequeueDemonstration {

    Dequeue queue = new Dequeue();

    public void run() {
        System.out.println("Dequeue demonstration");
        printQueue(queue.getQueueAsArray());
        try {
            System.out.println("\nTrying to remove first value from an empty dequeue");
            System.out.println("The dequeue is empty: " + queue.isEmpty());
            queue.removeFirst();

            System.out.println("\nTrying to remove last value from an empty dequeue");
            System.out.println("The dequeue is empty: " + queue.isEmpty());
            queue.removeLast();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n"
                + //
                "Adding some values...");
        queue.addFirst(6);
        queue.addLast(8);
        queue.addFirst(4);
        queue.addFirst(10);
        printQueue(queue.getQueueAsArray());

        System.out.println("\n"
                + //
                "Adding value 3 to the beginning of the dequeue!");
        queue.addFirst(3);
        printQueue(queue.getQueueAsArray());

        System.out.println("\n"
                + //
                "Adding value 2 to the beginning of the dequeue!");
        queue.addFirst(2);
        printQueue(queue.getQueueAsArray());

        System.out.println("\n"
                + //
                "Adding value 25 to the end of the dequeue!");
        queue.addLast(25);
        printQueue(queue.getQueueAsArray());

        System.out.println("\n"
                + //
                "Removing the first value");
        queue.removeFirst();
        printQueue(queue.getQueueAsArray());

        System.out.println("\n"
                + //
                "Removing the last value");
        queue.removeLast();
        printQueue(queue.getQueueAsArray());

        System.out.println("\n"
                + //
                "Adding 100 values to the beginning of the queue");
        for (int i = 100; i < 200; i++) {
            queue.addFirst(i);
        }
        printQueue(queue.getQueueAsArray());

        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        // Handling input for adding a number to the beginning of the queue
        while (!validInput) {
            try {
                System.out.println("\nEnter a number to add to the beginning of the queue:");
                int input = scanner.nextInt();
                queue.addFirst(input);
                validInput = true;
                printQueue(queue.getQueueAsArray());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next();
            }
        }

        validInput = false;
        while (!validInput) {
            try {
                System.out.println("\nEnter a number to add to the end of the queue:");
                int input2 = scanner.nextInt();
                queue.addLast(input2);
                validInput = true;  // Exit the loop if input is valid
                printQueue(queue.getQueueAsArray());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next();  // Clear the invalid input
            }
        }

        scanner.close();
    }

    public void printQueue(int[] queue) {
        System.out.println("Dequeue: ");
        for (int i = 0; i < queue.length; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

}
