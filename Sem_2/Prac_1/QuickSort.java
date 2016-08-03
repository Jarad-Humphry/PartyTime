import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class QuickSort extends RecursiveAction
	{
	private int[] arr;
	private int left;
	private int right;
	



	public QuickSort (int[] arr, int left, int right)
		{
		this.arr = arr;
		this.left = left;
		this.right = right;
		}

	

	@Override
	protected void compute()
		{
		if (right > left)
			{
			System.out.println("running");
			int piv = split(left, right, arr);
			invokeAll(
				new QuickSort(arr, left, piv),
				new QuickSort(arr, piv + 1, right) );
			}
		}

	private void swap(int x, int y) 
		{
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
		}

	public int split(int min, int max, int[] Arr)
		{
		int l = min;
		int m = max;
		int piv = Arr[min];
		whileLoop: while (true)
			{
			for1: for (l = min; l < max; l ++)
				{
				if (Arr[l] > piv)
					{
					break for1;
					}
				}
			for2: for (m = max; m > min; m --)
				{
				if (Arr[m] < piv)
					{
					break for2;
					}
				}
			if (l>=m)
				{
				return m;
				}
			
			swap(m, l);
			
			}
		}

	}