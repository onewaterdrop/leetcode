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
		
		String[] tokens = {"2","1","+","3","*"};
		
//		String[] tokens={"4", "13", "5", "/", "+"};
		
		java.util.Deque<String> stack = new java.util.LinkedList<String>(Arrays.asList(tokens));
		
		
		
		int result=0;
		try {
			result = new Test1().evalRPN(tokens);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("result="+ result);
		
		
	}
	
	
	
    public int evalRPN(String[] tokens) {
        
        java.util.Deque<String> s = new java.util.LinkedList<String>(java.util.Arrays.asList(tokens));
		java.util.Deque<Integer> t2 = new java.util.LinkedList<Integer>();
		
		
		while(s.size()>0){
			
			if("*".equals(s.peek())){

				System.out.println("current oprand is=" + s.pop());
				if(t2.size()>1){
					t2.push(t2.pop()*t2.pop());
				}else{
					return Integer.MAX_VALUE;
				}
					
				
			}else if("-".equals(s.peek())){

				System.out.println("current oprand is=" + s.pop());
				if(t2.size()>1){
					int secIn =t2.pop();
					int firstIn = t2.pop();
					t2.push(firstIn-secIn);
				}else{
					return Integer.MAX_VALUE;
				}
				
			}else if("+".equals(s.peek())){

				System.out.println("current oprand is=" + s.pop());
				if(t2.size()>1){
					t2.push(t2.pop()+t2.pop());
				}else{
					return Integer.MAX_VALUE;
				}
				
			}else if("/".equals(s.peek())){

				System.out.println("current oprand is=" + s.pop());
				if(t2.size()>1){
					int secIn =t2.pop();
					int firstIn = t2.pop();
					t2.push(firstIn/secIn);
				}else{
					return Integer.MAX_VALUE;
				}
				
			}else{
				t2.push(Integer.parseInt(s.pop()));
			}
			
		}
		
		if(t2.size()>1){
			return Integer.MAX_VALUE;
		}else if(t2.size()==1){
			return t2.pop();
		}else{
			return Integer.MAX_VALUE;
		}

		
		
		
	}
	

}
