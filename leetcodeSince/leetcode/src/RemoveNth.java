import java.util.List;



public class RemoveNth {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(7);
		n1.next =n2;
	//	removeNthFromEnd(n1,2);
		List l;
	//	sortList(n1); 
		String a;
		
		ListNode n3 = new ListNode(9);
		ListNode n4 = new ListNode(2);
		n3.next=n4;
		ListNode ret = new RemoveNth().addTwoNumbers(n1, n3);
		
		for(;ret!=null;ret=ret.next){
			System.out.println("\t" + ret.val);
		}
		

	}
	
    public static ListNode sortList(ListNode head) {
        if(head==null || head.next==null)return head;
        else{
            ListNode rest = sortList(head.next);
            if(rest ==null)return head;
            
            if(head.val<=rest.val){head.next=rest;return head;}
            
            ListNode tmp=null;
            ListNode n=null;
            for( n=rest;n!=null;tmp=n,n=n.next){
                if(head.val<=n.val)break;
            }
            
            if(n==null){
                tmp.next=head;
                head.next =null;
                return rest;
            }else{
                tmp.next = head;
                head.next =n;
                return rest;
            }
            
            
        }
        
        
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode runner1=head,runner2=head;
        
        for(int i=0;i<n;i++) runner2=runner2.next;

        if(runner2==null)return head.next;
        
        while(runner2.next !=null){
            runner2=runner2.next;
            runner1=runner1.next;
        }
        
        runner1.next=runner1.next.next;
        
        return head;
        
    }
    
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 ==null)return l2;
        if(l2 ==null)return l1;
        
        boolean carryover =false;
        ListNode tmp = new ListNode(0) ;
        ListNode head=tmp;
        while(l1 != null && l2 !=null){
            if(carryover==false){
               tmp.next = new ListNode( (l1.val+l2.val) %10);
               if(l1.val+l2.val>=10)carryover=true;
            }else{
               tmp.next = new ListNode( (l1.val+l2.val+1) %10); 
               if(l1.val+l2.val+1>=10)carryover=true;
            }
            
            
            
            tmp= tmp.next;
            l1=l1.next;
            l2=l2.next;
            
        }
        
        System.out.println(carryover);
            
        while(l1!=null){
             if(carryover==false){
               tmp.next = new ListNode( (l1.val) %10);
            }else{
               tmp.next = new ListNode( (l1.val+1) %10); 
               carryover=false;
            }
            if(l1.val+1>=10)carryover=true;
            
            tmp= tmp.next;
            l1=l1.next;
            
        }
        while(l2!=null){
             if(carryover==false){
               tmp.next = new ListNode( (l2.val) %10);
            }else{
               tmp.next = new ListNode( (l2.val+1)%10); 
               carryover=false;
            }
            if(l2.val+1>=10)carryover=true;
            
            tmp= tmp.next;
            l2=l2.next;
        }
        
      //  System.out.println(carryover);
         if(carryover){
            tmp.next = new ListNode(1);
            tmp=tmp.next;
            }
        
        return head.next;
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