import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


public class MergeIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("123".substring(0,1));
		
		Set<Character> s = new HashSet(Arrays.asList(new Character[]{'1'}));
		Span s1 = new Span(2,3);
		Span s2 = new Span(2,6);
		Span s3 = new Span(5,5);
		Span s4 = new Span(1,2);
		Span s5 = new Span(10,12);
		
		LinkedList<Span> intervals = new LinkedList<Span>();
		intervals.add(s1);
		intervals.add(s2);
		intervals.add(s3);
		intervals.add(s4);
		intervals.add(s5);
		intervals.add(new Span(99,6));
//		intervals.add(new Span(-1,12));
		
		
		System.out.println(new MergeIntervals().merge(intervals));
		

	}
	
	LinkedList<Span> merge(LinkedList<Span> intervals){
		if(intervals ==null)return null;
		if(intervals.size()==1)return intervals;
		
		Collections.sort(intervals, new Comparator<Span>(){

			@Override
			public int compare(Span o1, Span o2) {
				// TODO Auto-generated method stub
				return o1.x - o2.x;
			}
			
		});
		
		
		int i=0;
		while(i<intervals.size()-1){
//			int curI=i;
			if(intervals.get(i).y>=intervals.get(i+1).x){
				intervals.get(i).y=Math.max(intervals.get(i).y, intervals.get(i+1).y);
				intervals.remove(i+1);
			}else{
				i++;
			}
		//	if(curI ==i)break;
		}
		
		return intervals;
	}
	
	

}

class Span {
	int x;
	int y;
	Span(int x, int y){
		if(x<=y){
			this.x=x;
			this.y=y;
		}
	}
	
	public String toString(){
		return "["+x + "," + y +"]";
	}
	
}