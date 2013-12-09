package number.trees;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numTrees(4);
		System.out.println(numTrees(4));
	}
	
	   public static int numTrees(int n) {
	        

	        if(n<=0) return 0;
	        if(n==1) return 1;
	        if(n==2) return 2;
	        
	        int sum=0;
	        if(n==3) return 5;
	        else{
	            for(int i=0;i<=n-1;i++)
		        if(i==0 || i ==n-1){
		        	sum += numTrees(n-1);
		        	
		        }else{
	             sum += numTrees(i) * numTrees(n-1-i);
		        }

	        }
	        
	        return sum;
	    }

}
