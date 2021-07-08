// Class SearchTree stores and prints a binary search tree of objects of type E. E must implement the Comparable<E> interface.

// SearchTree class uses Generics and implements Comparable
public class SearchTree<E extends Comparable<E>> {
    // root of overall tree
    private SearchTreeNode<E> overallRoot;

    // post: constructs an empty search tree
    public SearchTree() {
        overallRoot = null;
    }

    // post: value added to tree so as to preserve binary search tree
    public void add(E value) {
        overallRoot = add(overallRoot, value);
    }

    // post: value added to tree so as to preserve binary search tree
    private SearchTreeNode<E> add(SearchTreeNode<E> root, E value) {
        // if tree is empty
        if (root == null) {
            root = new SearchTreeNode<E>(value); // place the new value here
        }
        // check left subtree via recursive calls
        else if (root.data.compareTo(value) >= 0) {
            root.left = add(root.left, value);
        }
        // check right subtree via recursive calls
        else { // else if (root.data.compareTo(value) <= 0)
            root.right = add(root.right, value);
        }
        return root;
    }

    // post: returns true if tree contains value, returns false otherwise
    public boolean contains(E value) {
        return contains(overallRoot, value);
    }

    // post: returns true if given tree contains value, returns false otherwise
    private boolean contains(SearchTreeNode<E> root, E value) {
        // if tree empty the value doesn't exist
        if (root == null) {
            return false;
        }
        // if tree not empty
        else {
            // check for a match and store result
            int compare = value.compareTo(root.data);
            // if result is a match
            if (compare == 0) {
                return true; // value is found
            }
            // search the left
            else if (compare < 0) {
                return contains(root.left, value);
            }
            // search the right
            else { // compare > 0
                return contains(root.right, value);
            }
        }
    }

    // post: prints the data of the tree, one per line
    public void print() {
        printInorder(overallRoot);
    }

    // post: prints the data of the tree using an inorder traversal
    private void printInorder(SearchTreeNode<E> root) {
        // if tree not empty
        if (root != null) {
            printInorder(root.left); // print left node first
            System.out.println(root.data); // then print middle node
            printInorder(root.right); // print right last node
        }
    }

    // inner class
    private static class SearchTreeNode<E> {
        // fields
        public E data;                   // data stored in this node
        public SearchTreeNode<E> left;   // left subtree
        public SearchTreeNode<E> right;  // right subtree

        // post: constructs a leaf node with given data
        public SearchTreeNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with the given data and links
        public SearchTreeNode(E data, SearchTreeNode<E> left, SearchTreeNode<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

}
