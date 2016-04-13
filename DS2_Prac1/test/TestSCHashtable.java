import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import dictionary.*;
import java.util.ArrayList;
import dictionary.AbstractHashTable;
import dictionary.Loader;
import java.io.File;
//
import java.lang.reflect.Constructor;

public class TestSCHashtable{
	
	

	@Test
	public void testInsert(){
		SCHashTable table = new SCHashTable(10);
		SCHashTable table2 = new SCHashTable(2);
		WordType wt1 = WordType.toWordType("n");
		QPHashTable table3 = new QPHashTable();
		Definition d1 = new Definition(wt1, "its business time");
		Definition d2 = new Definition(wt1, "sorry but no");
		Definition d3 = new Definition(wt1, "its cool");
		int size = table.size();
	    	table.insert("minion", d1);
		table.insert("minion", d2);
		table.insert("despicable", d1);
		table.insert("felonious", d2);
		table2.insert("minion", d2);
		table2.insert("despicable", d1);
		table2.insert("felonious", d2);
		table2.insert("minion", d1);
		table2.insert("party", d2);
		table2.insert("yes", d2);
		table2.insert("sometimes", d3);
		table2.insert("sometimes", d2);
		table2.insert("yes", d1);
		

		//String w1 = table[8].getword();
		//if (table[8]!=null)
			{
	    		assertEquals(8, table.whatIndex("minion"));
			}
		table.empty();
	}

	@Test
	public void testContainsAndDefinitionsAndisEmpty()
		{
	
		SCHashTable table = new SCHashTable(10);
		SCHashTable table2 = new SCHashTable(2);
		WordType wt1 = WordType.toWordType("n");
		//WordType wt1 = WordType.toWordType("n");
		Definition d1 = new Definition(wt1, "nah");
		Definition d2 = new Definition(wt1, "cool");
	
	    	//table.insert("oops", d1);
		table.insert("oops", d1);
		table2.insert("nope", d2);
		table2.insert("despicable", d1);
		table2.insert("felonious", d2);
		table2.insert("minion", d1);
		table2.insert("party", d2);
		table2.insert("yes", d2);
		//table2.insert("what", d1);
		//assertEquals("[(noun) nah]", table.getDefinitions("oops").toString());
		assertEquals("[(noun) cool]", table2.getDefinitions("yes").toString());
		assertEquals("[(noun) nah]", table2.getDefinitions("oops").toString());
		assertEquals(null, table.getDefinitions("zxcv"));
		assertEquals(false, table.isEmpty());
		table.empty();
		table.dump();
		
		table.loadFactor();
		assertEquals(true, table.isEmpty());
		
		}

		
	@Test
	public void testgetWords()
		{
		SCHashTable table = new SCHashTable(10);
		SCHashTable table2 = new SCHashTable(2);
		WordType wt1 = WordType.toWordType("n");
		//WordType wt1 = WordType.toWordType("n");
		Definition d1 = new Definition(wt1, "nah");
		Definition d2 = new Definition(wt1, "cool");
		Entry ent = new Entry("fine");
		//ent.addDefinition(d1);
		//ent = table.getWords();
		ArrayList<Entry> list = new ArrayList<Entry>(2);
		list = table.getWords();
		table.insert("fine", d1);
		
		}
//java.util.ArrayList<[fine: [(noun) nah]]>  
//java.util.ArrayList<[fine: [(noun) nah]]>

	

}
