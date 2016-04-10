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
		int k = 1;
		
		if (table[index] == null)
			{
			return index;
			}
		
		if (table[index].getWord() == word)
			{
			return index;
			}

		i = index;
		i++;
		while (table[i]!=null)

			{
			if (table[i].getWord().equals(word))
				{
				return i;
				}
			if (i == table.length-1)
				{
				i = 0;
				}
			if (i==index)
				{
				return -1;
				}
			else
				{
				i ++;
				}
			}
		return i;
		
		
	}

	@Override
    public boolean containsWord(String word) {
	// Your code here.
        int value = hashFunction(word);
	
	if (table[value] == null)
		{
		return false;
		}
	if (table[value].getWord.equals(word))
		{
		return true;
		}

	if (table.length <= value)
		{
		return false;
		}

	else
		{
		int i = value;
		while (!table[i].getWord().equals(word))
			{
			if (i == table.length-1)
				{
				i = 0;
				}
			if (table[i] == null)
				{
				return false;
				}

			i++;
			}
		return true;

		/*if (table[value].getWord().equals(word))
			{
			return true;
			}
	
		else 
			{
			return false;
			}*/
		}
	
    }
    	@Override
    public List<Definition> getDefinitions(String word) {
	// Your code here.
	if (containsWord(word) == false)
		{
		return null;
		}
	else
		{
        	int index = findIndex(word);
		return table[index].getDefinitions();
		}
	
    }
    	@Override
    public void insert(String word, Definition definition) {        
        // Your code here.
	int index = findIndex(word);
	
	Entry e = new Entry(word);
	e.addDefinition(definition);


	if (containsWord(word) == false)
		{
		table[index] = e;
		entries ++;
		} 

	else if (table[index].getWord() != null)
		{
		table[index].addDefinition(definition);
		}
	
	else
		{
		rebuild();
		}

	
	
    }
}
