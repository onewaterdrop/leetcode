package four.sum;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution2 {
	
	
	private static int[] num = {2,1,0,-1,6,0,0};
	private static int target = 6;
	
    public ArrayList<ArrayList<Integer>> fourSum(int[] num,int target) {
    	
    	int len =num.length;
    	java.util.Set<ArrayList<Integer>> set =new java.util.HashSet<ArrayList<Integer>>();
    	
    	
    	if(len<4)return new ArrayList<ArrayList<Integer>>(set);
    	
    	Arrays.sort(num);
    	
    	if(4*num[len-1]<target)return new ArrayList<ArrayList<Integer>>(set);
    	if(4*num[0]>target)return new ArrayList<ArrayList<Integer>>(set);
    	

    	
 //   	System.out.println(Arrays.toString(num));


    	int i1,i2,i3,i4;

    	for(i1=0;i1<len-3;i1++)
    		for(i2=i1+1;i2<len-2;i2++)
    			for(i3=i2+1;i3<len-1;i3++)
    				for(i4=i3+1;i4<len;i4++)
						if(num[i1]+num[i2]+num[i3]+num[i4]==target){
							
							set.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{num[i1],num[i2],num[i3],num[i4]})));
							
						}
    	
		return new java.util.ArrayList<ArrayList<Integer>>(set);
    	
        
    }
    
    
    public static void main(String[] args) {
		
    	
    	Solution2 s = new Solution2();
    	long tic=System.currentTimeMillis();
    	System.out.println("timestamp is " + System.currentTimeMillis());;
    	ArrayList<ArrayList<Integer>> L = s.fourSum(num,target);
    	System.out.println("timestamp is " + System.currentTimeMillis());;
    	
    	System.out.println("******************************");
    	for(ArrayList<Integer> x:L){
    		System.out.println(x.toString());
    	}
    	
    	
	}
}
