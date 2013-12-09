package max.profit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

	static int[] prices ={2,4,1};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("profit =" + maxProfit(prices));

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
    

}
