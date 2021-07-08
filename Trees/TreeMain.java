
// a class for Main
public class TreeMain {

    // main method
    public static void main(String[] args) {
        // create a new tree
        Tree intTree = new Tree();
        // insert values
        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);
        intTree.insert(17);
        // perform an in-order traversal
        intTree.traverseInOrder();
        System.out.println();
        // perform a pre-order traversal
        intTree.traversePreOrder();
        System.out.println();

//
//        System.out.println(intTree.get(27));
//        System.out.println(intTree.get(17));
//        System.out.println(intTree.get(8888));

//        System.out.println(intTree.min());
//        System.out.println(intTree.max());
    }

}
