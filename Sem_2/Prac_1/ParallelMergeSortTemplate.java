import java.util.Arrays;

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
	

    }

}
