/* Nick and Kaitlyn   BST class */
import ch08.trees.*;
import support.*;
public class BST< T extends Comparable<T>> extends BinarySearchTree<T> {
    public BST() {
	super();
    }
    public int leafCount() {
	return recLeafCount(root);
    }
    private int recLeafCount(BSTNode<T> tree) {
	if (tree == null) {
	    return 0; }
	if ((tree.getRight() == null) && (tree.getLeft() == null)) 
	    return 1;
	else 
	    return recLeafCount(tree.getRight()) + recLeafCount(tree.getLeft());
    }
    public static void main(String[] args) {
	BST<Integer> test1 = new BST<Integer>();
	test1.add(4);
	test1.add(5);
	test1.add(7);
	test1.add(2);
	System.out.println(test1.leafCount());
    }
}
