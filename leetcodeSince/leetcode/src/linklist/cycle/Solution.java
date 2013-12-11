package linklist.cycle;

public class Solution {

	/**
	 * @param args
	 * 
	 *  Given a linked list, determine if it has a cycle in it.
	 *  Follow up: Can you solve it without using extra space? 
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		

		
		assert hasCycle(node1) ==false;
		System.out.println(hasCycle(node1) );
		
	}

	public static boolean hasCycle2(ListNode head) {

		if(head ==null) return false;
		else if(head.next==null) return false ;
		else if(head.next !=null && head.next == head) return true;
		else{
		   
			ListNode step2=head.next.next, step1=head.next;
			
			while(step2!=null || step1 ==null){
				
				if(step1 == step2) return true;
				else{
					if(step1 !=null)step1 = step1.next;
					if(step2 !=null && step2.next !=null)step2 = step2.next.next;
					else{
						return false;
					}
				}
	
				
			}
			
		}
		
		
		return false;

	}
	
	
	public static boolean hasCycle3(ListNode head) {
		
		if(head ==null) return false;
		else{
			
			ListNode  step1=head.next, step2;
			if(step1 !=null){step2=head.next.next;}
			else {
				return false;
			}
			
			while(step2!=null && step1 !=null){
				
				if(step1 == step2) return true;
				else{
					if(step1 !=null)step1 = step1.next;
					if(step2 !=null && step2.next !=null)step2 = step2.next.next;
					else{
						return false;
					}
				}
				
				
			}
			
		}
		
		
		return false;
		
	}
	public static boolean hasCycle(ListNode head) {
		
		//without using extra space;
		
		while(head !=null && head.val !=Integer.MAX_VALUE){
			head.val = Integer.MAX_VALUE;
			head = head.next;
		}
		
		if(head ==null){
			return false;
		}else {
			return true;
		}
		
		
	}
	

}

	class ListNode {
		int val;
		ListNode next;
	
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

