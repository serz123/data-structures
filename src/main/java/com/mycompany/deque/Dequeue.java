package com.mycompany.deque;

public class Dequeue {

    private int[] list;
    private int size;
    private int front;
    private int back;

    // Konstruktor
    public Dequeue() {
        this.size = 10;
        this.list = new int[size];
        this.front = 0;
        this.back = 0;
    }

    public void addLast(int value) {
        checkIfListIsFullAndCopyValues();
        if (count() < size) {
            list[back] = value;
            back = (back + 1) % size;
            checkIfListIsFullAndCopyValues();
        } else {
            throw new IllegalStateException("Queue is full. Cannot enqueue " + value);
        }
    }

    public void addFirst(int value) {
        if (count() < size) {
            if (front != 0) {
                front = front - 1;
                list[front] = value;
            } else {
                front = size - 1;
                list[front] = value;
            }
            checkIfListIsFullAndCopyValues();
        } else {
            throw new IllegalStateException("Queue is full. Cannot enqueue " + value);
        }
    }

    private void checkIfListIsFullAndCopyValues() {
        if (front == back) {
            size *= 2; 
            int[] temp = new int[size];
            for (int i = 0; i < size/2; i++) {
                temp[i] = list[(front + i) % (size / 2)];
            }
            back = size/2;
            list = temp;
            front = 0;
        }
    }

    public int removeFirst() {
        if (count() > 0) {
            int valueToRemove = list[front];
            front = (front + 1) % size;
            return valueToRemove;
        }
        throw new IllegalStateException("Queue is empty. Cannot dequeue.");
    }

    public int removeLast() {
        if (count() > 0) {
            int valueToRemove = list[back];
            if (back != 0) {
                back = back - 1;
            } else {
                back = size - 1;
            }

            return valueToRemove;
        }
        throw new IllegalStateException("Queue is empty. Cannot dequeue.");
    }

    public boolean isEmpty() {
        return front >= back;
    }

    public int count() {
        if (back >= front) {
            return back - front;
        } else {
            return size - (front - back);
        }
    }

    public int[] getQueueAsArray() {
        int[] result = new int[count()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list[(front + i) % size];
        }
        return result;
    }

}
