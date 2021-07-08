

// a class for the tree
public class Tree {

    // can access the entire tree from the root node by traversing it's left child and right child
    private TreeNode root;

    // insert nodes to build a tree (duplicate values not allowed)
    public void insert(int value) { // this is the method a caller would call to insert a value into the tree, which then calls the insert method with that value in the TreeNode class
        // if the root (tree) is empty
        if (root == null) {
            // the node becomes the root (you always insert into the very first empty spot you find)
            root = new TreeNode(value); // done building the tree
        }
        // otherwise, if the root (tree) is not empty
        else {
            // compare the value that's being inserted against the root node
            root.insert(value); // call the insert method on root (recursive call)
        }
    }

    // get method
    public TreeNode get(int value) {
        // if root (tree) is not empty
        if (root != null) {
            // call the get method on root
            return root.get(value);
        }
        // if tree is empty it means the value the caller is looking for is not in the tree
        return null;
    }

    // delete method with one parameter (calls the delete method with two params)
    public void delete(int value) {
        // if the root is the value that we want to delete, the root will change
        root = delete(root, value);
    }

    // delete method with two parameters (recursive method)
    private TreeNode delete(TreeNode subtreeRoot, int value) { // this method returns the replacement node
        // if tree is empty (breaking point for recursion)
        if (subtreeRoot == null) {
            return null; // return subTreeRoot
        }
        // if the value is less than the root of the subtree searched, move to the subtree's left child
        if (value < subtreeRoot.getData()) { // search left subtree
            // replace the subtree's left child with whatever the result of the delete is
            // (if there is no change we get the same node back that's already the left child)
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
        }
        // check if the value is greater than the root of the subtree searched, move to the subtree's right child
        else if (value > subtreeRoot.getData()) { // search right subtree
            // replace the subtree's right child with whatever the result of the delete is
            // (if there is no change we get the same node back that's already the right child)
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
        }
        // if value is equal to the root, we have found the node that we want to delete (which is the subtreeRoot)
        else { // handle two possible cases: node to delete (subtreeRoot) has 0 children, or has 1 child only
            //////////////////////////////////////////////////////////////////
            ///// cases 1 and 2: node to delete has 0 or 1 child(ren)  //////
            ////////////////////////////////////////////////////////////////
            // either the node is a leaf (right child also null), or it has a right child
            if (subtreeRoot.getLeftChild() == null) {
                // if the node has a right child then the replacement node is it's right child
                // (otherwise in the case of a leaf node, the replacement node is just null)
                return subtreeRoot.getRightChild(); // get the right child to replace the node that's being deleted
            }
            // either the node is a leaf (left child also null), or it has a left child
            else if (subtreeRoot.getRightChild() == null) {
                // if the node has a left child then the replacement node is it's left child
                // (otherwise in the case of a leaf node, the replacement node is just null)
                return subtreeRoot.getLeftChild(); // get the left child to replace the node that's being deleted
            }
            ///////////////////////////////////////////////////////////////
            ////// case 3: node to delete has 2 children             /////
            /////////////////////////////////////////////////////////////
            // replace the value in the subtreeRoot node with the smallest value from the right subtree (in order to preserve the characteristics of a binary search tree)
            subtreeRoot.setData(subtreeRoot.getRightChild().min()); // set the data of the existing node to the value of the replacement node (which is the min value from the min method)
            // delete the node that has the smallest value in the right subtree (delete the replacement node)
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData())); // use delete method to delete the node that contains the minimum value
        }
        // if it turns out the subtree root isn't the node we want to delete, we just return it
        return subtreeRoot; // the node is a replacement node for itself if it's not the node we wish to delete
    }

    // min method
    public int min() {
        // if tree is empty
        if (root == null) {
            // notify caller by returning the absolute smallest value
            return Integer.MIN_VALUE; // assumes tree does not or cannot hold this value
        }
        else { // if root (tree) is not empty
            return root.min(); // call min on root
        }
    }

    // max method
    public int max() {
        // if tree is empty
        if (root == null) {
            // notify caller by returning the absolute largest value
            return Integer.MAX_VALUE; // assumes tree does not or cannot hold this value
        }
        else { // if root (tree) is not empty
            return root.max(); // call max on root
        }
    }

    // in-order traversal
    public void traverseInOrder() {
        // if root (tree) is not empty
        if (root != null) {
            // traverse the tree
            root.traverseInOrder();
        }
    }

    // Challenge 1: add preorder traversal to Tree implementation
    public void traversePreOrder() {
        // if root (tree) is not empty
        if (root != null) {
            // traverse the tree
            root.traversePreOrder();
        }
    }

}