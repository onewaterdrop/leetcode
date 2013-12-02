package chap2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class NthToLast {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<Integer>();
		Random r = new Random();
		
		System.out.println(r.nextBoolean());
		System.out.println(r.nextInt());
		System.out.println(Math.random());
		

	}
	
	static LinkedListNode head;
	
	public static LinkedListNode getNthToLast(LinkedListNode head,int n){
//		if(n==1)return getLast(head);
		int cnt = cntToLast(head);
		if(n>cnt) return null;
		if(n==cnt) return head;
		else{
			return getNthToLast(head.next,n);
		}
//		if(n==getNthToLast(head,n))return head;
		
//		if(n>1)return getNthToLast(n-1);
		
	}
	
	
	@Test
	public void test_getNthToLast(){
		LinkedListNode head = new LinkedListNode() ;
		head.data=1;
		LinkedListNode p = head;
		for(int i=2;i<10;i++){
			LinkedListNode node = new LinkedListNode() ;
			node.data = i;
			p.next = node;
			p=p.next;
		}
		
		p.next=null;
		
		LinkedListNode n = getNthToLast(head,3);
		assertTrue(7==n.data);
		
		
		
	}

	public static int cntToLast(LinkedListNode head2) {
		// TODO Auto-generated method stub
		int cnt =1;
		if(head2==null)return -1;
		if(head2.next==null)return 1;
		else
		{
			while(head2.next!=null){
				head2 = head2.next;
				cnt++;
			}
			
		}
		
		return cnt++;
	}

	private static LinkedListNode getLast(LinkedListNode head2) {
		// TODO Auto-generated method stub
		if(head2==null)return null;
		while(head2.next!=null){
			head2 = head2.next;
		}
		return head;
	}
	
	
	@Test
	public void test_cnt_ToLast(){
		LinkedListNode head = new LinkedListNode() ;
		head.data=1;
		head.next= new LinkedListNode() ;
		head.next.data=2;
		head.next.next=new LinkedListNode() ;
		head.next.next.data=3;
		head.next.next.next=null;
		
		assertTrue(3==cntToLast(head));
		
		
		
	}
	

}