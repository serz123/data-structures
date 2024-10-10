package com.mycompany.app;

import com.mycompany.avltree.AVLTreeDemonstration;
import com.mycompany.timer.Timer;
import com.mycompany.treecomparation.BstVsAvl;
import com.mycompany.treecomparation.TimeComparationBstVsAvl;

public class Uppgift4 {
    static Timer timer = new Timer();
    public static void main(String[] args) {

        // ---------->  AVL TREE DEMONSTRATION (UNCOMMENT THE LINE THAT YOU WANT TO SEE RESULTS) <----------
        
        AVLTreeDemonstration avlDemonstration = new AVLTreeDemonstration();
       // avlDemonstration.run();


        // ----------> BST AND AVL TREE COMPARATION (UNCOMMENT THE LINE THAT YOU WANT TO SEE RESULTS) <----------
        BstVsAvl bstVsAvl = new BstVsAvl();
        // bstVsAvl.runBst();
        //bstVsAvl.runAvl();

        //bstVsAvl.runRandomBst();
        //bstVsAvl.runAvl();

        /*  long time = timer.timeit(() -> bstVsAvl.runBst());
        System.out.println("Time for all operations for bst is " + time );

        long timeAvl = timer.timeit(() -> bstVsAvl.runAvl());
        System.out.println("Time for all operations for avl is " + timeAvl );*/

        TimeComparationBstVsAvl timeComparationBstVsAvl = new TimeComparationBstVsAvl();
        timeComparationBstVsAvl.run();
    }
}
