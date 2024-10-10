    package com.mycompany.randomqueue;

    import java.util.InputMismatchException;
    import java.util.Scanner;
    
    public class RandomQueueDemonstration {
    
        RandomQueue<Integer> queue = new RandomQueue<>();
    
        public void run() {
            System.out.println("RandomQueue demonstration");
            printQueue(); 
            
            // Attempting to dequeue from an empty queue
            try {
                System.out.println("\nTrying to dequeue from an empty queue");
                System.out.println("The queue is empty: " + queue.isEmpty());
                queue.dequeue();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    
            // Adding values to the queue
            System.out.println("\nAdding some values...");
            queue.enqueue(5);
            queue.enqueue(10);
            queue.enqueue(15);
            queue.enqueue(20);
            printQueue(); 
    
            // Dequeueing a random element
            System.out.println("\nRemoving a random value...");
            queue.dequeue();
            printQueue(); 
    
            // Adding multiple values
            System.out.println("\nAdding 50 values...");
            for (int i = 1; i <= 50; i++) {
                queue.enqueue(i);
            }
            printQueue(); 
    
            // Handling input for adding a number
            Scanner scanner = new Scanner(System.in);
            boolean validInput = false;
    
            // Adding a number to the queue
            while (!validInput) {
                try {
                    System.out.println("\nEnter a number to add to the queue:");
                    int input = scanner.nextInt();
                    queue.enqueue(input);
                    validInput = true;
                    printQueue(); 
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a valid number.");
                    scanner.next(); 
                }
            }
    
            scanner.close();
        }
    
        public void printQueue() {
            System.out.println("Queue (Random order): ");
            for (Integer value : queue) {  
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
    