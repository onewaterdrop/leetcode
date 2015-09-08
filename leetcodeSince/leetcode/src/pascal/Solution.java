package pascal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(generate(80));
		System.out.println(bSearch(new int[]{1,2,3,4,4,6,7},0,6,4));
		PriorityQueue<Integer> pq = new java.util.PriorityQueue<Integer>();
	}

    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> s = new ArrayList<ArrayList<Integer>>();
        if(numRows<=0)return s;
        s.add(new ArrayList<Integer>(java.util.Arrays.asList(new Integer[]{1})));
        if(numRows==1)return s;
        s.add(new ArrayList<Integer>(java.util.Arrays.asList(new Integer[]{1,1})));       
        if(numRows == 2) return s;
        for(int i=3;i<=numRows;i++){
            Integer[] sub= new Integer[i];
            sub[0]=1;
            sub[i-1]=1;
            for(int j=1;j<i-1;j++){
                sub[j]=s.get(i-2).get(j-1) + s.get(i-2).get(j);
            }
            
            s.add(new ArrayList<Integer>(java.util.Arrays.asList(sub)));
        }
        
        return s;
    }
    
    static int bSearch(int[] a,int start,int end,int target){
    	int L = start, R = end;
    	while(L<R){
    		 int M = (L+R)/2;
    		if(a[M]<target)L=M+1;
    		else R= M;
    	}
    	
    	return (L == R)&& a[L]==target ?L:-1;
    }
}
