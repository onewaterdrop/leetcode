package sorting;
import java.util.*;
public class LifeFormRelation {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(l);
	}
	
	static List<Relation> l = new ArrayList<Relation>();
	static{
		l.add(new Relation("mammal","cat"));
		l.add(new Relation("animal","mammal"));
		l.add(new Relation("animal","bird"));
		l.add(new Relation("cat","lion"));
		l.add(new Relation("lifeform","animal"));
		l.add(new Relation("animal","fish"));
//		l.add(new Relation("father","mom"));
		
	}
	
	static HashMap<String,List<String>> hm= new HashMap<String,List<String>>();
	
	static void print(List<Relation> input){
		
		String root = input.get(0).par;
		for(Relation r:input){
			if(r.chd.equals(root))root = r.par;
			if(hm.containsKey(r.par)){
				hm.get(r.par).add(r.chd);
			}else{
				List<String> x = new LinkedList<String>();
				x.add(r.chd);
				hm.put(r.par, x);
			}
			
		}
		for(Relation r:input){
			if(r.chd.equals(root))root = r.par;
		}
		
		System.out.println(hm);
		String space="";
		 printHM(hm,root,space);
		
	}

	private static void printHM(HashMap<String, List<String>> hm, String root,String space) {
		// TODO Auto-generated method stub
		if(hm.containsKey(root)){
			System.out.println(space+root);
			
			for(String s:hm.get(root)){
				if(!hm.containsKey(s))System.out.println(space+"\t"+s);
				else{
					printHM(hm,s,space+"\t");
				}
			}
		}
	}
	

}

class Relation{
	public Relation(String string, String string2) {
		this.chd=string2;
		this.par=string;
	}
	String par;
	String chd;
}
