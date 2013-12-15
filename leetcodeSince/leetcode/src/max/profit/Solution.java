package max.profit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {

	static int[] prices ={2,4,1};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("profit =" + maxProfit(prices));
		Math.abs(-1);
		Arrays.asList(args);
		Queue<Integer> l = new LinkedList<Integer>();
	}
	
    public static int maxProfit(int[] prices) {

    	if(prices.length==0)return 0;
    	int change;
		int profit = 0;
    	for(int k=1;k<prices.length;k++){
    		change= prices[k] - prices[k-1];
    		if(change>0)profit +=change;
    		
    	}
    	
    	return profit;
    	
    }
    
    //buy only once;
    
    public int maxProfit2(int[] prices) {
        
        if(prices.length<=1)return 0;
        
        int[] copy=Arrays.copyOfRange(prices,0,prices.length);
        Arrays.sort(copy);

        int max=0;
        
        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++)
            if(max<prices[j]-prices[i]) max =prices[j]-prices[i];
        }
        
        return max;
    }
    
    public int maxProfit3(int[] prices) {
        if(prices.length<=1)return 0;
    	int max =0;
        int[] copy=Arrays.copyOfRange(prices,0,prices.length);
        Arrays.sort(copy);
        
        SortedMap<Integer,Integer> m =new TreeMap<Integer,Integer>();
        
        
    	
        
        return max;
    }
    

}
