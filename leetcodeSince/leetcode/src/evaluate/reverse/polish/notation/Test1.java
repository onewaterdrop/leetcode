package evaluate.reverse.polish.notation;

import java.util.Arrays;

/**
 * 
 * @author youk
 *
 */

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String[] tokens = {"2","1","+","3","*"};
		
		String[] tokens ={"0","3","/"};
		
//		String[] tokens={"4", "13", "5", "/", "+"};
		
		java.util.Deque<String> stack = new java.util.LinkedList<String>(Arrays.asList(tokens));
		
		
		
		int result=0;
		result = new Test1().evalRPN(tokens);
		System.out.println("result="+ result);
		
		
	}
	
	
	
    public int evalRPN(String[] tokens) {
        
        
        java.util.Deque<String> s = new java.util.LinkedList<String>(java.util.Arrays.asList(tokens));
        java.util.Deque<Integer> t2 = new java.util.LinkedList<Integer>();
		
		
		while(s.size()>0){
			
			if("*".equals(s.peek())){
				
				s.pop();
				if(t2.size()>1){
					t2.push(t2.pop()*t2.pop());
				}else{
					return Integer.MAX_VALUE;
				}
					
				
			}else if("-".equals(s.peek())){
				s.pop();
				if(t2.size()>1){
					int secIn =t2.pop();
					int firstIn = t2.pop();
					t2.push(firstIn-secIn);
				}else{
					return Integer.MAX_VALUE;
				}
				
			}else if("+".equals(s.peek())){
				s.pop();
				if(t2.size()>1){
					t2.push(t2.pop()+t2.pop());
				}else{
					return Integer.MAX_VALUE;
				}
				
			}else if("/".equals(s.peek())){
				s.pop();
				if(t2.size()>1){
					int secIn =t2.pop();
					
					System.out.println(secIn);
					
					int firstIn = t2.pop();
					
					System.out.println(firstIn);
					
					int result = firstIn/secIn;
					
					System.out.println("res = "+result);
					t2.push(result);
				}else{
				    return Integer.MAX_VALUE;
				}
				
			}else{
				t2.push(Integer.parseInt(s.pop()));
				System.out.println("pushed in=" + t2.peek());
			}
			
		}
		
		System.out.println("t2 size" + t2.size());
		
		if(t2.size()==1){
			int result = t2.pop();
			System.out.println("returning "+ result);
			return result;
			
		}else{
			
			System.out.println(Integer.MAX_VALUE);
			return Integer.MAX_VALUE;
		}

		
	}
	

}
