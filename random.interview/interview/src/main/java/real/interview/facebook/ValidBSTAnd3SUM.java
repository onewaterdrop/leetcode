package real.interview.facebook;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class ValidBSTAnd3SUM {
	
	static class Node{
		int data;
		Node left,right;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	
	public boolean isValidBST(Node root) {
	    return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);    
	}
	 
	//restrict BST according to requirement
	public boolean isValidBST(Node p, int min, int max){
	    if(p==null) 
	        return true;
	 
	    if(p.data <= min || p.data >= max)
	        return false;
	 
	    return isValidBST(p.left, min, p.data) && isValidBST(p.right, p.data, max);
	}
		
	//allow duplicates according to problem, if not, change exp into j=i+1;
	public boolean threeSum(int[] nums) {
	    Arrays.sort(nums);
	    int i = 0, last = nums.length - 1;
	    while (i < last) {
	        int a = nums[i], j = i, k = last;
	        while (j < k) {
	            int b = nums[j], c = nums[k], sum = a+b+c;
	            if (sum == 0) return true;
	            if (sum <= 0) while (nums[j] == b && j < k) j++;
	            if (sum >= 0) while (nums[k] == c && j < k) k--;
	        }
	        while (nums[i] == a && i < last) i++;
	    }
	    return false;
	}
	
	@Test
	public void testTreeSum(){
		
		int[] arr1 = {-1,2,199};
		assertTrue(new ValidBSTAnd3SUM().threeSum(arr1));
		int[] arr2 = {-1,-7,8,100};
		assertTrue(new ValidBSTAnd3SUM().threeSum(arr2));
		int[] arr3 = {-1,-7,9,100};
		assertFalse(new ValidBSTAnd3SUM().threeSum(arr3));		
//		System.out.println(new ValidBSTAnd3SUM().threeSum(arr));
		
	}

}
