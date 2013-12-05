package two.sum;

/**
 * 
 * @author youk  Algorithm for two sum problem.
 *
 */


public class Solution {
	
	
	private static int[] numbers ={5,75,25};
//	private static int[] numbers ={2,7,11,15};
//	private static int target=9;
	private static int target=100;
	
	
    public int[] twoSum(int[] numbers, int target) {
    	

    	int len = numbers.length;
    	java.util.Arrays.sort(numbers);
		if(2*numbers[0]>target||2*numbers[len-1]<target ){
			numbers[0]=-1;
			numbers[1]=-1;
			return numbers;
		}
		
    	int i=0,j=0;
    	while(i<len&&j<len){
    		
    		System.out.println("i,j=" +i + j);
    		
    		if(numbers[i]+numbers[j]==target){
    			numbers[0]=i<=j?(i+1):(j+1);
    			numbers[1]=i<=j?(j+1):(i+1);
    			return numbers;
    		}
    		
    		if(numbers[i]+numbers[j]<target && i<len-1 ){
    			i++;
    			continue;			
    		}else if(numbers[i]+numbers[j]<target && j<len-1){
    			j++;
    			continue;
    		}else if(numbers[i]+numbers[j]>target && i<=len-1 ){
    			i--; 
    			j++;
    			continue;
    		}   		
    		
    		
    	}
    	
    	
		numbers[0]=-1;
		numbers[1]=-1;
    	
		return numbers;
        
    }
    
    public static void main(String[] arg){
    	
    	Solution sol = new Solution();
    	
    	int[] ans = sol.twoSum(numbers, target);
    	
    	System.out.println("index1 =" +ans[0] + " index1 =" + ans[1]);
    	
    }
    
}