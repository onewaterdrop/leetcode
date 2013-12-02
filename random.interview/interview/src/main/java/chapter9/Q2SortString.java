package chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;


public class Q2SortString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String x="a223";
//		String y="a22";
//		System.out.println(x.compareTo(y));
//		
		String[] Array = {"123","12","321","231","1","2","3"};
		

		
		Q2SortString q = new Q2SortString();
		
		AnagramSort as = new AnagramSort();
		
		Arrays.sort(Array, as);
		
		List<String> ml = Arrays.asList(Array);
//		ml=q.sortWithAnagrams(ml);
		
		System.out.println("########################");
		printList(ml);
		

	}


	private static void printList(List<String> ml) {
		for(String s:ml){
			System.out.println(s);
		}
	}
	
	
	List<String> sortWithAnagrams(List<String> ls){
		
		
//		Collections.sort(ls);	
//		printList(ls);
		
		List<String> lc= new ArrayList<String>();
		
		
		for(String l:ls){
			char[] array = l.toCharArray();
			Arrays.sort(array);
			lc.add(new String(array));
		}
		
		
		for(String l1:lc){
			for(String l2:lc){
				if(l1.compareTo(l2)>0){
					swap(ls,lc.indexOf(l1),lc.indexOf(l2));
				}
				
				
			}
			
			
		}
		
		
		
		
		return ls;
		
	}
	
	private void swap(List<String> ls, int indexOf, int indexOf2) {
		// TODO Auto-generated method stub
		String temp=ls.get(indexOf);
		String s2= ls.get(indexOf2);
		ls.set(indexOf, s2);
		ls.set(indexOf2,temp);
	}


	@Before
	void setup(){
		
	}
	
	
	static class AnagramSort implements Comparator<String>{
		
		String sortString(String s){
			char[] array = s.toCharArray();
			Arrays.sort(array);
			return new String(array);
		}
		

		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return sortString(o1).compareTo(sortString(o2));
		}
		
	}
	
	
	
	

}
