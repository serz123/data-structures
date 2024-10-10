package com.mycompany.hashtableqp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HashTableQP<T> {

    int size;
    private Object[] table;
    int totalNumberOfConflicts;
    List<Integer> conflictsPerInsert;

    public HashTableQP(int m) {
        this.size = m;
        this.table = new Object[m];
        this.conflictsPerInsert = new ArrayList<>();
    }

    public void insert(T key) {
        int hv = Math.abs(key.hashCode()) % size;
        // Print hash value for demonstrations purposes
        int i = 0;  

        while (table[(hv + i * i) % size] != null && i < size) {
            i++;
        }

        if (i < size) {
            table[(hv + i * i) % size] = key;
            System.out.println("Number of conflicts for this insert is " + i);

            if (conflictsPerInsert != null) {
                  conflictsPerInsert.add(i);
            } else {
                conflictsPerInsert.add(0);
            }

            totalNumberOfConflicts += i;
        } else {
            System.out.println("The table is full. It is not possible to add a new value!" + key + ". Number of conflicts = " + i);
        }
    }

    public boolean find(Integer key) {
        
        int hv = Math.abs(key.hashCode()) % size;
        int i = 0;

        while (table[(hv + i * i) % size] != null) {
            if (Objects.equals(table[(hv + i * i) % size], key)) {
                return true;
            }
            i++;
        }
        
        return false;
    }

    public int getLength() {
        int count = 0;
        for (Object v : table) {
            if (v != null) {
                count++;
            }
        }
        return count;
    }

    public int getTotalNumberOfConlicts() {
        return totalNumberOfConflicts;
    }

    public List<Integer> getConflictsPerInsert() {
        return conflictsPerInsert;
    }

    public void printTable() {
        System.out.println("HASH TABLE:");
        System.out.println(Arrays.toString(table));
    }
}
