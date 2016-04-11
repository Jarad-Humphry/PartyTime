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
		
		if (table[index].getWord().equals(word))
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
			
			if (i==index)
				{
				return -1;
				}
			else
				{
				i ++;
				if (i >= table.length)
					{
					i = 0;
					}
				}
			}
		return i;
		
		
	}

	/*@Override
    public boolean containsWord(String word) {
	// Your code here.
        int value = hashFunction(word);
	
	if (table[value] == null)
		{
		return false;
		}
	if (table[value].getWord().equals(word))
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
		i ++;
		while (table[i] != null)
			{
			if (i==value)
				{
				return false;
				}

			if (i == table.length)
				{
				i = 0;
				}

			if (table[i].getWord().equals(word))
				{
				return true;
				}

			i++;
			}
		return false;

		
		}
	
    }
    	@Override
    public List<Definition> getDefinitions(String word) {
	// Your code here.
	int index = hashFunction(word); 
	for (int i = 0; i<=table.length; i ++)
		{
		index = index + i;
		if (index>=table.length)
			{
			index = index - table.length;
			}
		
		if (table[index] == null)
			{
			return null;
			}

		else if (table[index].getWord().equals(word))
			{
			return table[index].getDefinitions();
			}
		}
	return null;
	
	
	
    }
    	@Override
    public void insert(String word, Definition definition) {        
        // Your code here.
	
	
	Entry e = new Entry(word);
	e.addDefinition(definition);


	
		
		int value = hashFunction(word);
		
		
		if (table[value] == null)
			{
			table[value] = e;
			entries ++;
			}
		
		else if (table[value].getWord().equals(word))
			{
			table[value].addDefinition(definition);
			}
		else
			{

			int i = value;
				i ++;
				while (2 == 1+1)
					{
					if (i==value)
						{
						break;
						}

					if (i == table.length)
						{
						i = 0;
						}

					if (table[i] == null)
						{
						table[i] = e;
						entries ++;
						break;
						}

					if (table[i].getWord().equals(word))
						{
						table[i].addDefinition(definition);
						break;
						}

					

					

					i++;
					}
			}

	
	

	
	
    }*/
}
