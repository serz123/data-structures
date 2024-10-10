package com.mycompany.binarysearchtree;

import java.util.Random;

public class BinarySearchTreeDeomnstration {

    BinarySearchTree bst = new BinarySearchTree();

    public void run() {
        System.out.println("Binary search tree");
        System.out.println();

        System.out.println("Populating the tree with 25 random values between 0 and 100...");
        Random generator = new Random();
        for (int i = 0; i < 25; i++) {
            int random = generator.nextInt(100);
            bst.add(random);
        }

        bst.printGraph();

        System.out.println("\nInorder print");
        bst.printInorder();

        System.out.println("\nPreorder print");
        bst.printPreorder();

        System.out.println("\nPostorder print");
        bst.printPostorder();
        System.out.println();

        System.out.println();
        System.out.println("Height of the tree is " + bst.height() + "!");

        System.out.println();
        System.out.println("The tree contains value 3?  " + bst.contains(3));
        System.out.println("The tree contains value 66?  " + bst.contains(66));
        System.out.println("The tree contains value 74?  " + bst.contains(74));
        System.out.println("The tree contains value 33?  " + bst.contains(33));
        System.out.println("The tree contains value 24?  " + bst.contains(24));
        System.out.println("The tree contains value 11?  " + bst.contains(11));
        System.out.println("The tree contains value 98?  " + bst.contains(98));

        System.out.println();
        System.out.println("Adding value 985 to the tree.");
        bst.add(985);
        System.out.println("Inorder print");
        bst.printInorder();
        System.out.println("\n");

        System.out.println("Adding value 1000 to the tree.");
        bst.add(1000);
        System.out.println("Inorder print");
        bst.printInorder();
        System.out.println("\n");

        System.out.println("Deleting value 1000 from the tree.");
        bst.delete(1000);
        System.out.println("Inorder print");
        bst.printInorder();
        System.out.println("\n");

        try {
            System.out.println("Trying to delete 5th largest!");
            bst.deleteKthLargest(5);
            System.out.println("Inorder print");
            bst.printInorder();
            System.out.println("\n");

            System.out.println("Trying to delete 33th largest!");
            bst.deleteKthLargest(33);
            System.out.println("Inorder print");
            bst.printInorder();
            System.out.println("\n");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
