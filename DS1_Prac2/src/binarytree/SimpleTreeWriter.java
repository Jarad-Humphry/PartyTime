package binarytree;
import java.io.PrintStream;
/**
 * An implementation of BinaryTreeWriter. </br>
 * To illustrate the intended output format, assume we have a BinarySearchTree 
 * containing the values 14, 10, 12, 6, 22, 16:</br>
 * <pre>
 * |  
 * |__14
 *    |  
 *    |__22
 *    |  |__
 *    |  |  
 *    |  |__16
 *    |     |__
 *    |     |__
 *    |  
 *    |__10
 *       |  
 *       |__12
 *       |  |__
 *       |  |__
 *       |  
 *       |__6
 *          |__
 *          |__
 * </pre>
 * This tree has a root value of 14, root's right hand child has the value 22, it's left hand child has the
 * value 10...</br>
 * Children are printed below the parent.</br>
 * The right child is printed before the left.</br>
 *
 * @author Stephan Jamieson 
 * @version 2/3/2016
 */
public class SimpleTreeWriter<E> implements BinaryTreeWriter<E> {
	PrintStream destination;
    /**
     * Create a SimpleTreeWriter that outputs to the given PrintStream.
     */
    public SimpleTreeWriter(PrintStream p) { this.setDestination(p); }
    	
    /**
     * Set the destination PrintStream.
     */
    public void setDestination(PrintStream p) { 
	destination = p;
		// Your code here
	}
    
    /**
     * Print the given tree.
     */


	public E smallestNode(BinaryTree<E> tr, Position<E> p)
		{
		if (tr.isLeaf(p))
			{
			return tr.getContent(p);
			}
		else if (tr.hasLeft(p))
			{
			return smallestNode(tr, tr.getLeft(p));
			}

		else
			{
			return tr.getContent(p);
			}
		}
		

	public void prefixPrinter(BinaryTree<E> tr,String prefix, Position<E> p, E smallest)
		{

		destination.println(prefix + "|");
		destination.println(prefix + "|__" + tr.getContent(p));

		
		
				

			if (tr.isRoot(p) || (tr.getLeft(tr.getParent(p))) == p)
				{
				prefix = prefix + "   ";
				}
			else 	
				{
				prefix = prefix + "|  ";
				}

			if (tr.hasRight(p))
				{
				prefixPrinter(tr, prefix, tr.getRight(p), smallest);
				}
			else 
				{
				destination.println(prefix + "|__");
				}

			if (tr.hasLeft(p))
				{
				prefixPrinter(tr, prefix, tr.getLeft(p), smallest);
				}
			else 
				{
				destination.println(prefix + "|__");
				}
			

		
		}
	
    public void print(BinaryTree<E> t) {
		String prefix = "";
		Position <E> current = t.root();
		if (t.isEmpty() == true)
			{
			destination.println("|");
			destination.println("|__");
			}
		
		

		else
			{
			E smallest = smallestNode(t, current);
                	prefixPrinter(t,prefix,current, smallest);
			}

    }
}
