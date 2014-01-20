import java.util.Stack;


public class Parentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println(isValid("{}[]{}"));
		System.out.println(isValid("{}({})"));
		System.out.println(isValid("{([])}"));
		System.out.println(isValid("{(}])}"));
		System.out.println(isValid(")}{({))[{{[}"));
		
	}
	
    public static boolean isValid(String s) {
        char[] arr = s.toCharArray();
        
        Stack<Character> st =new java.util.Stack<Character>();
        for(char c:arr){
        	switch(c){
        	case '{':
        		st.push(c);
        		break;
        	case '(':
        		st.push(c);
        		break;
        	case '[':
        		st.push(c);
        		break;
        	case ']':
        		if(st.size()==0 ||st.peek() !='[')return false;
        		else st.pop();
        		break;
        	case '}':
        		if(st.size()==0 || st.peek() !='{')return false;
        		else st.pop();
        		break;
        	case ')':
        		if(st.size()==0 || st.peek() !='(')return false;
        		else st.pop();
        		break;
        	}
        }
        
        if(st.size()==0)return true;
        else return false;
    }

}
