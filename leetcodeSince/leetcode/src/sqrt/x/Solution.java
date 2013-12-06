package sqrt.x;

public class Solution {

    public int sqrt(int x) {
    	
        if(x<0)return -1;
        if(x<1)return 0;
        if(x==1)return 1;
        double j=1.0;
        
        double Error = 0.3;
        
        
       while(j*j-x >Error ||j*j-x < -Error ){
    	   j= j/2+ x/(2*j);
    	}
       
       return (int)j;
    	
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	for(int i=1;i<20;i=i+2){
    		System.out.println("sqrt("+ i + ")=" + sol.sqrt(i) );
    	} 
    	
    	System.out.println("sqrt()=" + sol.sqrt(2147483647) );
    	
	}
}
