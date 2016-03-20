package binarysearchtree;
import binarytree.LinkedBinaryTree;
import binarytree.Node;
import binarytree.Position;
//
import java.util.Comparator;

/**
 * A linked implementation of  BinarySearchTree.
 * 
 * @author Stephan Jamieson
 * @version 2/3/2016
 */
public class LinkedBST<E> extends LinkedBinaryTree<E> implements BinarySearchTree<E> {

    /**
     * Create a new BSTNode containing the given element.</br>
     * Methods that create nodes MUST use this.</br> 
     * This method overrides that in LinkedBinaryTree.</br>
     * Subclasses of this class must override it.
     */
    @Override
    protected BSTNode<E> makeNode(E element) {
        return new BSTNode<E>(this, element);
    }
    
    @SuppressWarnings("unchecked")
    /**
     * Convenience method for obtaining the BSTNode associated with a given position.
     */
    protected BSTNode<E> getNode(Position<E> p) { 
        assert(p.getOwner()==this);
        return (BSTNode<E>)p; 
    }
  
    // Comparator used to order nodes.
    private Comparator<E> comparator;

    /**
     * Create a new LinkedBST that orders its elements using the given Comparator.
     */
    public LinkedBST(Comparator<E> comparator) { 
        super();
        this.comparator=comparator; 
    }
    
    /**
     * Obtain the Comparator used by this LinkedTree to order its elements.
     */
    public Comparator<E> getComparator() { return comparator; }
        
    @Override
    /**
     * Obtain the position of the node containing the given element.</br>
     * If the element is not within the tree then the position of the leaf at which the search ended is returned.</br>
     * If the tree is empty then null is returned.
     */
    public Position<E> find(E element) {
        if (this.isEmpty()) {
            return null;
        }
        else {
            BSTNode<E> node = getNode(root());
            while (true) {
                final int test = comparator.compare(element, node.getContent());
                if (test==0||test<0&&!node.hasLeft()||test>0&&!node.hasRight()) {
                    return node;
                }
                else {
                    node = test<0&&node.hasLeft() ? node.getLeft() : node.getRight();
                }
            }        
        }    
    }
    
    /**
     * Inserts the given element in the tree and returns the position of the new node.</br>
     * If an instance of element is already in the tree then this method overwrites it with the given value. (Useful when implementing a map.)
     */
    public Position<E> insert(E element){
        if (this.isEmpty()) {
            this.setRoot(makeNode(element));
            return root();
        }
        else {
            final Position<E> position = find(element);        
            final BSTNode<E> node = getNode(position);
            final int compResult = comparator.compare(element, position.getContent());

            if (compResult==0) {
                node.setContent(element);
                return position;
            }
            else {
                final BSTNode<E> leaf = makeNode(element);
                leaf.setParent(node);
                
                if (compResult<0) {
                    node.setLeft(leaf);
                }
                else {
                    node.setRight(leaf);
                }
                return leaf;
            }
        }   
    }
    
    /**
     * Locate and remove the given element from the tree, returning the position of its parent or <code>null</code> if root.
     */



    public Position<E> delete(E element){
		// Your code here
	if (super.isEmpty())
		{
		return null;
		}
	if (super.contains(element) == false)
		{
		return null;
		}
	
	
      	Position<E> pos = find(element);
	BSTNode<E> node = getNode(pos);
	int x = 0;
	Position<E> pare = pos;
	if (super.isRoot(pos))
		{
		x = 1;	
		}
	else
		{
		pare = super.getParent(pos);
		}

	if (super.hasLeft(pos) && super.hasRight(pos))
		{
		Position <E> Successor = super.getRight(pos);
		while (super.hasLeft(Successor))
			{
			Successor = super.getLeft(Successor);
			}
		super.swap(Successor, pos);

		super.delete(Successor);

		if (x ==1)
			{
			return null;
			}
		return pare;
			
		}
	else
		{
		return super.delete(pos);
		}
    }

    
    /**
     * Perform a single rotation of the node at position p (i.e. rotate the node at position p above its parent.)and return the new position of the parent </br>
     * Requires that position p does not refer to the root.
     */
    public Position<E> rotate(Position<E> p)
	{
	

		
		Position<E> parent = super.getParent(p);
		Position<E> rightChild = super.getRight(p);
		Position<E> leftChild = super.getLeft(p);
		
		

	
		{
		if (super.hasLeft(parent) && super.getLeft(parent) == p)
			{
			if (super.hasRight(p))
				{
				if (super.isRoot(parent))
					{
					super.setRoot(p);
					}
				else
					{
				
					if (super.isLeft(parent)) // set Parent's parents child to p
						{
						getNode(super.getParent(parent)).setLeft(getNode(p));
						}
					else 
						{
						getNode(super.getParent(parent)).setRight(getNode(p));
						}
					}

					getNode(p).setParent(getNode(super.getParent(parent))); //set p's parent to Parent's parent
					getNode(parent).setParent(getNode(p)); //set Parent's parent to p
					getNode(p).setRight(getNode(parent)); //set p's right to Parent
					getNode(rightChild).setParent(getNode(parent)); //set p's right child's parent to Parent
					getNode(parent).setLeft(getNode(rightChild)); //set Parent's left child to p's right child
					
					
				}
			else
				{
				if (super.isRoot(parent))
					{
					super.setRoot(p);
					}
				else
					{
					if (super.isLeft(parent)) // set Parent's parents child to p
						{
						getNode(super.getParent(parent)).setLeft(getNode(p));
						}
					else 
						{
						getNode(super.getParent(parent)).setRight(getNode(p));
						}	
					}
				getNode(p).setParent(getNode(super.getParent(parent))); //set p's parent to Parent's parent
				getNode(parent).setParent(getNode(p)); //set Parent's parent to p
				getNode(p).setRight(getNode(parent)); //set p's right to Parent
				getNode(parent).setLeft(getNode(rightChild)); //set Parent's left child to p's right child
				}
			}

		else if (super.hasRight(parent) && super.getRight(parent) == p)
			{
			if (super.hasLeft(p))
				{
				if (super.isRoot(parent))
					{
					super.setRoot(p);
					}
				else
					{
					if (super.isLeft(parent)) // set Parent's parents child to p
						{
						getNode(super.getParent(parent)).setLeft(getNode(p));
						}
					else 
						{
						getNode(super.getParent(parent)).setRight(getNode(p));
						}
					}

					getNode(p).setParent(getNode(super.getParent(parent))); //set p's parent to Parent's parent
					getNode(parent).setParent(getNode(p)); //set Parent's parent to p
					getNode(p).setLeft(getNode(parent)); //set p's left to Parent
					getNode(leftChild).setParent(getNode(parent)); //set p's left child's parent to Parent
					getNode(parent).setRight(getNode(leftChild)); //set Parent's right child to p's right child
					
				}
			else
				{
				
				if (super.isRoot(parent))
					{
					super.setRoot(p);
					}
				else
					{
					if (super.isLeft(parent)) // set Parent's parents child to p
						{
						getNode(super.getParent(parent)).setLeft(getNode(p));
						}
					else 
						{
						getNode(super.getParent(parent)).setRight(getNode(p));
						}
					}
				getNode(p).setParent(getNode(super.getParent(parent))); //set p's parent to Parent's parent
				getNode(parent).setParent(getNode(p)); //set Parent's parent to p
				getNode(p).setLeft(getNode(parent)); //set p's left to Parent
				getNode(parent).setRight(getNode(leftChild)); //set Parent's right child to p's right chi
				}
			}
		}
	
	return null;
    }

    /**
     * Apply the tri-node restructuring algorithm at position p, returning the position of the new (sub) tree root.</br>
     * Requires that position p has a grandparent.
     */   
    public Position<E> restructure(Position<E> x){
		Position<E> par = super.getParent(x);
		
		if (super.isRoot(par))
			{
			rotate(x);
			return null;
			}
		Position<E> parpar = super.getParent(par);

		if (super.hasLeft(parpar) && super.getLeft(parpar) == par && super.hasRight(par) && super.getRight(par) == x || super.hasRight(parpar) && super.getRight(parpar) == par && super.hasLeft(par) && super.getLeft(par) == x)
			{
			rotate(x);
			rotate(x);
			return null;
			}

		else
			{
			rotate(par);
			return null;
			}
		
    }







}
