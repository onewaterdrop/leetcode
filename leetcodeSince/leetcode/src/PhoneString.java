
import java.util.*;
public class PhoneString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new PhoneString().letterCombinations("34543"));
		List<?> l = new LinkedList<Object>();

	}
    static Map<Character,Set<Character>> m = new HashMap<Character,Set<Character>>();
    static {
        m.put('1',null);
        m.put('2',new HashSet(Arrays.asList(new Character[]{'a','b','c'})));
        m.put('3',new HashSet(Arrays.asList(new Character[]{'d','e','f'})));        
        m.put('4',new HashSet(Arrays.asList(new Character[]{'g','h','i'})));
        m.put('5',new HashSet(Arrays.asList(new Character[]{'j','k','l'})));
        m.put('6',new HashSet(Arrays.asList(new Character[]{'m','n','o'})));
        m.put('7',new HashSet(Arrays.asList(new Character[]{'p','q','r','s'}))); 
        m.put('8',new HashSet(Arrays.asList(new Character[]{'t','u','v'})));   
        m.put('9',new HashSet(Arrays.asList(new Character[]{'w','x','y','z'})));        
    }
    
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> m1 = new ArrayList<String>();
        if(digits.length()==0){m1.add("");return m1;}
        
        Set<Character> s0 =m.get(digits.charAt(0));
        for(Character x:s0)
             for(String y:letterCombinations(digits.substring(1,digits.length())))
                 m1.add(""+x+y);
        return  m1;
    }

}
