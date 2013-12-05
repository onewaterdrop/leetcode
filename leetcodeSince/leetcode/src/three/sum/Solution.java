package three.sum;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	
	
	private static int[] num = {-1,0,1,2,-1,-4};
	
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    	
    	Arrays.sort(num);
    	
 //   	System.out.println(Arrays.toString(num));
    	java.util.Set<ArrayList<Integer>> L =new java.util.HashSet<ArrayList<Integer>>();
    	
    	
    	for(int i=0;i<num.length;i++){
    		for(int j=0;j<i;j++){
    			for(int k=0;k<j;k++){
    				
 //   				System.out.println(Arrays.asList(new Integer[]{num[i],num[j],num[k]}).toString());
    				
    				if(num[i]+num[j]+num[k]==0){
    					
    					L.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{num[k],num[j],num[i]})));
    					
    				}
    				
    				
    			}
    		}
    	}
    	
    	
    	
		return new java.util.ArrayList<ArrayList<Integer>>(L);
    	
        
    }
    
    
    public static void main(String[] args) {
		
    	Solution s = new Solution();
    	ArrayList<ArrayList<Integer>> L = s.threeSum(num);
    	
    	System.out.println("******************************");
    	for(ArrayList<Integer> x:L){
    		System.out.println(x.toString());
    	}
    	
    	
	}
}
