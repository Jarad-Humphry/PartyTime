import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestSimpleTreeWriter
	{
	@Test
	public void testprint()
		{
		LinkedBST<Integer> tree = new  LinkedBST<Integer>(comparator);
		BinaryTreeWriter<Integer> tester = new SimpleTreeWriter<Integer>(new PrintStream(new FileOutputStream(new File("test1.txt"))));
		tree.insert(1);
		tester.print(tree);		
		tester.setDestination(new PrintStream(new FileOutputStream(new File("test2.txt"))))
		tester.print(tree)

		assertTrue(check("test1.txt", "test2.txt"));
		}

	/*@Test
	public void testConstructer()
		{
		PrintStream somethingStream = new PrintStream(new ByteArrayOutputStream))
		
		}*/
	public static boolean check(final String testFile, final String oracleFile) throws IOException {
			final BufferedReader inTest = new BufferedReader(new FileReader(testFile));
			final BufferedReader inOracle = new BufferedReader(new FileReader(oracleFile));
		
			String testLine = inTest.readLine();
			String oracleLine = inOracle.readLine();
			while (testLine!=null && oracleLine!=null && testLine.equals(oracleLine)) {
				testLine = inTest.readLine();
				oracleLine = inOracle.readLine();
			}
			inTest.close();
			inOracle.close();
			return testLine==null&&oracleLine==null; 		
	}
	}
