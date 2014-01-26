
public class DivideTwoInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int divide(int dividend, int divisor) {
        if(divisor ==0) throw new IllegalArgumentException("divisor can't be zero");

        int a = Math.abs(dividend);
        int b = Math.abs(divisor);

        int ret = 0;
        while (a >= b) {
            int c = b;
            for (int i = 0; a >= c; ++i, c <<= 1) {
                a -= c;
                ret += 1 << i;
            }
        }
        int flag =(dividend^divisor)>>>31;
        return (flag>0) ? (-ret) : (ret);
        
    }

}
