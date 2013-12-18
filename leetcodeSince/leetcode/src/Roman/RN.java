package Roman;

public class RN {
	 
    enum Numeral{
        I(1),IV(4),V(5),IX(9),X(10),XL(40),L(50),XC(90),C(100),CD(400),D(500),CM(900),M(1000);
        int weight;
        Numeral(int w){
            this.weight=w;
        }
        
        
    }
    
    public String intToRoman(int num) {
    	StringBuilder sb = new StringBuilder();
        Numeral[] nums = Numeral.values();
        for(int i=nums.length-1;i>=0;i--){
            while(num>nums[i].weight){
                sb.append(nums[i].toString());
                num -=nums[i].weight;
            }
            
        }
        return sb.toString();
    }
	
 
    public static String roman(long n) {
 
        if( n <= 0) {
            throw new IllegalArgumentException();
        }
 
        StringBuilder buf = new StringBuilder();
 
        final Numeral[] values = Numeral.values();
        for (int i = values.length - 1; i >= 0; i--) {
            while (n >= values[i].weight) {
                buf.append(values[i]);
                n -= values[i].weight;
            }
        }
        return buf.toString();
    }
 
    public static void test(long n) {
        System.out.println(n + " = " + roman(n));
    }
 
    public static void main(String[] args) {
        test(1999);
        test(25);
        test(944);
        test(0);
    }
 
}
