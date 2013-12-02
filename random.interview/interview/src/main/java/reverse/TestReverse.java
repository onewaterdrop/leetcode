package reverse;

import org.apache.commons.lang.ArrayUtils;

public class TestReverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String inS= "Ren Fang is a fool!";
		StringBuilder sb= new StringBuilder(inS);
		sb.reverse();
		
		System.out.println("The reverse String=" + sb.toString());

		System.out.println("surogate string reverse="+ new StringBuilder("Tianyou").reverse().toString());
		
		System.out.println("The reverse String=" + reverseString(inS));

		char[] array =inS.toCharArray();
		reverse(array);
		System.out.println("My reverse String=" + String.valueOf(array));
		
	}
	
	
	
	public static String reverseString(String s){
		
		char[] array = s.toCharArray();
		ArrayUtils.reverse(array);
		
		
//		 return String.copyValueOf(array);
		 return String.valueOf(array);
		
		
	}
	
	public static void reverse(char[] array){
		if(array==null){
			return;
		}
		
		int i=0;
		int j=array.length-1;
		char temp=0;
		while(j>i){
			temp= array[j];
			array[j]=array[i];
			array[i]=temp;
			j--;
			i++;
		}
		
	}
	

}
