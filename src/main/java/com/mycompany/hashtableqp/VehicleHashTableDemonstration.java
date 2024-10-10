package com.mycompany.hashtableqp;

import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class VehicleHashTableDemonstration {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Random RANDOM = new Random();
    
    public void run() {
        System.out.println("Simple demonstration");
        HashTableQP<Vehicle> hashTable = new HashTableQP<>(8);

        Vehicle v1 = new Vehicle("ABC123");
        Vehicle v2 = new Vehicle("XYZ789");
        Vehicle v3 = new Vehicle("ABC123");
        Vehicle v4 = new Vehicle("LMN456");
        Vehicle v5 = new Vehicle("PQR567");


        hashTable.insert(v1);
        hashTable.insert(v2);
        hashTable.insert(v3);
        hashTable.insert(v4);
        hashTable.insert(v5);

        hashTable.printTable();
        System.out.println("The total number of conflicts is " + hashTable.getTotalNumberOfConlicts() + 
        ". The number of inserted vehicles is: " + hashTable.getLength());
    }


    public void runLargerDataSet(int tableSize, int numberOfVehicles) {
        XYSeries conflictSeries = new XYSeries("Conflicts per Insert");
        HashTableQP<Vehicle> hashTable = new HashTableQP<>(tableSize);

        for (int i = 0; i < numberOfVehicles; i++) {
            Vehicle vehicle = new Vehicle(generateRegistrationNumber());
            hashTable.insert(vehicle);
        }

        hashTable.printTable();
        System.out.println("Total number of conflicts during inserting " + numberOfVehicles + " Vehicles in table with size " + tableSize + 
        " is " + hashTable.getTotalNumberOfConlicts() + ". The number of inserted vehicles is: " + hashTable.getLength());

        List<Integer> conflicts = hashTable.getConflictsPerInsert();
        for (int i = 0; i < conflicts.size(); i++) {
            conflictSeries.add(i + 1, conflicts.get(i));  // x = insertion number, y = conflicts
        }

        createChart(conflictSeries);
    }

    public static String generateRegistrationNumber() {
        StringBuilder regNum = new StringBuilder();
        
        for (int i = 0; i < 3; i++) {
            char letter = ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length()));
            regNum.append(letter);
        }
 
        for (int i = 0; i < 3; i++) {
            int digit = RANDOM.nextInt(10);
            regNum.append(digit);
        }

        return regNum.toString();
    }
    private static void createChart(XYSeries series) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Hash Table - Number of Conflicts during Insertions",
                "Number of the Insertion",
                "Number of Conflicts",
                dataset,
                PlotOrientation.VERTICAL,
                true,  // include legend
                true,  // tooltips
                false  // URLs
        );

        // Create and display the JFrame for the chart
        JFrame frame = new JFrame("Hash Table - Conflicts Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChartPanel(chart));
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}