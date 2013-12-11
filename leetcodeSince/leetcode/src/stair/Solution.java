package stair;


public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 40; i < 60; i++)
			System.out.println("stair " + i + " need " + climbStairs(i));

		System.out.println(Integer.MAX_VALUE);

	}
	
	public static int climbStair(int n) {
	       double s = Math.sqrt(5.0);
	        return (int)((Math.pow((1+s)/2,n+1)+Math.pow((1-s)/2,n+1))/s+0.5);
		}

	public static int climbStairs(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		if (n == 3)
			return 3;
		long sum = 0;
		for (int i = 0; i <= n / 2; i++) {
			// sum+= factorial(n-i)/factorial(n-2*i)/factorial(i);
			sum = sum + choose(n - i, i).longValue();
		}

		return (int)sum;
	}

	static java.math.BigInteger choose(long n, final long m) {
		java.math.BigInteger r = java.math.BigInteger.valueOf(1);
		if (2 * m > n)
			choose(n, n - m);
		for (int i = 1; i <= m; n--, i++) {
			r = (r.multiply(java.math.BigInteger.valueOf(n))).divide(java.math.BigInteger
					.valueOf(i));
		}
		return (r);
	}

	public static long calcuCombination(int n, int a) {

		// if(a>n/2)return calcuCombination(n,n-a);

		long sum = 1;
		int j = a;
		int i = n;
		for (i = n, j = a; i > n - a; i--, j--) {
			if (j < 2) {
				j = 1;
			}
			sum = sum * i / j;

		}

		if (sum < 0)
			System.out.println("Alert");
		if (j >= 2)
			for (i = 2; i <= j; i++) {
				sum = sum / i;
			}

		return sum;

	}

	public static long factorial(long n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		else
			return n * factorial(n - 1);
	}

}
