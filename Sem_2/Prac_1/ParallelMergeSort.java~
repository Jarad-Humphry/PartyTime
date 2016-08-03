import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeSort extends RecursiveAction {
	private int[] arr;
    private int start, end;
    private int threshold;

    public ParallelMergeSort(int[] arr, int start, int end, int threshold) {
            this.arr = arr;
            this.start = start;
            this.end = end;
            this.threshold = threshold;
    }

    @Override
    protected void compute() {
            if (end - start <= threshold) {
                    // sequential sort
                    Arrays.sort(arr, start, end);
                    return;
            }

            // Sort halves in parallel
            int mid = start + (end-start) / 2;
		
            invokeAll(
                    new ParallelMergeSort(arr, start, mid, threshold),
                    new ParallelMergeSort(arr, mid, end, threshold) );

            // sequential merge
            sequentialMerge(mid);
    }

    private void sequentialMerge(int mid) {
         //implement the merge

	//System.out.println(mid + "=mid");
	int count1 = 0;
	int count2 = 0;
	int j = start;
	int[] arrayMin = Arrays.copyOfRange(arr, this.start, mid);
	int[] arrayMax = Arrays.copyOfRange(arr, mid, this.end);
	//int[] result = new int[this.end - this.start];
		

	while (count1 < arrayMin.length && count2 < arrayMax.length)
		{
		//System.out.println("While loop started");
		if (arrayMin[count1] >= arrayMax[count2])
			{
			arr[j] = arrayMax[count2];
			j ++;
			count2 ++;
			//System.out.println("a");
			}

		else if (arrayMin[count1] <= arrayMax[count2])
			{
			arr[j] = arrayMin[count1];
			j ++;
			count1 ++;
			//System.out.println("b");
			}
		}
		
	
	
	//System.out.println("after while loop");
	//if (count1 == mid)
		{
		while (count2 < arrayMax.length)
			{
			arr[j] = arrayMax[count2];
			j ++;
			count2 ++;
			//System.out.println("c");
			}
		}

	//if (count2 == this.end)
		{
		while (count1 < arrayMin.length)
			{
			arr[j] = arrayMin[count1];
			j ++;
			count1 ++;
			//System.out.println("d");
			}
		}
	
	//arr = result;

	/*System.out.println("");

	for (int x = 0; x < result.length; x++)
		{
			
		System.out.println(x + ": " + result[x]);
		
		}
	System.out.println("done");*/
	

	

    }

}
