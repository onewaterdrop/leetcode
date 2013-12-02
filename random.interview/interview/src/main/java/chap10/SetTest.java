package chap10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] A ={1,2,3,4,5,6};
		Integer[] B ={3,4,5,6,7};
		List<Integer> a = Arrays.asList(A);
		List<Integer> b = Arrays.asList(B);
		
		Set<Integer> AA = new HashSet<Integer>(a);
		Set<Integer> BB = new HashSet<Integer>(b);
		
		AA.removeAll(BB);
//		AA.retainAll(BB);
		System.out.println(AA.size());
		System.out.println(java.lang.Math.pow(1.5, 5.1));
		
		System.out.println(java.lang.Math.nextUp(1.5));

	}

}
