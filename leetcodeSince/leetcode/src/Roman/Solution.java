package Roman;

import java.util.LinkedList;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("IV="+ romanToInt("IV"));
		System.out.println(romanToInt("IV"));
		System.out.println(romanToInt("MIV"));
		System.out.println(romanToInt("MMMCMCIV"));		
	}
	
	

	enum numerals{
		I,
		V,
		X,
		L,
		C,
		D,
		M;
		
	}
	
    public String intToRoman(int num) {
    	
    	
    	
    	
    	return null;
        
    }
	
    public static int romanToInt(String s) {
        
    	char[] array=s.toCharArray();
    	int sum=0;
    	int i=0;
    	java.util.Deque<Character> stack = new LinkedList<Character>();
    	while(i<array.length){
    		if(i<array.length-1 && numeral2Int(array[i])<numeral2Int(array[i+1])){
    			
    			sum +=numerals2Int(array[i],array[i+1]);
    			i=i+2;
    			
    		}else{
    			sum +=numeral2Int(array[i]);
        		i++;
    		}
    		
    	}
    	
    	
    	return sum;
    	
    }
    
    public static int numeral2Int(char c){
    	switch(c){
    	case 'I': return 1;
    	case 'V': return 5;
    	case 'X': return 10;
    	case 'L': return 50;
    	case 'C': return 100;
    	case 'D': return 500;
    	case 'M': return 1000;
    	default:
    		return 0;
    	}
    	
    }
    
    public static int numerals2Int(char c1,char c2){
    	switch(c1){
    	case 'I': 
    		if(c2=='V')return 4;
    		else return 9;
    	case 'X':     		
    		if(c2=='L')return 40;
    		else return 90;
    	case 'C':
    		if(c2=='D')return 400;
    		else return 900;
    	default:
    		return 0;
    	}
    	
    }
    
    

}
