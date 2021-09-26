package GreatLearning.services;

/**
 * Node class to create nodes for the binary search tree.
 */
public class Node {
    double value;
    Node left, right;

    protected Node(double val){
        this.value = val;
        this.left = this.right = null;
    }
}
