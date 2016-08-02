import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class QuickSort extends RecursiveAction
	{
	private int[] arr;
	private int left;
	private int right;
	


	private QuickSort(int[] arr, int left, int right)
		{
		this.arr = arr;
		this.left = left;
		this.right = right;
		}

	@Override
	protected void compute()
		{
		
		}

	private void swap(int x, int y) 
		{
		int temp = array[x];
		arr[x] = arr[y];
		arr[y] = temp;
		}

	private void split()
		{
		
		}

	}
