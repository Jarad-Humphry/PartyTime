package dictionary;
import java.util.List;
/**
 * Simple hash table implementation of Dictionary using linear probing.
 * 
 * @author Stephan Jamieson 
 * @version 24/4/2015
 */
public class SCHashTable extends AbstractHashTable {

	public final static int DEFAULT_SIZE = 50;
      protected ChainedEntry[] table;
    /**
     * Create an LPHashTable with DEFAULT_SIZE table.
     */ 
    protected SCHashTable() { this(DEFAULT_SIZE); }
    
    /**
     * Create a table with the given default size. (For use by sub classes.) 
     */
    protected SCHashTable(final int size) {
	super(size); 
        this.table = new ChainedEntry[size];
        this.entries = 0;
    }
  
    
    protected int findIndex(String word) 
		{
		return hashFunction(word);
		}

    /**
     * Create an LPHashTable with the given default size table.
     */
    
	
	@Override
    public boolean containsWord(String word) {
	// Your code here.
   int value = findIndex(word);
	
	if (table[value]  == null)
		{
		return false;
		}

	ChainedEntry CH = table[value];

	if (table[value].getWord().equals(word))
		{
		return true;
		}

	else while (CH.getNext() != null)
		{
		if (CH.getWord().equals(word))
			{
			return true;
			}
		}
	return false;	
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
		ChainedEntry CH = table[index];
		
		if (CH.getWord().equals(word))
			{
			return CH.getDefinitions();
			}
		else 
			{
			while (CH.getNext() != null)
				{
				if (CH.getWord().equals(word))
					{
					return CH.getDefinitions();
					}
				}
			return null;
			}
		}
	
    }
    
    	@Override
    public void insert(String word, Definition definition) {        
        // Your code here.
	Entry e = new Entry(word);
	e.addDefinition(definition);
	int index = findIndex(word);
	if (index == -1)
		{
		//return;
		}

	else if (table[index]==null)
		{
		ChainedEntry newCH = new ChainedEntry(word, table[index]);
		table[index] = newCH;
		newCH.addDefinition(definition);
		entries ++;
		}
	
	
	else 
		{
		ChainedEntry CH = table[index];
		if (table[index].getWord().equals(word))
			{
			CH.addDefinition(definition);
			}

		else 
			{
			while (CH.getNext()!=null)
				{
				if (CH.getWord().equals(word))
					{
					CH.addDefinition(definition);
					break;
					}
				CH = CH.getNext();
				}
			ChainedEntry newCH = new ChainedEntry(word, table[index]);
			table[index] = newCH;
			newCH.addDefinition(definition);
			entries ++;
			}
		}
	
	
	/*else
		{
		rebuild();
		}*/

	
	
    }
	@Override
	public void dump(){
			ChainedEntry[] table = this.table;
		     for(int i = 0; i < table.length; i++)
		     {
		       ChainedEntry entry = table[i];
		       System.out.println("slot "+i+": ");
		       while(entry != null)
		       {
		         System.out.print("word: "+entry.getWord()+entry.getDefinitions()+", ");
		         entry = entry.getNext();
		       }
		       System.out.println();
		     }

		 }
}
