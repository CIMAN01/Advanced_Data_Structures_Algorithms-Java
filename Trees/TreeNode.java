
// a class for the nodes that will go into the tree
public class TreeNode {
    // create 3 fields
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    // constructor: will be a leaf node at first
    public TreeNode(int data) {
        this.data = data;
    }

    // insert method
    public void insert(int value) {
        // check for duplicate values
        if (value == data) {
            return; // duplicates value not allowed -> do nothing
        }
        // if the value is less than the data in this node, explore the left subtree
        if (value < data) {
            // check if there is a left child
            if (leftChild == null) { // if it doesn't have left subtree
                leftChild = new TreeNode(value); // we have found the insertion point
            }
            // if this node does have a left child
            else {
                // compare the left child value against the data
                leftChild.insert(value); // process all nodes in left subtree (recursive call)
            }
        }
        // if the value is greater than the data in this node, explore the right subtree
        else { // else if (value > data)
            // check if there is a right child
            if (rightChild == null) {  // if it doesn't have a right child/subtree
                rightChild = new TreeNode(value); // we have found the insertion point
            }
            // if this node does have a right child
            else {
                // compare the right child value against the data
                rightChild.insert(value); // process all nodes in right subtree (recursive call)
            }
        }
    }

    // get method
    public TreeNode get(int value) {
        // if value is equal to the data
        if (value == data) {
            return this; // return this TreeNode
        }
        // if value is less than the data
        if (value < data) {
            // search the left subtree as long as the node has a left subtree
            if (leftChild != null) {
                // look for the value in the left subtree
                return leftChild.get(value); // recursive call
            }
        }
        else { // else if (value > data)
            // search the right subtree as long as the node has a right subtree
            if (rightChild != null) {
                // look for the value in the right subtree
                return rightChild.get(value); // recursive call
            }
        }
        // if the value never equals any of the data it means we couldn't find the value we were looking for in the tree
        return null; // return a null TreeNode
    }

    // min method
    public int min() {
        // start from root and travel all the way down the left edges
        if (leftChild == null) { // if node doesn't have a left child
            return data; // we have found the min value (int)
        }
        else { // otherwise, continue travelling down the left edges
            return leftChild.min(); // recursive call
        }
    }

    // max method
    public int max() {
        // start from root and travel all the way down the right edges
        if (rightChild == null) { // if node doesn't have a right child
            return data; // we have found the max value (int)
        }
        else { // otherwise, continue travelling down the right edges
            return rightChild.max(); // recursive call
        }
    }

    // in-order traversal (left child -> root of subtree -> right child)
    public void traverseInOrder() {
        // check if the node has a left child
        if (leftChild != null) {
            // if it does, visit the left subtree (recursive call)
            leftChild.traverseInOrder();
        }
        // visit the node itself
        System.out.print(data + ", "); // print the data
        // check if the node has a right child
        if (rightChild != null) {
            // if it does, visit the right subtree (recursive call)
            rightChild.traverseInOrder();
        }
    }

    // Challenge 1: add preorder traversal to Tree implementation
    public void traversePreOrder() {
        // visit the node (the root of the subtree) first
        System.out.print(data + ", ");
        // check if the node has a left child
        if (leftChild != null) {
            // if it does, visit the left subtree (recursive call)
            leftChild.traversePreOrder();
        }
        // check if the node has a right child
        if (rightChild != null) {
            // if it does, visit the right subtree (recursive call)
            rightChild.traversePreOrder();
        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

}