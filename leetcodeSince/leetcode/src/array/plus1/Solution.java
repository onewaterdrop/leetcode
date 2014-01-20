package array.plus1;

import java.util.Arrays;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Arrays.toString(plusOne(new int[]{1,2,9})));
		//System.arraycopy(src, srcPos, dest, destPos, length);
		
	}
	
    public static int[] plusOne(int[] digits) {
        
        System.out.println("i=");
        int i=digits.length-1;
        
        digits[i]++;
        
        if(i==0){
	        if(digits[i]==10){
	            digits[i]=0;
	        }
	        return digits;
        }
        
        System.out.println("i=");
        
        while(i>0){

            if(digits[i]==10){
                digits[i]=0;
                digits[i-1]++;
            }
            
            i--;
            
            System.out.println("i="+i);
            
        }
        

        
        return digits;
        
    }

}
