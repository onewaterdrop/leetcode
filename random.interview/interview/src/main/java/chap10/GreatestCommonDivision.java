package chap10;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.*;


public class GreatestCommonDivision {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(getGCD(60,100));
		System.out.println(getGCDEuclidean(60,100));
	}
	
	static int getGCD(int a, int b){
		int x=1;
		if(a<b){a=a^b;b=a^b;a=a^b;}
		System.out.println("a="+a);
		System.out.println("b="+b);
		if(a>=b){
		List<Integer> A = Refactorial.getfactors(a);
		System.out.println(Arrays.toString(A.toArray()));
		List<Integer> B = Refactorial.getfactors(b);
		System.out.println(Arrays.toString(B.toArray()));
		
		List<Integer> C= Intersection(B,A);
		
		System.out.println(Arrays.toString(A.toArray()));

			for(Integer i:C){
				x*=i;
			}
		}
		
		return x;
	}

	private static List<Integer> Intersection(List<Integer> a, List<Integer> b) {
		// TODO Auto-generated method stub
		List<Integer> C = new ArrayList<Integer>();
		for(Integer i:a){
			if(b.contains(i)){
				C.add(i);
			}
		}
		return C;
	}
	
	
	static int getGCDEuclidean(int a,int b){
		if(a<b){a=a^b;b=a^b;a=a^b;};
		int x=1;
		while(a%b!=0){
			x=b;
			b=a%b;
			a=x;
			
		}
		
		return b;
	}
	
	static int getGCD2(int a,int b){
		if(a<b){a=a^b;b=a^b;a=a^b;};
		if(a%b==0)return b;
		else return getGCD2(b,a%b);
	}
	
	@Test
	public void test_gcd2(){
		
		assertTrue(5==getGCD2(5,25));
		assertTrue(4==getGCD2(4,12));
		assertTrue(5==getGCD2(25,5));
		assertTrue(1==getGCD2(13,10));
		
	}

}
