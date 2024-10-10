package com.mycompany.treecomparation;

import java.util.Random;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.mycompany.avltree.AVLTree;
import com.mycompany.binarysearchtree.BinarySearchTree;
import com.mycompany.timer.Timer;

public class TimeComparationBstVsAvl {

    private static final int MAX_ELEMENTS = 1000000;
    private static final int STEPS = 1000;
    static Random rand = new Random();

    public void run() {
        // Create series for add, delete, and contains operations
        XYSeries seriesBSTInsert = new XYSeries("BST Insert");
        XYSeries seriesAVLInsert = new XYSeries("AVL Insert");
        XYSeries seriesBSTDelete = new XYSeries("BST Delete");
        XYSeries seriesAVLDelete = new XYSeries("AVL Delete");
        XYSeries seriesBSTContains = new XYSeries("BST Contains");
        XYSeries seriesAVLContains = new XYSeries("AVL Contains");
        Timer timer = new Timer();

        for (int i = 0; i <= MAX_ELEMENTS; i += STEPS) {
            final int randomValueForContainsAndDeletes = rand.nextInt(i + 1);
            System.out.println("Processing: " + i + " elements");
            int[] randomNumbers = generateRandomNumbers(i);
            BinarySearchTree bst = new BinarySearchTree();
            AVLTree avl = new AVLTree();

            // Measure time to add i number of elements to BST
            long bstInsertTime = timer.timeit(() -> {
                for (int num : randomNumbers) {
                    bst.add(num);
                }
            });

            // Measure time to add i number of elements to BST
            long avlInsertTime = timer.timeit(() -> {
                for (int num : randomNumbers) {
                    avl.add(num);
                }
            });

            // Measure time for one contains operation for a BST that contains max i number of nodes
            long bstContainsTime = timer.timeit(() -> {
                bst.contains(randomValueForContainsAndDeletes);
            });

            // Measure time for one contains operation for a AVL that contains max i number of nodes
            long avlContainsTime = timer.timeit(() -> {
                avl.contains(randomValueForContainsAndDeletes);
            });

            // Measure time for one delete operation for a BST that contains max i number of nodes
            long bstDeleteTime = timer.timeit(() -> {
                bst.delete(randomValueForContainsAndDeletes);
            });

            // Measure time for one delete operation for a AVL that contains max i number of nodes
            long avlDeleteTime = timer.timeit(() -> {
                avl.delete(randomValueForContainsAndDeletes);
            });

            // Add the recorded times to their respective series
            seriesBSTInsert.add(i, bstInsertTime);
            seriesAVLInsert.add(i, avlInsertTime);
            seriesBSTDelete.add(i, bstDeleteTime);
            seriesAVLDelete.add(i, avlDeleteTime);
            seriesBSTContains.add(i, bstContainsTime);
            seriesAVLContains.add(i, avlContainsTime);
        }
        // Create and display the chart
        createChart(seriesBSTInsert, seriesAVLInsert);
        createChart(seriesBSTContains, seriesAVLContains);
        createChart(seriesBSTDelete, seriesAVLDelete);

    }

    private static int[] generateRandomNumbers(int count) {
        int[] randomNumbers = new int[count];
        for (int i = 0; i < count; i++) {
            randomNumbers[i] = rand.nextInt(1000000);
        }
        return randomNumbers;
    }

    private static void createChart(XYSeries... series) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        for (XYSeries s : series) {
            dataset.addSeries(s);
        }

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Tree Operations Time Comparison: BST vs AVL Tree",
                "Number of Elements",
                "Time (nanoseconds)",
                dataset,
                PlotOrientation.VERTICAL,
                true, // include legend
                true, // tooltips
                false // URLs
        );

        JFrame frame = new JFrame("BST vs AVL Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChartPanel(chart));
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

/*
         Random rand = new Random();
        int[] randomNumbers = new int[MAX_ELEMENTS];
        for (int i = 0; i < MAX_ELEMENTS; i++) {
            randomNumbers[i] = rand.nextInt(100000);
        }

        // Measure BST addition time
        for (int i = 0; i < randomNumbers.length; i++) {
            final int value = randomNumbers[i];
            long bstInsertTime = timer.timeit(() -> {
                bst.add(value);
            });
            seriesBSTInsert.add(i, bstInsertTime);
        }

        // Measure AVL addition time
        for (int i = 0; i < randomNumbers.length; i++) {
            final int value = randomNumbers[i];
            long avlInsertTime = timer.timeit(() -> {
                avl.add(value);
            });
            seriesAVLInsert.add(i, avlInsertTime);
        }

        // Measure BST contains time
        for (int i = 0; i < randomNumbers.length; i++) {
            final int value = randomNumbers[i];
            long bstContainsTime = timer.timeit(() -> {
                bst.contains(value);
            });
            seriesBSTContains.add(i, bstContainsTime);
        }

        // Measure AVL contains time
        for (int i = 0; i < randomNumbers.length; i++) {
            final int value = randomNumbers[i];
            long avlContainsTime = timer.timeit(() -> {
                avl.contains(value);
            });
            seriesAVLContains.add(i, avlContainsTime);
        }

        // Measure BST deletion time
        for (int i = 0; i < randomNumbers.length; i++) {
            final int value = randomNumbers[i];
            long bstDeleteTime = timer.timeit(() -> {
                bst.delete(value);
            });
            seriesBSTDelete.add(i, bstDeleteTime);
        }

        // Measure AVL deletion time
        for (int i = 0; i < randomNumbers.length; i++) {
            final int value = randomNumbers[i];
            long avlDeleteTime = timer.timeit(() -> {
                avl.delete(value);
            });
            seriesAVLDelete.add(i, avlDeleteTime);
        }

        // Create and display separate charts
        createChart("Insert Operation: BST vs AVL", seriesBSTInsert, seriesAVLInsert);
        createChart("Contains Operation: BST vs AVL", seriesBSTContains, seriesAVLContains);
        createChart("Delete Operation: BST vs AVL", seriesBSTDelete, seriesAVLDelete);
    }

    private static void createChart(String title, XYSeries series1, XYSeries series2) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);

        JFreeChart chart = ChartFactory.createXYLineChart(
                title,
                "Number of Elements",
                "Time (nanoseconds)",
                dataset,
                PlotOrientation.VERTICAL,
                true, // include legend
                true, // tooltips
                false // URLs
        );

        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChartPanel(chart));
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
 */
