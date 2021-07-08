
// SearchTreeNode class created for SearchTree and SearchTreeClient classes
public class SearchTreeNode<E> {
    // fields
    public E data;                   // data stored in this node
    public SearchTreeNode<E> left;   // left subtree
    public SearchTreeNode<E> right;  // right subtree

    // post: constructs a leaf node with given data
    public SearchTreeNode(E data) {
        this(data, null, null); // this(data);
    }

    // post: constructs a node with the given data and links
    public SearchTreeNode(E data, SearchTreeNode<E> left, SearchTreeNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

}
