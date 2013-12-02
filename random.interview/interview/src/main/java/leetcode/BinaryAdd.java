package leetcode;

public class BinaryAdd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		
		System.out.println(s.addBinary("123456", "8888"));
		

		
	} 

}


class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Long ia = Long.parseLong(a,2);
        Long ib = Long.parseLong(b,2);
        
        return Long.toString(ia+ib,2);
        
    }
}
