//package dictionary;
//import test.PrimeSequence;
import dictionary.AbstractHashTable;
import dictionary.Loader;
//
import java.io.File;
//
import java.lang.reflect.Constructor;
/**
 * Program for testing load performance of a given hash table implementation of Dictionary.
 * 
 */
public class LoadTest {

   
    /** 
     * Create an instance of the given class of dictionary with the given table size.
     */
    private static AbstractHashTable createTable(final String className, final int tableSize) throws Exception { 
        final Class<? extends AbstractHashTable> tableClass = Class.forName(className).asSubclass(AbstractHashTable.class);
        final Constructor<? extends AbstractHashTable> intConstructor = tableClass.getConstructor(int.class);
        return intConstructor.newInstance(tableSize);
    }
    
    public static void main(final String[] args) throws Exception {
        // Create a dictionary object from the class name and table size given as command line arguments.
	
	//System.out.println(args[2]);
	int length = Integer.parseInt(args[1]);
	PrimeSequence prime = new PrimeSequence(length);
	int tableSize = prime.next();
        final AbstractHashTable table = createTable(args[0], tableSize);
        final Loader loader = new Loader(table);
	loader.load(new File("./data/" + args[2]));

	double entries = table.size();
	double dSize = tableSize;
	System.out.println("");
	System.out.println("testing " + args[0] + " for load ...");
	System.out.println("Probe count: " + table.getProbeCount());
	System.out.println("Table size: " + tableSize);
	System.out.println("table.size(): " + table.size());
	System.out.println("tableSize: " + tableSize);
	System.out.println("Load factor: " + table.loadFactor());

        // Your code here.
    }
    
    
}
