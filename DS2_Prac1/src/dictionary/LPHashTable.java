package dictionary;
import java.util.List;
/**
 * Simple hash table implementation of Dictionary using linear probing.
 * 
 * @author Stephan Jamieson 
 * @version 24/4/2015
 */
public class LPHashTable extends AbstractHashTable {

    /**
     * Create an LPHashTable with DEFAULT_SIZE table.
     */ 
    public LPHashTable() { super(); }
    
    /**
     * Create an LPHashTable with the given default size table.
     */
    public LPHashTable(int size) { super(size); }    
    
	protected int findIndex(String word) {
		int i;
		int index = hashFunction(word);
		if (table[index].getWord().equals(word))
			{
			return index;
			}
		else 
			{
			i = index;
			i ++;

			while (!table[i].getWord().equals(word))
				{
				if (i == index)
					{
					return -1;
					}
				if (i == table.length)
					{
					i = 0;
					}
				else
					{
					i ++;
					}
				}
			return i;
			}
		
	}
}