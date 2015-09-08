package real.interview.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class TreePrinter {
	
	
	
	
	static int lineNumber =1;
	public static class Relation{
		
		public Relation(String parent, String child) {
			super();
			this.parent = parent;
			this.child = child;
		}
		
		String parent;
		String child;
		
	}
	
	
	public static void main(String[] args) {
		
		
		List<Relation> input = new ArrayList<Relation>();
		input.add(new Relation("animal","mammal"));
		input.add(new Relation("animal","bird"));
		input.add(new Relation("lifeform","animal"));
		input.add(new Relation("cat","lion"));
		input.add(new Relation("mammal","cat"));
		input.add(new Relation("animal","fish"));
		
		TreeSet ts = new TreeSet();
		
		TreePrinter t = new TreePrinter();
		t.printTree4(input);
	}
	
	
	public void printTree4(Iterable<Relation> rs){
		List<Relation> l = new LinkedList<Relation>();
		for(Relation r:rs){
			l.add(r);
		}
		Collections.sort(l, new Comparator<Relation>(){

			public int compare(Relation o1, Relation o2) {
				// TODO Auto-generated method stub
				if(o1.child.equals(o2.parent))return -20;
				else if(o1.parent.equals(o2.parent))return o2.child.compareTo(o1.child);
				else{
					return 1;
				}
					
			}
			
		});
		
		specialPrint(l);
		
	}
	
	private void specialPrint(List<Relation> l) {
		// TODO Auto-generated method stub
		for(Relation r:l){
			System.out.println(r.parent+"->"+r.child);
		}
	}


	public void printTree3(Iterable<Relation> rs){
		Iterator<Relation> i =  rs.iterator();
		String root="";
		HashMap<String,List<String>> map = new HashMap<String,List<String>>();
		HashMap<String,String> parent = new HashMap<String,String>();
		
		for(Relation r:rs){
			
			parent.put(r.child, r.parent);
			root = r.parent;			
			
			if(map.containsKey(r.parent)){

				List<String> tmp = map.get(r.parent);
				tmp.add(r.child);
				if(!map.containsKey(r.child)){
					map.put(r.child, new LinkedList<String>() );
				}
				
			}else if(map.containsKey(r.child)){
				addRelationMap(map, r);
				
			}else{
				addRelationMap(map, r);
				map.put(r.child, new LinkedList<String>());
			}
			

		}
		
		while(parent.containsKey(root)){
			root = parent.get(root);
		}
		
		print(map,root);
	}


	private void addRelationMap(HashMap<String, List<String>> map, Relation r) {
		List<String> tmp =new LinkedList<String>();
		tmp.add(r.child);
		map.put(r.parent, tmp);
	}
	
	private void print(HashMap<String, List<String>> map, String root) {
		// TODO Auto-generated method stub
		System.out.println(lineNumber++ + " " + root);
		for(String str:map.get(root)){
			print(map,str);
		}
		
	}

	List<List<String>> lol = new LinkedList<List<String>>();
	
	public void printTree2(Iterable<Relation> rs){
		Iterator<Relation> i =  rs.iterator();
		while(i.hasNext()){
			add(i.next());
		}
		
		print(lol);
	}
	
	
	private void add(Relation r) {
		// TODO Auto-generated method stub

		if(lol.size() == 0 || !contains(lol,r.parent,r.child)){
			addNodeToEmptyList(r.parent);	
			addNodeToEmptyList(r.child);
		}else if(contains(lol,r.parent)){

			int x = indexOf(r.parent);

					if(x<lol.size()-1 && !lol.get(x+1).contains(r.child)){
							lol.get(x+1).add(r.child);
					}
					else{
						addNodeToEmptyList(r.child);
					}
			
		}else if(contains(lol,r.child)){

					int x = indexOf(r.child);
					List<String> l2 = new LinkedList<String>();		
					l2.add(r.parent);
					lol.add(x,l2);
		}

	}


	private void addNodeToEmptyList(String token) {
		List<String> l1 = new LinkedList<String>();
		l1.add(token);
		lol.add(l1);
	}

	private int indexOf(String token){
		Iterator<List<String>> it = lol.iterator();
		while(it.hasNext()){
			List<String> l = it.next();
			if(l.contains(token)) {
				return lol.indexOf(l);
			}
		}
		
		return -1;
	}

	private boolean contains(List<List<String>> lol2, String parent) {
		// TODO Auto-generated method stub
		for(List<String> l:lol2){
			if(l.contains(parent)) return true;
		}
		return false;
	}


	private boolean contains(List<List<String>> lol2, String parent,
			String child) {
		// TODO Auto-generated method stub
		for(List<String> l:lol2){
			if(l.contains(parent) || l.contains(child)) return true;
		}
		return false;
	}


	private void print(List<List<String>> lol2) {
		// TODO Auto-generated method stub
		
//		Stack<List<String>> s = new Stack<List<String>>();
//		s.add(lol2.get(0));
//		while(!s.isEmpty()){
//			List<String> tmp = s.pop();
//			System.out.println(lineNumber++ + " " + tmp.get(0));
//		}
		int max =3;
		
		for(int i=0;i<max;i++){
			for(List<String> l:lol2){
				if(l.size()>i)System.out.println(lineNumber++ + " " + l.get(i));
			}
		}

		
	}


	public void printTree(Iterable<Relation> rs){
		
		//build a tree like below with lifeform as root 
		//and do a traversal.
		//lifeform -- animal
		//animal -- mammal -- cat-- lion
		//animal -- bird
		//animal -- fish
		
		//use this set to keep track of children to find out 
		//which one is the root node.
		Set<String> setOfNotRootElements = new HashSet<String>();
		
		//build a tree using HashMap. You can also build the tree 
		//put a Map inside a Map, but this seems simpler.
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for(Relation r: rs){
			List<String> children =  new ArrayList<String>();
			if(map.containsKey(r.parent)){
				children = map.get(r.parent);
			}
			children.add(r.child);
			map.put(r.parent, children );
			
			//keeping track of children..
			setOfNotRootElements.add(r.child);
		}
		
		//find the root
		Set<String> diffSet = new HashSet<String>(map.keySet());
		diffSet.removeAll(setOfNotRootElements);
		String root = diffSet.iterator().next();
		
		//traverse the tree.
		printNode(root, map);
		
		//lifeform
		//animal
		//mammal
		//cat
		//lion
		//bird
		//fish
	}
	
	public void printNode(String parent, HashMap<String, List<String>> map){
		System.out.println(lineNumber++ + " " + parent);
		List<String> children = map.get(parent);
		if(children != null){
			for(String child: children){
				printNode(child, map);
			}
		}
	}
 
}
