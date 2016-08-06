import java.util.Arrays;
import java.util.Random;
import java.lang.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.io.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestQuickSort
	{
	int ArraySize = 10000;
	int [] Arr1 = new int[ArraySize];
	int [] Arr2 = new int[ArraySize];
	int [] Arr3 = new int[ArraySize];
	int [] Arr4 = new int[ArraySize];
	
	@Before
	public void setUp() throws Exception
		{
		
		for (int i=0;i<Arr1.length;i++)
			{		
			Arr1[i] = randomNum ();
			//System.out.println("" + i + ": " + Arr1[i]);
			}
		}
	
	@Test
	public void TestMerge()
		{
		//setUp();
		
		System.arraycopy(Arr1, 0, Arr2, 0, ArraySize);
		System.arraycopy(Arr1, 0, Arr3, 0, ArraySize);

		ParallelMergeSort PMS = new ParallelMergeSort(Arr2, 0, ArraySize, 1);							
		ForkJoinPool.commonPool().invoke(PMS);
		Arrays.sort(Arr3);
		//System.out.println(Arr2.toString());
		//System.out.println(Arr3.toString());
		//System.out.println("ezest mode");
		
		assertEquals (Arrays.toString(Arr2), Arrays.toString(Arr3));
		}

	@Test
	public void testQuick()
		{
		System.arraycopy(Arr1, 0, Arr2, 0, ArraySize);
		System.arraycopy(Arr1, 0, Arr3, 0, ArraySize);

		QuickSort QS = new QuickSort(Arr2, 0, Arr2.length - 1, 2);
		ForkJoinPool FJP = new ForkJoinPool();
		FJP.commonPool().invoke(QS);
		Arrays.sort(Arr3);

		assertEquals (Arrays.toString(Arr2), Arrays.toString(Arr3));
		}

	public static int randomNum ()
		{
		Random rand = new Random();
		int randomNumb = rand.nextInt(500) + 1;
		return randomNumb;
		}

	}
