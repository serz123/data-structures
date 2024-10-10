package com.mycompany.avltree;

import java.util.Random;

public class AVLTreeDemonstration {
    AVLTree avl = new AVLTree();

    public void run() {
        System.out.println("AVL tree");
        System.out.println();

        System.out.println("Populating the tree with 25 random values between 0 and 100...");
        Random generator = new Random();
        for (int i = 0; i < 25; i++) {
            int random = generator.nextInt(100);
            avl.add(random);
        }

        // avl.printGraph();

        System.out.println("\nInorder print");
        avl.printInorder();

        System.out.println("\nPreorder print");
        avl.printPreorder();

        System.out.println("\nPostorder print");
        avl.printPostorder();
        System.out.println();

        System.out.println();
        System.out.println("Height of the tree is " + avl.height() + "!");

        System.out.println();
        System.out.println("The tree contains value 3?  " + avl.contains(3));
        System.out.println("The tree contains value 66?  " + avl.contains(66));
        System.out.println("The tree contains value 74?  " + avl.contains(74));
        System.out.println("The tree contains value 33?  " + avl.contains(33));
        System.out.println("The tree contains value 24?  " + avl.contains(24));
        System.out.println("The tree contains value 11?  " + avl.contains(11));
        System.out.println("The tree contains value 98?  " + avl.contains(98));

        System.out.println();
        System.out.println("Adding value 185 to the tree.");
        avl.add(185);
        System.out.println("Inorder print");
        avl.printInorder();
        System.out.println("\n");

        System.out.println("Adding value 1000 to the tree.");
        avl.add(1000);
        System.out.println("Inorder print");
        avl.printInorder();
        System.out.println("\n");

        System.out.println("Deleting value 1000 from the tree.");
        avl.delete(1000);
        System.out.println("Inorder print");
        avl.printInorder();
        System.out.println("\n");

        avl.printGraph();
    }
}
