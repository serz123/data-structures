package com.mycompany.binarysearchtree;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

public class BinarySearchTree {
    BinaryTreeNode root; 

    public BinarySearchTree() {
    this.root = null;
    }
    
    public void add (int key) {
        root = _add(root, key);
    }

    private BinaryTreeNode _add (BinaryTreeNode n, int key) {
        if (n == null) {
            return new BinaryTreeNode(key);
        }
        
        if (key < n.key) {
            n.left = _add(n.left, key);
        } else if (key > n.key) {
            n.right = _add(n.right, key);
        }

        return n;
    }

    public void delete(int key) {
        root = _delete(root, key);
    }

    private BinaryTreeNode _delete(BinaryTreeNode n, int key) {
        if (n == null) {
            return null;
        }
        if (n.key > key) {
            n.left = _delete(n.left, key);
        } else if (n.key < key) {
            n.right = _delete(n.right, key);
        } else {
            if (n.right == null) {
                return n.left;
            }
            if (n.left == null) {
                return n.right;
            }
            n.key = min(n.right);
            n.right = _delete(n.right, n.key);
        }
        return n;
    }

    private int min (BinaryTreeNode n) {
        if (n.left == null) {
            return n.key;
        } else {
            return min(n.left);
        }
    }

    public boolean contains (int key) {
        return _contains(root, key);
    }

    private boolean _contains (BinaryTreeNode n, int key) {
        if (n == null) {
            return false;
        }
        if (n.key > key) {
            return _contains(n.left, key);
        } else if (n.key < key) {
            return _contains(n.right, key);
        } else {
        return true;
        }
    }

    public int size(BinaryTreeNode node) {
        if (node == null) return 0;
        return 1 + size(node.left) + size(node.right);
    }

    public int height() {
        return _height(root);
    }

    private int _height (BinaryTreeNode n) {
        if (n == null) {
            return -1;
        } else {
            return 1 + Math.max(_height(n.left), _height(n.right));
        }
    }
    
    public void deleteKthLargest(int k) throws Exception {
        int[] count = {0};
        root = deleteKthLargest(root, k, count);
        if (count[0] < k) {
            throw new Exception("There is no " + k + " largest value in the tree!");
        }
    }

    private BinaryTreeNode deleteKthLargest(BinaryTreeNode n, int k, int[] count) {
        if (n == null) {
            return null;
        }

        n.right = deleteKthLargest(n.right, k, count);

        count[0]++;

        if (count[0] == k) {
            return _delete(n, n.key);
        }

        n.left = deleteKthLargest(n.left, k, count);
        return n;
    }
    
    
    // Print the tree using GraphStream
    public void printGraph() {
        String styleSheet =
            "node {" +
            "   text-alignment: right;" +
            "   text-offset: 10px, 0px;" +
            "   size: 5px, 5px;" +
            "}" +
            "node.marked {" +
            "   fill-color: red;" +
            "}";

        // Set up GraphStream
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("Binary Search Tree");
        graph.setAttribute("ui.stylesheet", styleSheet);

        // Print the nodes and edges
        BinarySearchTree.this._printGraph(root, graph, null);

        // Display the graph
        Viewer viewer = graph.display();
        viewer.disableAutoLayout();
    }

    private void _printGraph(BinaryTreeNode x, Graph graph, String parentKey) {
        if (x == null) return;

        String keyStr = Integer.toString(x.key);
        org.graphstream.graph.Node n = graph.addNode(keyStr);

        // Set label for smaller graphs
        if (size(x) <= 50) {
            n.setAttribute("ui.label", keyStr);
        }

        // Position node
        n.setAttribute("x", rank(x.key) / 2);
        n.setAttribute("y", depth(x.key) * -20);

        // Add edge to the parent node
        if (parentKey != null) {
            graph.addEdge(parentKey + "-" + keyStr, parentKey, keyStr);
        }

        // Visit left and right subtrees
        BinarySearchTree.this._printGraph(x.left, graph, keyStr);
        BinarySearchTree.this._printGraph(x.right, graph, keyStr);
    }

    private int rank(int key) {
        // Example: calculate rank of the node (or x-axis position)
        return key; // Modify according to how you want to position the node horizontally
    }

    private int depth(int key) {
        // Example: calculate depth of the node (or y-axis position)
        return this._depth(root, key, 0);
    }

    private int _depth(BinaryTreeNode node, int key, int depth) {
        if (node == null) {
            return -1;
        }
        if (node.key == key) {
            return depth;
        }
        if (key < node.key) {
            return _depth(node.left, key, depth + 1);
        } else { 
            return _depth(node.right, key, depth + 1);
        }
    }

    public void printInorder() {
        inorder(root);
    }

    private void inorder (BinaryTreeNode n) {
        if (n != null) {
            inorder(n.left);
            System.out.print(n.key + " ");
            inorder(n.right);
        }
    }

    public void printPreorder() {
        preorder(root);
    }

    private void preorder (BinaryTreeNode n) {
        if (n != null) {
            System.out.print(n.key + " ");
            preorder(n.left);
            preorder(n.right);
        }
    }

    public void printPostorder() {
        postorder(root);
    }

    private void postorder (BinaryTreeNode n) {
        if (n != null) {
            postorder(n.left);
            postorder(n.right);
            System.out.print(n.key + " ");
        }
    }
}
