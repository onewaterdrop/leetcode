package sorting;

public interface SortingMethod {
	
	int[] BubleSort(int[] x);
	int[] SelectionSort(int[] x);
	int[] MergeSort(int[] x);
	int[] QuickSort(int[] x);
	int[] BucketSort(int[] x);
	int[] HeapSort(int[] x);
	
	public Integer[] QuickSort(Integer[] x);
	
	public void sort(int[] values);
	
	public void QuickSort(int[] x,int low,int high);
	
	int[] QuickSort2(int[] x);
	
	public int findIthMin(int[]A,int p,int r, int i);
	

}
