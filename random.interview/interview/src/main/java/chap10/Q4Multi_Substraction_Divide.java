package chap10;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class Q4Multi_Substraction_Divide {

	Q4Multi_Substraction_Divide q4;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 
		
	}
	
	@Before
	public void prepare(){
		q4 = new Q4Multi_Substraction_Divide();
	}
	
	
	@Test
	public void test_add(){
		
		assertTrue(add(4,7)==11);
		
	}
	
	public int add(int a, int b){
		
		return a+b;
	}
	
	@Test
	public void test_m(){
		
		assertTrue(multiply(4,-7)==-28);
		
	}
	
	public int multiply(int a, int b){
		if(b==0)return 0;
		int sign = 1;
		if(b<0){
			sign =-1;
			b=-b;
		}
		
		int product=0;
		for(int i=1;i<=b;i++){
			product+=a;
		}
		if(sign==-1)return -product;
		
		return product;
	}
	
	
	@Test(expected = Exception.class)
	public void test_divide_divisor_0() throws Exception{
		
		divide(8,0);
		
	}
	
	@Test
	public void test_divide() throws Exception{
		
		assertTrue(divide(16,-2)==-8);
		
	}
	
	public int divide(int a, int b) throws Exception{
		
		if(b==0) throw new Exception("Divisor is zero");
		boolean sign = diffSign(a,b);
		
		a=a>0?a:-a;
		b=b>0?b:-b;
		
		int cnt=0;
		if(a<b)return 0;
		
		while(a>=b){
			a=substract(a,b);
			cnt=add(cnt,1);
		}
		
		if(sign==true)return -cnt;
		return cnt;
		
	}
	
	
	private boolean diffSign(int a, int b) {
		// TODO Auto-generated method stub
		if(a>0 && b<0) return true;
		if(a<0 && b>0) return true;		
		return false;
	}

	@Test
	public void test_substract(){
		
		assertTrue(substract(4,7)==-3);
		
	}
	
	public int substract(int a, int b){
		
		return add(a,~b+1);
	}
	
	

}
