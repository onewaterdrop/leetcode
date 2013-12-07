package postorder.traveral;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<Integer> postorderTraversal2(TreeNode root) {
        
    	java.util.ArrayList<Integer> L = new ArrayList<Integer>();
    	
    	if(root ==null)return L;
    	
    	L.addAll(postorderTraversal(root.left));
    	L.addAll(postorderTraversal(root.right));
    	L.add(root.val);
    	
    	return L;
    	
    }
    
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left>right?left+1:right+1;	
    	
    }
    
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	
        if(p==null && q ==null) return true;
        else if(p==null && q !=null || q==null && p !=null)return false;
        else if(p.val !=q.val ){
            return false;
        }else{
          boolean left = isSameTree(p.left,q.left) ;
          boolean right = isSameTree(p.right,q.right);
          if(!left)return false;
          if(!right)return false;
          
          return true;
    	}
    	
        
    }
    
    public int maxDepth2(TreeNode root) {
    	if(root == null)return 0;
    	TreeNode cur=root;
    	int i=0;
    	while(cur.left!=null){cur=cur.left; i++;}
    	
    	return 0;
    }
    
    public ArrayList<Integer> postorderTraversal3(TreeNode root) {
    	
    	java.util.ArrayList<Integer> L = new ArrayList<Integer>();
    	
    	if(root ==null)return L;
    	
    	java.util.Deque<TreeNode> s = new java.util.LinkedList<TreeNode>();

    	TreeNode pre = root;
    	s.push(root);
    	
    	
    	while(!s.isEmpty()){
        	TreeNode cur = s.peek();
        	if(pre !=null || ( pre.left ==cur || pre.right ==cur)){
        		if(cur.left !=null){
        			s.push(cur.left);
        		}else if(cur.right != null){
        			s.push(cur.right);
        		}

        	}else if(cur.left == pre ){
        		
        		if(cur.right != null){
        			s.push(cur.right);
        		}
        		
    		}else{
	    		L.add(cur.val);
	    		s.pop();
    		}
    	
        	pre = cur;
        		
    	}
    
    	
    	return L;
    	
    }
    
    
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
    	
    	java.util.ArrayList<Integer> L = new ArrayList<Integer>();
    	
    	if(root ==null)return L;
    	
    	java.util.Deque<TreeNode> s = new java.util.LinkedList<TreeNode>();
    	java.util.Deque<TreeNode> out = new java.util.LinkedList<TreeNode>();

    	s.push(root);	
    	while(!s.isEmpty()){
        	TreeNode cur = s.peek();
        	out.push(cur);
        	s.pop();
        	if(cur.left!=null)s.push(cur.left);
        	if(cur.right!=null)s.push(cur.right);	
    	}
    
    	while(!out.isEmpty()){
    		L.add(out.pop().val);
    	}
    	
    	return L;
    	
    }
    /**
     * @param args
     */
    /**
     * @param args
     */
    public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.left=node2;
		node1.right=node3;
		java.util.ArrayList<Integer> L = sol.postorderTraversal(node1) ;
    	System.out.println(L.toString());
    	
    	System.out.println("max deepth=" + sol.maxDepth(node1));
    	
    	
 }
}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
