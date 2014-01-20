import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class ZigzagLevelOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		
		t1.right=t2;
		t1.left=t3;
		t2.left=t4;
		t2.right=t5;
		t3.right=t6;
		t4.left=t7;
		t5.right=t8;
		
		ZigzagLevelOrder z =new  ZigzagLevelOrder();
		
		System.out.println(z.zigzagLevelOrder(t1));
		
		int x1=0xF;
		int x2=010;
		int x3=-0x0;
		;
		
		
	}
	
	    public ArrayList<Integer> zigzagLevelOrder(TreeNode root) {
//	        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
	        Queue<TreeNode> Q = new LinkedList<TreeNode>();
            ArrayList<Integer> r = new ArrayList<Integer>();
	        boolean swit =true;
	        Q.add(root);
	        while(!Q.isEmpty()){
	            TreeNode temp = Q.remove();
	            r.add(temp.val);
	            
	            if(swit){
	                if(temp.right!=null)Q.add(temp.right);
	                if(temp.left !=null)Q.add(temp.left); 
	                swit= !swit;
	            }else{
	                if(temp.left!=null)Q.add(temp.left);
	                if(temp.right!=null)Q.add(temp.right); 
	                swit= !swit;
	            }
	        }
	        
			return r;
	        
	    }

}
