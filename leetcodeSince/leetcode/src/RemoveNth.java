import java.util.List;



public class RemoveNth {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n1.next =n2;
		removeNthFromEnd(n1,2);
		List l;
		sortList(n1); 
		String a;
		

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
}
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}