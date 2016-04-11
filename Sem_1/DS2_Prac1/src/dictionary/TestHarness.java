package dictionary;
public class TestHarness {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LPHashTable lp = new LPHashTable(10);
		Definition onedef = new Definition(WordType.NOUN,"a cool guy");
		Definition onedef2 = new Definition(WordType.ADJECTIVE,"smarts");
      Definition onedef3 = new Definition(WordType.NOUN,"follower");
	//	System.out.println(lp.hashFunction("a")+" "+lp.hashFunction("av"));
		lp.insert("minion", onedef);
      lp.insert("minion", onedef3);
      lp.insert("despicable", onedef);
		
		
		lp.insert("felonious", onedef);
		lp.insert("supervillain", onedef2);
		lp.dump();
      System.out.println();
      System.out.println(lp.containsWord("supervillain"));
      System.out.println(lp.getDefinitions("supervillain"));
      
		
		System.exit(0);
		
	}

}
