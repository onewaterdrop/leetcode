package real.interview.google;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PrintRelation {

	/**
	 * @param args
	 */
	
	private static LinkedList<Relation> list = new LinkedList<Relation>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Relation> input = new ArrayList<Relation>();
		input.add(new Relation("animal","mammal"));
		input.add(new Relation("animal","bird"));
		input.add(new Relation("lifeform","animal"));
		input.add(new Relation("cat","lion"));
		input.add(new Relation("mammal","cat"));
		input.add(new Relation("animal","fish"));
		
		PrintRelation t = new PrintRelation();
		t.printTree(input);

		
		
	}
	
	
	
	public  void printTree(Iterable<Relation> it ){
		
		sort(it);
		int i=1;
		for(Relation x : list){
			System.out.println(i+ x.parent);
			i++;
		}
		System.out.println(i+ list.getLast().child);

		
		
	}
	
	 void sort(Iterable<Relation> it){
		Iterator<Relation> itr = it.iterator();
		while(itr.hasNext()){
			Relation r = itr.next();
			add(list,r);
		}
		
	}
	
	public void add(LinkedList<Relation> list,Relation r){
		int i = getNodePosition(list,r);
		list.add(i,r);
		
	}
	
	private int getNodePosition(LinkedList<Relation> list2, Relation r) {
		// TODO Auto-generated method stub
		if(list2.size() ==0) return 0;
		if(r.child.equals(list2.get(0).parent))return 0;
		else{
			for(int i=0;i<list2.size();i++){
				if(list2.get(i).child == r.parent)return i+1;
			}
		}
		return list2.size();
	}

	public static class Relation{
		
		public Relation(String parent, String child) {
			super();
			this.parent = parent;
			this.child = child;
		}
		
		String parent;
		String child;
		
	}

}
