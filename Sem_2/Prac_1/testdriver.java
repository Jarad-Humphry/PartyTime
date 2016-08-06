import java.util.Arrays;
import java.util.Random;
import java.lang.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.io.*;

public class testdriver
	{
	public static void main	(String[] args)
		{
		int ArraySize = 500;
		
		int [] Arr1 = new int[ArraySize];
		int [] Arr2 = new int[ArraySize];
		for (int i=0;i<Arr1.length;i++)
				{		
				Arr1[i] = randomNum();
				//System.out.println("" + i + ": " + Arr1[i]);
				}
		System.out.println(Arrays.toString(Arr1));
		System.arraycopy(Arr1, 0, Arr2, 0, ArraySize);
		
		QuickSort QS = new QuickSort(Arr2, 0, Arr2.length - 1, 2);
		ForkJoinPool FJP = new ForkJoinPool();
		FJP.commonPool().invoke(QS);
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println(Arrays.toString(Arr2));
		}

	public static int randomNum ()
		{
		Random rand = new Random();
		int randomNumb = rand.nextInt(500) + 1;
		return randomNumb;
		}
	
	}
