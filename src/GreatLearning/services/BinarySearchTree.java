package GreatLearning.services;

/**
 * Implemented Binary Sreach tree to improve Tree learning and understanding a BST.
 */
public class BinarySearchTree {

    protected Node root;
    protected void Insert(double value){
        root = InsertRecursive( root, value );
    }

    private Node InsertRecursive(Node current, double value){
        if(current == null) {return new Node( value );}
        if(value < current.value) {current.left = InsertRecursive( current.left, value );}
        else if(value > current.value) { current.right = InsertRecursive( current.right, value ); }
        else { return current; }
        return current;
    }

    protected boolean Search(double value){
        return SearchRecursive(root, value);
    }

    private boolean SearchRecursive(Node current, double value){
        if(current == null) { return false; }
        if(value == current.value) { return true; }
        if(value > current.value) { return SearchRecursive( current.right, value ); }
        else { return SearchRecursive( current.left, value ); }
    }
}
