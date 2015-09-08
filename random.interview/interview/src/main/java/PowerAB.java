
public class PowerAB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(power(-0.5,2));
		System.out.println(power(2,-2));
		System.out.println(power(2,2));
		System.out.println(power(2,0));
		System.out.println(power(12,34));
		System.out.println(power2(12,34));
		System.out.println(sqrt(34));

	}
	
	static double power(double a, int b){
		
		if(b==0)return 1.0d;
		double sum=1.0d;
		
		if(b>0){
			for(int i=0;i<b;i++){
				sum*=a;
			}
			return sum;
		}else{
			for(int i=0;i<-b;i++){
				sum*=a;
			}
			
			return 1.0/sum;
		}

	}
	
	static double power2(double a, int n){
		
		if(n==0)return 1.0;
		
		double half = power2(a,n/2);
		
		if(n%2==0){
			return half * half;
		}else{
			return half * half * a;
		}

	}
	
	// a >0;  0<n<1;
	
	static double root(double a, double n){
		
		if(n==0)return 1.0;
		
		double half = root(a,n/2);
		
		if(n%2==0){
			return half * half;
		}else{
			return half * half * a;
		}

	}
	
	static double sqrt(double a){
		assert a >0;
		double eps = 0.01;
		double ret =1.0;
		while(Math.abs(ret*ret-a)>eps){
			ret=0.5*(ret+a/ret);
		}
		
		return ret;
	}
	

}
