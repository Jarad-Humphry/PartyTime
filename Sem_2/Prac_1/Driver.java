import java.util.Arrays;
import java.util.Random;
import java.lang.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Driver
	{
	static long startTime = 0;

	public static void main	(String[] args)
		{
		System.out.println("its running");
		String sort = args[0];
		System.out.println("args?");
		//if (sort.equals("Mergesort"))
			//{
			System.out.println("a");
			//Integer.parseInt()

			int ArraySize;
			//int NumberOfThreads = 8;
			//int Threshold = 1 + (ArraySize/Runtime.getRuntime().availableProcessors());
			//System.out.println("Number of Processors: " + Runtime.getRuntime().availableProcessors());	

			int min = Integer.parseInt(args[1]);
			int max = Integer.parseInt(args[2]);
			int increment = Integer.parseInt(args[3]);
			//int[] Arr1 = new int[ArraySize];
			//int[] Arr2 = new int[ArraySize];
			long[] Arr3 = new long[5];
			long[] Arr4 = new long[5];

			//System.out.println("b");

			for (int p = min; p < max; p=p+increment)
				{
				//System.out.println("c");
				ArraySize = p;
				int[] Arr1 = new int[ArraySize];
				int[] Arr2 = new int[ArraySize];

					for (int i=0;i<Arr1.length;i++)
						    {		
							Arr1[i] = randomNum();
							//System.out.println("" + i + ": " + Arr1[i]);
						    }

					for (int a=2; a < 18; a=a+2)
						{
						System.out.println("Testing for " + a + " Processors:");
						for (int b = 0; b < 5; b++)
							{
				

							//System.out.println("The initial list is:");

				
		
							System.arraycopy(Arr1, 0, Arr2, 0, ArraySize);

		
							tick();
							Arrays.sort(Arr2);
							long time = toc();
							Arr3[b] = time;

							//System.out.println("Time taken in series: " + time);

							System.arraycopy(Arr1, 0, Arr2, 0, ArraySize);

							if (sort.equals("Mergesort"))
								{
								ParallelMergeSort PMS = new ParallelMergeSort(Arr2, 0, Arr2.length, 1 + (Arr1.length)/a);		
								tick();
								ForkJoinPool.commonPool().invoke(PMS);
								
								
								time = toc();
								Arr4[b] = time;
								}
							else if (sort.equals("Quicksort"))
								{
								QuickSort QS = new QuickSort(Arr2, 0, Arr2.length - 1);
								tick();
								ForkJoinPool.commonPool().invoke(QS);
								time = toc();
								Arr4[b] = time;
								}
							

							System.out.println("Time taken in parralel: " + time);

							System.out.println("");
							System.out.println("The sorted version:");
							for (int k=0;k<Arr2.length;k++)
								{
								System.out.println("" + k + ": " + Arr2[k]);
								}
		
							/*System.out.println("The sorted version:");
							for (int p=0;p<Arr1.length;p++)
								{
								System.out.println("" + p + ": " + Arr1[p]);
								}*/
							}
						System.out.println("Using " + a + " processes:");
						long l = Arr3[0];
						long m = Arr4[0];

						for (int c = 1; c < 5; c ++)
							{
							if (Arr3[c] < l)
								{
								l = Arr3[c];
								}
							if (Arr4[c] < m)
								{
								m = Arr4[c];
								}
							}
						Arrays.sort(Arr3);
						Arrays.sort(Arr4);
						System.out.println("The shortest serialsort time is: " + Arr3[0]);
						System.out.println("The shortest parasort time is: " + Arr4[0]); 
						}
					}
				}
			//}

	public static int randomNum ()
		{
		Random rand = new Random();
		int randomNumb = rand.nextInt(500) + 1;
		return randomNumb;
		}

	private static void tick()
		{
		startTime = System.currentTimeMillis();
		}

	private static long toc()
		{
		return (System.currentTimeMillis() - startTime) /*/ 1000.0f*/; 
		}
	}
