package com.mycompany.treecomparation;

import java.util.Random;

import com.mycompany.avltree.AVLTree;
import com.mycompany.binarysearchtree.BinarySearchTree;

public class BstVsAvl {

        public void runBst() {

        BinarySearchTree bst = new BinarySearchTree();

        System.out.println("Populating the tree with 50 values");
        for (int i = 0; i < 50; i++) {
            bst.add(i);
        }
  
        System.out.println("Deleting 25 values ");
        for (int i = 0; i < 25; i++) {
            bst.delete(i);
        }
  
        System.out.println("Populating the tree with 25 values");
        for (int i = 50; i < 75; i++) {
            bst.add(i);
        }
  
        System.out.println("Deleting 25 values");
        for (int i = 40; i < 65; i++) {
            bst.delete(i);
        }

        bst.printGraph();
    }

    public void runAvl() {
      AVLTree avl = new AVLTree();

      System.out.println("Populating the tree with 50 values");
      for (int i = 0; i < 50; i++) {
          avl.add(i);
      }

      System.out.println("Deleting 25 values ");
      for (int i = 0; i < 25; i++) {
          avl.delete(i);
      }

      System.out.println("Populating the tree with 25 values");
      for (int i = 50; i < 75; i++) {
          avl.add(i);
      }

      System.out.println("Deleting 25 values");
      for (int i = 40; i < 65; i++) {
          avl.delete(i);
      }
      avl.printGraph();
  }

    public void runRandomBst() {

        BinarySearchTree bst = new BinarySearchTree();

        Random generator = new Random();
        System.out.println("Populating the tree with 50 random values between 0 and 100...");
        for (int i = 0; i < 50; i++) {
            int random = generator.nextInt(100);
            bst.add(random);
        }

        System.out.println("Deleting 25 random values between 0 and 100...");
        for (int i = 0; i < 25; i++) {
            int random = generator.nextInt(100);
            bst.delete(random);
        }

        System.out.println("Populating the tree with 25 random values between 0 and 100...");
        for (int i = 0; i < 25; i++) {
            int random = generator.nextInt(100);
            bst.add(random);
        }

        System.out.println("Deleting 25 random values between 0 and 100...");
        for (int i = 0; i < 25; i++) {
            int random = generator.nextInt(100);
            bst.delete(random);
        }
        bst.printGraph();
    }

    public void runRandomAvl() {
      AVLTree avl = new AVLTree();

      Random generator = new Random();
      System.out.println("Populating the tree with 50 random values between 0 and 100...");
      for (int i = 0; i < 50; i++) {
          int random = generator.nextInt(100);
          avl.add(random);
      }

      System.out.println("Deleting 25 random values between 0 and 100...");
      for (int i = 0; i < 25; i++) {
          int random = generator.nextInt(100);
          avl.delete(random);
      }

      System.out.println("Populating the tree with 25 random values between 0 and 100...");
      for (int i = 0; i < 25; i++) {
          int random = generator.nextInt(100);
          avl.add(random);
      }

      System.out.println("Deleting 25 random values between 0 and 100...");
      for (int i = 0; i < 25; i++) {
          int random = generator.nextInt(100);
          avl.delete(random);
      }
      avl.printGraph();
  }
}
