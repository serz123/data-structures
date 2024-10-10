package com.mycompany.avltree;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

public class AVLTree {

    AVLNode root;

    public AVLTree() {
        this.root = null;
    }

    public void add(int key) {
        root = _add(root, key);
    }

    private AVLNode _add(AVLNode n, int key) {
        if (n == null) {
            return new AVLNode(key);
        }

        if (key < n.key) {
            n.left = _add(n.left, key);
        } else if (key > n.key) {
            n.right = _add(n.right, key);
        }

        return balance(n);
    }

    private AVLNode balance(AVLNode n) {
        if (n == null) {
            return n;
        }

        if (_height(n.left) - _height(n.right) > 1) {
            if (_height(n.left.left) >= _height(n.left.right)) {
                n = rotateLeft(n);
            } else {
                n = doubleLeft(n);
            }
        } else if (_height(n.right) - _height(n.left) > 1) {
            if (_height(n.right.right) >= _height(n.right.left)) {
                n = rotateRight(n);
            } else {
                n = doubleRight(n);
            }
        }

        n.height = Math.max(_height(n.left), _height(n.right)) + 1;

        return n;
    }

    private AVLNode rotateLeft(AVLNode r2) {
        /*if (r2 == null || r2.left == null) {
            return r2;
        }*/

        AVLNode r1 = r2.left;
        r2.left = r1.right;
        r1.right = r2;

        r2.height = Math.max(_height(r2.left), _height(r2.right)) + 1;
        r1.height = Math.max(_height(r1.left), r2.height) + 1;

        return r1;
    }

    private AVLNode rotateRight(AVLNode r2) {
        /*if (r2 == null || r2.right == null) {
            return r2;
        }*/

        AVLNode r1 = r2.right;
        r2.right = r1.left;
        r1.left = r2;

        r2.height = Math.max(_height(r2.left), _height(r2.right)) + 1;
        r1.height = Math.max(_height(r1.left), r2.height) + 1;

        return r1;
    }

    private AVLNode doubleRight(AVLNode n) {
        n.right = rotateLeft(n.right);
        return rotateRight(n);
    }

    private AVLNode doubleLeft(AVLNode n) {
        n.left = rotateRight(n.left);
        return rotateLeft(n);
    }

    public void delete(int key) {
        root = _delete(root, key);
    }

    private AVLNode _delete(AVLNode n, int key) {
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
        return balance(n);
    }

    private int min(AVLNode n) {
        if (n.left == null) {
            return n.key;
        } else {
            return min(n.left);
        }
    }

    public boolean contains(int key) {
        return _contains(root, key);
    }

    private boolean _contains(AVLNode n, int key) {
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

    public int size(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }

    public int height() {
        return _height(root);
    }

    private int _height(AVLNode n) {
        if (n == null) {
            return -1;
        } else {
            return n.height;
        }
    }

    // Print the tree using GraphStream
    public void printGraph() {
        String styleSheet
                = "node {"
                + "   text-alignment: right;"
                + "   text-offset: 10px, 0px;"
                + "   size: 5px, 5px;"
                + "}"
                + "node.marked {"
                + "   fill-color: red;"
                + "}";

        // Set up GraphStream
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("AVL Tree");
        graph.setAttribute("ui.stylesheet", styleSheet);

        // Print the nodes and edges
        AVLTree.this._printGraph(root, graph, null);

        // Display the graph
        Viewer viewer = graph.display();
        viewer.disableAutoLayout();
    }

    private void _printGraph(AVLNode x, Graph graph, String parentKey) {
        if (x == null) {
            return;
        }

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
        AVLTree.this._printGraph(x.left, graph, keyStr);
        AVLTree.this._printGraph(x.right, graph, keyStr);
    }

    private int rank(int key) {
        // Example: calculate rank of the node (or x-axis position)
        return key; // Modify according to how you want to position the node horizontally
    }

    private int depth(int key) {
        // Example: calculate depth of the node (or y-axis position)
        return _depth(root, key, 0);
    }

    private int _depth(AVLNode node, int key, int depth) {
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

    private void inorder(AVLNode n) {
        if (n != null) {
            inorder(n.left);
            System.out.print(n.key + " ");
            inorder(n.right);
        }
    }

    public void printPreorder() {
        preorder(root);
    }

    private void preorder(AVLNode n) {
        if (n != null) {
            System.out.print(n.key + " ");
            preorder(n.left);
            preorder(n.right);
        }
    }

    public void printPostorder() {
        postorder(root);
    }

    private void postorder(AVLNode n) {
        if (n != null) {
            postorder(n.left);
            postorder(n.right);
            System.out.print(n.key + " ");
        }
    }

}
