package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SortingMethodImpl implements SortingMethod {
	

	public  int[] BubleSort(int[] x) {
		
		int tmp;
		for(int i=0;i<x.length;i++){
			for(int j=1;j<x.length;j++){
				if(x[j]<x[j-1]){
					tmp = x[j];
					x[j]=x[j-1];
					x[j-1]=tmp;
				}
			}
				
		}
		
		return x;
	}

	public int[] SelectionSort(int[] x) {
		// TODO Auto-generated method stub
		for(int i=0;i<x.length;i++){
			int tmpi = i;
			int tmp =x[i];
			for(int j=i;j<x.length;j++){
				if(x[j]<tmp){
					tmp =x[j];
					tmpi=j;
				}
			}
			
			x[tmpi]=x[i];
			x[i]=tmp;
			
		}
		
		return x;
	}

	public int[] MergeSort(int[] x) {
		if(x.length<=1)return x;
		int mid = x.length/2;
		int left[] = new int[mid];
		int right[] = new int[x.length-mid];
		for(int i=0;i<mid;i++)left[i]=x[i];
		for(int i=mid;i<x.length;i++)right[i-mid]=x[i];		
		left=MergeSort(left);
		right=MergeSort(right);
		return merge(left,right);
	}
	
	private int[] merge(int[] left, int[] right){
		int[] result = new int[left.length+right.length];
		int i=0,j=0;
		while(i<left.length && j<right.length){
			if(left[i]<right[j]){
				result[i+j]=left[i];i++;
			}else{
				result[i+j]=right[j];j++;
			}
			
		}
		
		while(i<left.length){
			result[i+j]=left[i];i++;
		}
		while(j<right.length){
			result[i+j]=right[j];j++;
		}
		return result;
	}

	public int[] QuickSort(int[] x) {return null;}
	
	public void QuickSort(int[] x,int low,int high) {
		
		int pivot = (high + low)/2;
		int i=low, j =high;
		while(i<=j){
			
			while(x[i]<x[pivot]) i++;
			
			while(x[j]>x[pivot]) j--;
			
			if(i<=j){
				swap(x,i,j);
				i++;
				j--;
				
			}
			
			if(low<j) QuickSort(x,low,j);
			if(i<high) QuickSort(x,i,high);	
			
		}
		
		
	}
	
	void swap(int[] x, int i,int j){
		int tmp =x[i];
		x[i] = x[j];
		x[j] = tmp;
	}
	
	public static <E extends Comparable<? super E>> List<E> quickSort(List<E> arr) {
		if (!arr.isEmpty()) {
		    E pivot = arr.get(0); //This pivot can change to get faster results
		 
		 
		    List<E> less = new LinkedList<E>();
		    List<E> pivotList = new LinkedList<E>();
		    List<E> more = new LinkedList<E>();
		 
		    // Partition
		    for (E i: arr) {
		        if (i.compareTo(pivot) < 0)
		            less.add(i);
		        else if (i.compareTo(pivot) > 0)
		            more.add(i);
		        else
		            pivotList.add(i);
		    }
		 
		    // Recursively sort sublists
		    less = quickSort(less);
		    more = quickSort(more);
		 
		    // Concatenate results
		    less.addAll(pivotList);
		    less.addAll(more);
		    return less;
		 }
		return arr;
		 
		}
	
	public Integer[] QuickSort(Integer[] x) {
		// TODO Auto-generated method stub
		if(x==null)return null;
		if(x.length<=1) return x;
		int pivot = x[0];
		
		List<Integer> less=new ArrayList<Integer>();
		List<Integer> more=new ArrayList<Integer>();
		List<Integer> pivotList=new ArrayList<Integer>();
		int j=0,k=0;
		for(int i=1;i<x.length;i++)
		{
			if(x[i]<pivot){less.add(x[i]);}
			else if(x[i]>pivot){
				more.add(x[i]);
			}else{
				pivotList.add(x[i]);
			}
			
		}

	
		Integer[] less1 = (Integer[])less.toArray();
		Integer[] more1 = (Integer[])more.toArray();
		Integer[] p1 = (Integer[])pivotList.toArray();
		less1 = QuickSort(less1);
		more1 =QuickSort(more1);
		
		List<Integer> all=new ArrayList<Integer>();
		less =Arrays.asList(less1);
		more =Arrays.asList(more1);
		
		all.addAll(less);
		all.addAll(more);
		all.addAll(pivotList);
		
		Integer[] all1 = (Integer[])all.toArray();
		
		return all1;
	}

	public int[] BucketSort(int[] x) {
		// TODO Auto-generated method stub
		int[] buckets={0,6,9};
		int[] x1=new int[x.length/3];
		int[] x2=new int[x.length/3];
		int[] x3=new int[x.length-x1.length-x2.length];
		
		int j1=0,j2=0,j3=0;
		for(int i=0;i<x.length;i++){
			if(x[i]>buckets[2])x3[j3++]=x[i];
			else if(x[i]>buckets[1])
				x2[j2++]=x[i];
			else 
				x1[j1++]=x[i];

		}
		
		QuickSort(x1,0,j1-1);
		QuickSort(x2,0,j2-1);
		QuickSort(x3,0,j3-1);
		
		for(int i=0;i<x.length;i++){
			if(i<j1-1)x[i]=x1[i];
			else if(i<j1+j2-1)
				x[i]=x2[i-j1];
			else
				x[i]=x3[i-j1-j2];
		}
		

		return x;
	}

	public int[] HeapSort(int[] x) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	  private int[] numbers;
	  private int number;

	  public void sort(int[] values) {
	    // Check for empty or null array
	    if (values ==null || values.length==0){
	      return;
	    }
	    this.numbers = values;
	    number = values.length;
	    quicksort(0, number - 1);
	  }

	  private void quicksort(int low, int high) {
	    int i = low, j = high;
	    // Get the pivot element from the middle of the list
	    int pivot = numbers[low + (high-low)/2];

	    // Divide into two lists
	    while (i <= j) {
	      // If the current value from the left list is smaller then the pivot
	      // element then get the next element from the left list
	      while (numbers[i] < pivot) {
	        i++;
	      }
	      // If the current value from the right list is larger then the pivot
	      // element then get the next element from the right list
	      while (numbers[j] > pivot) {
	        j--;
	      }

	      // If we have found a values in the left list which is larger then
	      // the pivot element and if we have found a value in the right list
	      // which is smaller then the pivot element then we exchange the
	      // values.
	      // As we are done we can increase i and j
	      if (i <= j) {
	        exchange(i, j);
	        i++;
	        j--;
	      }
	    }
	    // Recursion
	    if (low < j)
	      quicksort(low, j);
	    if (i < high)
	      quicksort(i, high);
	  }

	  private void exchange(int i, int j) {
	    int temp = numbers[i];
	    numbers[i] = numbers[j];
	    numbers[j] = temp;
	  }

	public int[] QuickSort2(int[] x) {
		// TODO Auto-generated method stub
		quicksort2(x,0,x.length-1);
		
		return x;
	}

	private void quicksort2(int[] A, int p, int r) {
		
		if(p<r){
			int q = partition(A,p,r);
			quicksort2(A,p,q-1);
			quicksort2(A,q+1,r);
		}
		
	}

	private int partition(int[] A, int p, int r) {
		// TODO Auto-generated method stub
		int pivot = A[r];
		int ex=0;
		int i=p-1;
		for(int j=p;j<r;j++){
			if(A[j]<=pivot){
				i++;
				ex = A[i];
				A[i]=A[j];
				A[j]=ex;
			}
		}
		
		ex = A[i+1];
		A[i+1]=A[r];
		A[r]=ex;
		
		return i+1;
		
	}

	public int findIthMin(int[] A, int p, int r, int i) {
		// TODO Auto-generated method stub
		if(p==r)return A[p];
		int q = partition(A,p,r);
		int k=q-p+1;
		if(i==k){
			return A[q];
		}else if(i<k){
			return findIthMin(A,p,q-1,i);
		}else{
			return findIthMin(A,q+1,r,i-k);
		}
		
	}
	
	

}
