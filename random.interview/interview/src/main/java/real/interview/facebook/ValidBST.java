package real.interview.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ValidBST {
	
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
	 
	public boolean isValidBST(Node p, int min, int max){
	    if(p==null) 
	        return true;
	 
	    if(p.data <= min || p.data >= max)
	        return false;
	 
	    return isValidBST(p.left, min, p.data) && isValidBST(p.right, p.data, max);
	}
	
	public List<List<Integer>> threeSum1(int[] nums) {
	    List<List<Integer>> triples = new ArrayList();
	    Arrays.sort(nums);
	    int i = 0, last = nums.length - 1;
	    while (i < last) {
	        int a = nums[i], j = i, k = last;
	        while (j < k) {
	            int b = nums[j], c = nums[k], sum = a+b+c;
	            if (sum == 0) triples.add(Arrays.asList(a, b, c));
	            if (sum <= 0) while (nums[j] == b && j < k) j++;
	            if (sum >= 0) while (nums[k] == c && j < k) k--;
	        }
	        while (nums[i] == a && i < last) i++;
	    }
	    return triples;
	}
	
	
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
		
		int[] arr = {-1,2,199};
//		List<List<Integer>> res = new ValidBST().threeSum(arr);
		System.out.println(new ValidBST().threeSum(arr));
//		assert( !res.isEmpty());
		
	}

}
