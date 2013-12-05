package two.sum;

/**
 * 
 * @author youk  Algorithm for two sum problem.
 *
 */


public class Solution {
	
// no sort allowed.	
	//	private static int[] numbers ={5,75,25};
//	private static int[] numbers ={2,7,11,15};
	private static int[] numbers ={150,24,24,50,88,345,3};
//	private static int[] numbers ={230,863,916,585,981,404,316,785,88,12,70,435,384,778,887,755,740,337,86,92,325,422,815,650,920,125,277,336,221,847,168,23,677,61,400,136,874,363,394,199,863,997,794,587,124,321,212,957,764,173,314,422,927,783,930,282,306,506,44,926,691,568,68,730,933,737,531,180,414,751,28,546,60,371,493,370,527,387,43,541,13,457,328,227,652,365,430,803,59,858,538,427,583,368,375,173,809,896,370,789};
//	private static int target=9;
	private static int target=48;
	//	private static int target=100;
	
	
    public int[] twoSumNoSorting(int[] numbers, int target) {
    	

    	int len = numbers.length;
		
    	int i=0,j=0;
    	
    	
    	for(i=0;i<len;i++){
    		
    		System.out.println("i,j=" +i +"," + j);
    		
	        for(j=0;j<len;j++){
	    		if(numbers[i]+numbers[j]==target &&i!=j){
	    			numbers[0]=i<=j?(i+1):(j+1);
	    			numbers[1]=i<=j?(j+1):(i+1);
	    			return numbers;
	    		}
	    		
	        }
    		
    		
    	}
    	
		return numbers;
        
    }
    
    public static void main(String[] arg){
    	
    	Solution sol = new Solution();
    	
    	int[] ans = sol.twoSumNoSorting(numbers, target);
    	
    	System.out.println("index1 =" +ans[0] + " index1 =" + ans[1]);
    	
    }
    
}