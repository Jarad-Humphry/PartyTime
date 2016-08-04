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
			long minTime = 999999999;
			int Threads = 2;
			long sortTime = 999999999;
			
			for (int i=0;i<Arr1.length;i++)
				{		
				Arr1[i] = randomNum();
				//System.out.println("" + i + ": " + Arr1[i]);
				}

			for (int a=2; a < 10000; a=a*2)
				{
				//System.out.println("Testing for " + a + " Threads:");
				for (int b = 0; b < 5; b++)
					{
				

					//System.out.println("The initial list is:");
	
					System.arraycopy(Arr1, 0, Arr2, 0, ArraySize);
					System.gc();
					tick();
					Arrays.sort(Arr2);
					long time = toc();
					sortTime = time;
					//Arr3[b] = time;

					//System.out.println("Time taken in series: " + time);
					System.arraycopy(Arr1, 0, Arr2, 0, ArraySize);
					if (sort.equals("Mergesort"))
						{
						ParallelMergeSort PMS = new ParallelMergeSort(Arr2, 0, Arr2.length, 1 + (Arr1.length)/a);							
						System.gc();
						tick();
						ForkJoinPool.commonPool().invoke(PMS);
							
							
						time = toc();
						//Arr4[b] = time;
						if (minTime == 999999999)
							{
							minTime = time;
							Threads = a;
							}
						if (time < minTime)
							{
							minTime = time;
							Threads = a;
							}
						}
							
							
									//System.arraycopy(Arr1, 0, Arr2, 0, ArraySize);
					if (sort.equals("Quicksort"))
						{
						QuickSort QS = new QuickSort(Arr2, 0, Arr2.length - 1, 1 + (Arr1.length)/a);
						System.gc();
						tick();
						ForkJoinPool.commonPool().invoke(QS);
						time = toc();	
						//Arr4[b] = time;
						//System.out.println("minTime: " + minTime + " time: " + time);
						if (minTime == 999999999)
							{
							minTime = time;
							Threads = a;
							//System.out.println("Threads set to: " + Threads);
							}
						if (time < minTime)
							{
							minTime = time;
							Threads = a;
							//System.out.println("minTime set to: " + minTime);
							}
						}
					}

					
							//Arrays.sort(Arr3);
							//Arrays.sort(Arr4);
					
						
							//System.out.println("The shortest serialsort time is: " + Arr3[0]);
							//System.out.println("The shortest parasort time is: " + Arr4[0]); 
					
				}
			System.out.println(ArraySize + "	" + Threads + "	" + minTime + "	" + (double)sortTime/minTime);
			}
		}	

	public static int randomNum ()
		{
		Random rand = new Random();
		int randomNumb = rand.nextInt(500) + 1;
		return randomNumb;
		}

	private static void tick()
		{
		startTime = System.nanoTime();
		}

	private static long toc()
		{
		return (System.nanoTime() - startTime) /*/ 1000.0f*/; 
		}
	}
