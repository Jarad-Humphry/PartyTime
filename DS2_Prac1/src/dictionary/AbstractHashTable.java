							package dictionary;
import java.util.List;
/**
 * Abstract implementation of dictionary using hash table.
 * 
 * @author Stephan Jamieson 
 * @version 24/4/2015
 */
public abstract class AbstractHashTable  extends Monitorable implements Dictionary {
    public final static int DEFAULT_SIZE = 50;
 
    protected Entry[] table;
    protected int entries;
 
    /**
     * Create a table with DEFAULT_SIZE. (For use by sub classes.)
     */
    protected AbstractHashTable() { this(DEFAULT_SIZE); }
    
    /**
     * Create a table with the given default size. (For use by sub classes.) 
     */
    protected AbstractHashTable(final int size) { 
        this.table = new Entry[size];
        this.entries = 0;
    }
    
    /**
     * Generate a hash code for the given key using algorithm in Weiss. (For use by sub classes.)
     */
    protected int hashFunction(String key) {
	// Your code here.
    	int hashVal = 0;
    
	for(int i = 0; i<key.length(); i++) 
		hashVal = 37 * hashVal+key.charAt(i);

	    hashVal %= table.length;
	    
	    if (hashVal < 0 ) {
		hashVal+=table.length;
	    }
	    return hashVal; 
    }
       
    public boolean containsWord(String word) {
	// Your code here.
        int value = findIndex(word);
	if (value == -1 || table[value] == null) 
		{
		return false;
		}

	/*if (table.length <= value)
		{
		return false;
		}*/

	else
		{
		
		if (table[value].getWord().equals(word))
			{
			return true;
			}
	
		else 
			{
			return false;
			}
		}
	
    }
    
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
	public int whatIndex(String word)
		{
		return findIndex(word);
		}
    
    public void insert(String word, Definition definition) {        
        // Your code here.
	Entry e = new Entry(word);
	e.addDefinition(definition);
	int index = findIndex(word);

	if (index ==-1)
		{
		return;
		}

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
    

    public boolean isEmpty() { return entries == 0; }
    
    public void empty() { this.table = new Entry[this.table.length]; this.entries=0; }
    
    public int size() { return this.entries; }
    
    /* Hash Table Functions */
    
    public double loadFactor() { return entries/(double)table.length; }

    /**
     * Method called by <code>insert()</code> when the table needs enlarging.
     * <p>
     * Sub classes should override as required.
     */
    protected void rebuild() {
          throw new IllegalStateException("Hashtable:insert(): table is full.");
    }
    
    
    /**
     * Find the index for entry: if entry is in the table, then returns its position; 
     * if it is not in the table then returns the index of the first free slot.
     * Returns -1 if a slot is not found (such as when the table is full under LP).
     * 
     */
    protected abstract int findIndex(String word);
        
        
    
    /**
     * Prints contents of table to screen. (Method provided to facilitate testing and debugging.) 
     */
    public void dump() {
        Entry[] table = this.table;
        for(int i=0; i<table.length; i++) {
            System.out.printf("\n%4d : %s", i, table[i]);
        }
        System.out.printf("\n#Entries: %d.", this.entries);
    }
    
    /**
     * Obtain a list of the entries in the dictionary. (Method to facilitate testing and debugging.) 
     */
    public java.util.ArrayList<Entry> getWords() {
        java.util.ArrayList<Entry> entries = new java.util.ArrayList<Entry>();
        for (int i=0; i<this.table.length; i++) {
            if (this.table[i]!=null) {
                entries.add(table[i]);
            }
        }
        return entries;
    }
        
}
