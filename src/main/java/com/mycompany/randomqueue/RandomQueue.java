package com.mycompany.randomqueue;

import java.util.Iterator;
import java.util.Random;

public class RandomQueue<Item>  implements Iterable<Item> {
    private Item [] list;
    private int size;
    private int count;

    public RandomQueue() {
        this.size = 10;
        this.list = (Item[]) new Object[this.size];;
        this.count = 0;
    }

    public void enqueue(Item value) {
        checkIfListIsFullAndCopyValues();
        list[count] = value;
        count++;
    }

    private void checkIfListIsFullAndCopyValues() {
        if (count == size) {
            size *= 2;
            Item[] temp = (Item[]) new Object[size];
            System.arraycopy(list, 0, temp, 0, count);
            list = temp;
        }
    }

    public Item dequeue() {
        Random random = new Random();
        if (count > 0) {
            int randomIndex = random.nextInt(count);
            Item valueToRemove = list[randomIndex];

            // Shift elements to remove the selected element
            for (int i = randomIndex; i < count - 1; i++) {
                list[i] = list[i + 1];
            }

            count--;
            return valueToRemove;
        }
        throw new IllegalStateException("Queue is empty. Cannot dequeue.");
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int count() {
        return count;
    }

    public Item[] getQueue() {
        Item[] result = (Item[]) new Object[count()];
        System.arraycopy(list, 0, result, 0, count);
        return result;
    }

    @Override
    public Iterator<Item> iterator() {

        System.out.println("Using RandomQueueIterator");
        return new RandomQueueIterator();
    }

    private class RandomQueueIterator implements Iterator<Item> {
        private Item[] container; // Reference to the original list
        private int[] shuffledIndices; // Array with shuffled indices
        private int currentIndex = 0;
        private int sizeToCopy = count;
    
        // Constructor takes the list and its current size
        public RandomQueueIterator() {
            container = list; // Save reference to the original list
            shuffledIndices = new int[sizeToCopy];
            for (int i = 0; i < sizeToCopy; i++) {
                shuffledIndices[i] = i; // Fill the indices array
            }
            shuffleArray(shuffledIndices); // Shuffle the indices
        }
    
        // Shuffle the array using Fisher-Yates algorithm
        private void shuffleArray(int[] array) {
            Random random = new Random();
            for (int i = array.length - 1; i > 0; i--) {
                int j = random.nextInt(i + 1);
                // Swap
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    
        @Override
        public boolean hasNext() {
            return currentIndex < shuffledIndices.length;
        }
    
        @Override
        public Item next() {
            if (!hasNext()) {
                throw new IllegalStateException("No more elements in the queue.");
            }
            return container[shuffledIndices[currentIndex++]]; // Access to the list
        }
    }
}
