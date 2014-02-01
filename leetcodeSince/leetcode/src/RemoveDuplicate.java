import java.util.LinkedList;


public class RemoveDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

        java.util.Deque<Character> stk3= new LinkedList(java.util.Arrays.asList(new char[]{'1','2'}));
//		System.out.println(removeDuplicates(new int[]{1}));
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(4);
		n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;n5.next=n6;
		
		
		ListNode x = new RemoveDuplicate().deleteDuplicates(n1);
		while(x!=null){
			System.out.println("\t" + x.val);
		}
		
		
	}
	
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return null;
        if(head!=null && head.next==null)return head;
        if(head.next.val==head.val)return dealWithHeadDuplicate(head);
        
        ListNode runner1=head,runner2 = head.next;
        ListNode pre = runner1;
        while(runner2!=null){

            if(runner1.val==runner2.val){
                while(runner2!=null&&runner1.val==runner2.val){
                    runner2=runner2.next;
                }
                if(runner2==null){pre.next=null; return head;}
                else if(runner2.val !=runner1.val){
                    pre.next = runner2;
                    runner1=runner2;
                }

                
            }
            
        	pre=runner1;
            runner1=runner1.next;
            runner2=runner1.next;

            	
            	

            
        }
        
        return head;
        
        
        
    }
    
    
    public ListNode dealWithHeadDuplicate(ListNode head) {
        ListNode runner1=head,runner2 = head.next;
        
        while(runner1.val==runner2.val){
            runner2=runner2.next;
            if(runner2==null)break;
        }
        
        if(runner2==null)return null;
        
        return deleteDuplicates(runner2);
        
        
    }
	
	   public static int removeDuplicates(int[] A) {
	        
	        java.util.Map<Integer,Integer> m = new java.util.TreeMap<Integer,Integer>();
	        for(int i=A.length-1;i>=0;i--){
	            if(m.containsKey(A[i])){
	                m.put(A[i],m.get(A[i])+1);
	            }else{
	                m.put(A[i],1);
	            }
	        }
	        
	        int count=0;
	        
	        java.util.List<Integer> l = new java.util.LinkedList<Integer>();
	        
	        System.out.println(m.keySet());
	        for(Integer a:m.keySet()){
	            if(m.get(a)>=2){
	                count+=2;
	                l.add(a);
	                l.add(a);
	            }else{
	                count+=1;
	                l.add(a);
	            }

	            System.out.println(a);
	        }
	        
	        for(int i=0;i<l.size();i++){
	            A[i]=l.get(i);
	        }
	        
	        return count;
	    }

}
