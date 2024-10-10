package com.mycompany.app;

import com.mycompany.hashtableqp.VehicleHashTableDemonstration;

public class Uppgift5och6 {

    public static void main(String[] args) {
        VehicleHashTableDemonstration demonstration = new VehicleHashTableDemonstration();

       System.out.println("Insert 100 vehicles to table of size 100");
        demonstration.runLargerDataSet(100, 100);


        System.out.println();
        System.out.println("Insert 50 vehicles to table of size 100");
        demonstration.runLargerDataSet(100, 50);

        System.out.println();
        System.out.println("Insert 25 vehicles to table of size 100");
        demonstration.runLargerDataSet(100, 25);


        // Simple demonstration
        System.out.println();
        System.out.println("Insert 5 Vehicles to a table with size 8.");
        demonstration.run();


        // Analyse graphs of the biger datasets - decoment to see demonstration explanation is in readme.md"
        // System.out.println();
        // System.out.println("Insert 2500 vehicles to table of size 10000");
        // demonstration.runLargerDataSet(10000, 2500);

        // System.out.println();
        // System.out.println("Insert 2500 vehicles to table of size 10000");
        // demonstration.runLargerDataSet(10000, 5000);

        // System.out.println();
        // System.out.println("Insert 2500 vehicles to table of size 10000");
        // demonstration.runLargerDataSet(10000, 10000);
    }

}
