package sorting;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class SortingMethodImplTest extends TestCase {

	private SortingMethod sortingMethod;
	
	int[] x={9,8,7,6,5,4,3,2,1,0};

	@Before
	protected void setUp() throws Exception {
		sortingMethod = new SortingMethodImpl();
		
	}
	
	
	@Test
	public void test_buble(){
		
		int[] y=sortingMethod.BubleSort(x);
//		for(int i=0;i<y.length;i++){
//			System.out.println(y[i]);
//		}
		
		assertTrue(y[0]==0);
		assertTrue(y[9]==9);
		
	}
	@Test
	public void test_selection_sort(){
		
		int[] y=sortingMethod.SelectionSort(x);
		assertTrue(y[0]==0);
		assertTrue(y[9]==9);
		
	}
	@Test
	public void test_merge_sort(){
		
//		int[] x={7,8,9,10,12,15,17,0,1,2,3,4,5,6};
//		int[] x1={0};
		int[] y=sortingMethod.MergeSort(x);
		assertTrue(y[0]==0);
//		assertTrue(y[y.length-1]==17);
		
//		for(int i=0;i<y.length;i++){
//		System.out.println(y[i]);
//		}
		
		
		
	}
	
//	@Test
//	public void test_quick_sort(){
//		
//		int[] x={7,8,9,10,10,10,17,0,1,2,3,4,5,6};
////		int[] x1={0};
//		sortingMethod.sort(x);
//		assertTrue(x[0]==0);
////		assertTrue(y[y.length-1]==17);
//		
//		for(int i=0;i<x.length;i++){
//		System.out.println(x[i]);
//		}
//		
//	}
	
	@Test
	public void test_quick_sort_mine(){
		
		int[] x={7,7,7,10,10,17,0,1,2,3,4,5,6};
//		int[] x1={0};
		sortingMethod.QuickSort(x,0,x.length-1);
		assertTrue(x[0]==0);
//		assertTrue(y[y.length-1]==17);
		
		for(int i=0;i<x.length;i++){
			System.out.println(x[i]);
		}
		
	}
	
	@Test
	public void test_bucket_sort_mine(){
		
		int[] x={7,7,7,10,10,17,0,1,2,3,4,5,6};
//		int[] x1={0};
		sortingMethod.BubleSort(x);
		assertTrue(x[0]==0);
//		assertTrue(y[y.length-1]==17);
		
		for(int i=0;i<x.length;i++){
			System.out.println(x[i]);
		}
		
	}

}
