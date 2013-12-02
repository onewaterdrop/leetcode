package chap10;
import java.util.*;

public class Refactorial {
	
	public static void main(String[] args) {
//		System.out.println(15%4);
		
		System.out.println(Arrays.toString(getfactors(60).toArray()));
		
	}

	static List<Integer> getfactors(int a){
		
		List<Integer> l = new ArrayList<Integer>();
		double prime = java.lang.Math.sqrt(a);
		for(int i=2;i<prime;i++){
			while(a%i==0){
				l.add(i);
				a=a/i;
			}
			
		}
		
		return l;
		
	}
	
}
