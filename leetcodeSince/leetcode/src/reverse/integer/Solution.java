package reverse.integer;

public class Solution {

	private static int test = 124;
    public int reverse(int x) {
        int r=0;
        while(x!=0){
            r=r*10+ x%10;
            x/=10;
        }
        
        return r;
    }
	
	public static void main(String[] args) {
		
		System.out.println("binary " +  Integer.toBinaryString(test & 0xF));
		System.out.println("decimal " + (test & 0xF));
		
	}
}
