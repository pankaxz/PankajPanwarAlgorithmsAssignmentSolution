package GreatLearning.services;

/**
 * Implemented Binary Search tree to improve my non-linear Data structure concepts.
 */
public class BinarySearchTree {
    protected Node root;

    /**
     * Abstracted method to insert values in the BST.
     * @param value : Share price values to be inserted
     */
    protected void Insert(double value){
        root = InsertRecursive( root, value );
    }

    /**
     * Helper function to insert values in the tree based on BST rules.
     * @param current : current active node
     * @param value : Share price values to be inserted
     **/
    private Node InsertRecursive(Node current, double value){
        if(current == null) {return new Node( value );}
        if(value < current.value) {current.left = InsertRecursive( current.left, value );}
        else if(value > current.value) { current.right = InsertRecursive( current.right, value ); }
        else { return current; }
        return current;
    }

    /**
     * Abstracted method to search values in the BST.
     * @param value : Share price values to be searched
     * @return : Boolean on if the value is available or not.
     */
    protected boolean Search(double value){
        return SearchRecursive(root, value);
    }

    /***
     * Searching in the BST.
     * If the value is greater than the value of the current node, we search in the right subtree, else we search in the left subtree
     * @param current : current active node
     * @param value : Share price values to be searched
     * @return : Boolean on if the value is available or not.
     */
    private boolean SearchRecursive(Node current, double value){
        if(current == null) { return false; }
        if(value == current.value) { return true; }
        if(value > current.value) { return SearchRecursive( current.right, value ); }
        else { return SearchRecursive( current.left, value ); }
    }
}
