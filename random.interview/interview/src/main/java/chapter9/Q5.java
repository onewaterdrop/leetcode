package chapter9;

import java.util.Arrays;
import java.util.List;

public class Q5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] array ={"at","","","","ball","","","car"};
		
		
		System.out.println(find(array,"ball1"));
		
		
	}
	
	static int find(String[] array,String s){
		List<String> l = Arrays.asList(array);
		
		return l.indexOf(s);
	}

}
