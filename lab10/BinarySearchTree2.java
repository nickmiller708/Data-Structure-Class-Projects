/* Nick Miller and Levi Sledd
BinarySearchTree2 file
 */
import java.lang.Math;
import ch08.trees.*;
import support.*;
public class BinarySearchTree2<T extends Comparable<T>> extends BinarySearchTree<T> {
    public BinarySearchTree2() {
	super();
    }
    public int height() {
	return recHeight(root);
    }
    private int recHeight(BSTNode<T> tree) {
	/* Precondition: Tree is not empty */
	if ((tree.getLeft()) == null && (tree.getRight() == null)) {
	    return  0;
	}
	else {
	    if ((tree.getLeft() != null) && (tree.getRight() == null)) {
		return recHeight(tree.getLeft()) + 1;
	    }
	    else if ((tree.getLeft() == null) && (tree.getRight() != null)) {
		return recHeight(tree.getRight()) + 1;
	    }
	    else 
		return Math.max(recHeight(tree.getRight()),recHeight(tree.getLeft()))+1;
	}
    }

    public static void main(String[] args) {
	BinarySearchTree2<Integer> test1 = new BinarySearchTree2<Integer>(); 
	test1.add(5);
	test1.add(3);
	test1.add(2);
	test1.add(6);
	System.out.println(test1.height());
    }
}
