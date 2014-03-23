import java.util.*;
import java.util.Map.Entry;
public class GroupAnagram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = {"hello", "helol", "hi", "abc", "cab", "cba"};
		System.out.println(new GroupAnagram().getResults(arr));
		System.out.println(new GroupAnagram().anagrams(arr));
		
	}
	
	// ["hello", "helol", "hi", "abc", "cab", "cba"]
	// --> [["hello", "helol"], ["abc", "cba", "cab"], ["hi"]]


	// ["hi", "abc", "cab", "cba","hello", "helol"]
	//take a 

	public Map<String,ArrayList<String>>  getResults(String[] arr){
	    Map<String,ArrayList<String>>  ret = new HashMap<String,ArrayList<String>>();
	    
	    // O(nlgn)
	    Arrays.sort(arr,new Comparator<String>(){
//	      public int compare(Object s1,Object s2){
//	    	   String s11 = (String)s1;
//	    	   String s22 = (String)s2;
//	           return s11.length() - s22.length();
//	        }

		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return o1.length() - o2.length();
		}
	    });
	    
	    
	    LinkedList<String> l = new LinkedList<String>(Arrays.asList(arr));
	    
	    int len = arr.length;
	    int i=0;
	    //O(n^2)
	    while(i<len){
	        ArrayList<String> temp = new ArrayList<String>();
	        temp.add(l.get(i));
	        for(int j=i+1;j<len;){   //O(n)
	            if(checkInstagram(l.get(j),l.get(i))){
	                temp.add(l.get(j));
	                l.remove(j);
	                len--;
	            }else{
	            	j++;
	            }
	        }
	    //    System.out.println(temp);
	        ret.put(l.get(i),temp);
	        i++;
	        
	    }
	    
	    return ret;

	}
	//m
	//O(m)
	public boolean checkInstagram(String s1, String s2){
	    if(s1.length()!=s2.length()) return false;
	    
	    
	    Map<Character,Integer> m1= createM(s1);
	    Map<Character,Integer> m2= createM(s2);
	    
	    
	   return m1.toString().equals(m2.toString());
	   
	}

	public Map<Character,Integer> createM(String s){
	   Map<Character,Integer> m1 = new HashMap<Character,Integer>();
	       char[] arr = s.toCharArray();
	       for(int i=0;i<arr.length;i++){
	          if(m1.containsKey(arr[i])){
	             m1.put(arr[i],m1.get(arr[i])+1);
	          }else{
	            m1.put(arr[i],1);
	          }
	       }
	       
	   return m1;
	   
	}
	
	
    public Map<String,ArrayList<String>> anagrams(String[] strs) {
    	Map<String,ArrayList<String>> m = new HashMap<String,ArrayList<String>>();
    	
        for(String s:strs){
        	String sorted = sortedString(s);
        	if(m.containsKey(sorted)){
                m.get(sorted).add(s);
        	}else{
        		ArrayList<String> a=new ArrayList<String>();
        		a.add(s);
        		m.put(sorted,a);
        	}

        }
        
        return m;
        
    }
	
    private String sortedString(String s2) {
		
    	char[] arr = s2.toCharArray();
    	Arrays.sort(arr);
    	
		return new String(arr);
	}

}
