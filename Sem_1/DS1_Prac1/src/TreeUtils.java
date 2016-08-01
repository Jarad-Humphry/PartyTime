import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Utility procedures for binary tree structures.
 * 
 * @version 25/2/2015
 */
public class TreeUtils {
        
    /**
     * Determine whether one tree node structure is similar (has the same structure) as another.
     */
    public static boolean similar(BinaryTreeNode treeStructOne, BinaryTreeNode treeStructTwo) {
		if(treeStructOne.getHeight() != treeStructTwo.getHeight())
			{
			return false;
			}
		if(!treeStructOne.hasLeft() && !treeStructOne.hasRight() && !treeStructTwo.hasLeft() && !treeStructTwo.hasRight())
			{
			return true;
			}
		if (treeStructOne.hasLeft() && treeStructTwo.hasLeft() && treeStructOne.hasRight() && treeStructTwo.hasRight())
			{
			return similar(treeStructOne.getLeft(), treeStructTwo.getLeft()) && similar(treeStructOne.getRight(), treeStructTwo.getRight());
			}
		else if (!treeStructOne.hasLeft() && !treeStructTwo.hasLeft() && treeStructOne.hasRight() && treeStructTwo.hasRight())
			{
			return similar(treeStructOne.getRight(), treeStructTwo.getRight());
			}

		else if (treeStructOne.hasLeft() && treeStructTwo.hasLeft() && !treeStructOne.hasRight() && !treeStructTwo.hasRight())
			{
			return similar(treeStructOne.getLeft(), treeStructTwo.getLeft());
			}
		else
			{
			return false;
			}

			

    }
    
    /**
     * Obtain a list containing the root node of the given structure i.e. tNode itself.
     */
    public static List<BinaryTreeNode> levelZero(BinaryTreeNode tNode) {
		ArrayList<BinaryTreeNode> zeroList = new ArrayList<BinaryTreeNode>();
        	zeroList.add(tNode);
		return zeroList;
    }
    
    
    /**
     * Given a list of nodes, obtain the next level. 
     * 
     * <p>
     * If the tree structure is incomplete, <code>BinaryTreeNode.EMPTY_NODE</code> is inserted as a place holder for each
     * missing node.
     * </p>
     */
    public static List<BinaryTreeNode> nextLevel(List<BinaryTreeNode> level) {
		ArrayList<BinaryTreeNode> newList = new ArrayList<BinaryTreeNode>();
		for (BinaryTreeNode item : level)
			{
			if (isPlaceHolder(item) == false)
				{
				newList.add(BinaryTreeNode.EMPTY_NODE);
				newList.add(BinaryTreeNode.EMPTY_NODE);
				}
			else
				{	
			
				if (item.hasLeft() == true)
					{
					newList.add(item.getLeft());
					}
				else 
					{
					newList.add(BinaryTreeNode.EMPTY_NODE);
					}

				if (item.hasRight() == true)
					{
					newList.add(item.getRight());
					}
				else 
					{
					newList.add(BinaryTreeNode.EMPTY_NODE);
					}
				}
			}
		return newList;
    }
    
    /**
     * Determine whether node is a place holder i.e. <code>node==BinaryTreeNode.EMPTY_NODE</code>
     */
    public static boolean isPlaceHolder(BinaryTreeNode node) {
		if (node == BinaryTreeNode.EMPTY_NODE)
			{
			return false;
			}
		else {return true;}
    }
    
}
