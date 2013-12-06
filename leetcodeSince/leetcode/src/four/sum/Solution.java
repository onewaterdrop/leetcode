package four.sum;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	
	
	private static int[] num = {2,1,0,-1};
	private static int target = 2;
	
    public ArrayList<ArrayList<Integer>> fourSum(int[] num,int target) {
    	
    	int len =num.length;
    	java.util.Set<ArrayList<Integer>> set =new java.util.HashSet<ArrayList<Integer>>();
    	
    	
    	if(len<4)return new ArrayList<ArrayList<Integer>>(set);
    	
    	Arrays.sort(num);
    	
    	if(4*num[len-1]<target)return new ArrayList<ArrayList<Integer>>(set);
    	if(4*num[0]>target)return new ArrayList<ArrayList<Integer>>(set);
    	

    	
 //   	System.out.println(Arrays.toString(num));


    	int i1=0,i2=i1+1,i3=i2+1,i4=i3+1;
    	int sum=0;
    	while(i1<=len-4){
    		
    			sum=num[i1]+num[i2]+num[i3];
    		
				if(sum==target-num[i4]){
					
					set.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{num[i1],num[i2],num[i3],num[i4]})));
					
				}
				
				if(sum<target-num[i4]){
					
					i4++;  //the 1st runner until len-1;
					if(i4>len-1){
						i3++;
						i4=i3+1;
					}
					
				}else{
					
					i3++;  //the 2nd runner until len-2;
					i4=i3+1;
					
				}
				
				
				if(i3>len-2){
					i2++;
					i3=i2+1;
					i4=i3+1;
				}
				
				if(i2>len-3){
					i1++;
					i2=i1+1;
					i3=i2+1;
					i4=i3+1;
				}				
				
				
	    		if(i1>len-4)break;

    	}
    	
		return new java.util.ArrayList<ArrayList<Integer>>(set);
    	
        
    }
    
    
    public static void main(String[] args) {
		
    	
    	Solution s = new Solution();
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
