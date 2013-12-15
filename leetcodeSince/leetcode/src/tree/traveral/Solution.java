package tree.traveral;

import java.util.ArrayList;
import java.util.Arrays;

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
    
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
    	
    	java.util.ArrayList<Integer> L = new ArrayList<Integer>();
    	
    	if(root ==null)return L;
    	
    	java.util.Deque<TreeNode> s = new java.util.LinkedList<TreeNode>();
    	java.util.Deque<TreeNode> out = new java.util.LinkedList<TreeNode>();

    	s.push(root);	
    	while(!s.isEmpty()){
        	TreeNode cur = s.peek();
        	out.push(cur);
        	L.add(cur.val);
        	s.pop();
        	if(cur.right!=null)s.push(cur.right);
        	if(cur.left!=null)s.push(cur.left);
    	}
    	
    	return L;
    	
    }
    
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
    	
    	java.util.ArrayList<Integer> L = new ArrayList<Integer>();
    	
    	if(root ==null)return L;
    	
    	java.util.Deque<TreeNode> s = new java.util.LinkedList<TreeNode>();
    	TreeNode cur = root;	
    	while(true){
 	
        	if(cur!=null){
        		s.push(cur);
            	cur=cur.left;
        	}else{
        		if(s.isEmpty())break;
                cur = s.pop();
        		
                L.add(cur.val);
                
                cur = cur.right;
        		
        	}
    	}
    	
    	return L;
        	
    }
    public ArrayList<Integer> inorderTraversal2(TreeNode root) {
    	
    	java.util.ArrayList<Integer> L = new ArrayList<Integer>();
    	
    	java.util.Deque<TreeNode> s = new java.util.LinkedList<TreeNode>();
    	TreeNode cur = root;	
    	while(!s.isEmpty() || cur !=null){
    		
    		if(cur!=null){
    			s.push(cur);
    			cur=cur.left;
    		}else{
    			cur = s.pop();
    			
    			L.add(cur.val);
    			
    			cur = cur.right;
    			
    		}
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
		java.util.ArrayList<Integer> L1 = sol.preorderTraversal(node1) ;
    	System.out.println(L.toString());
    	System.out.println(L1.toString());
    	
    	System.out.println("max deepth=" + sol.maxDepth(node1));
    	
    	
    	sortedArrayToBST(new int[]{-1,0,1,2});
    	
 }
    
    
    
    
    public static int searchInsert(int[] A, int target) {
        if(A.length<=0)return 0;
        if(A[0]>target) return 0;
        if(A[A.length-1]<target) return A.length;
        for(int i=0;i<A.length;i++){
            if(A[i]>=target) return i;
        }
        
		return 0;
        
        
    }
    
    public static TreeNode sortedArrayToBST(int[] num) {
        if(num.length==0)return null;
        int rootIndex = num.length/2;
        
        System.out.println("Array is" + Arrays.toString(num));
        
//        if(num.length==1)return new TreeNode(num[0]);
        
        TreeNode root = new TreeNode(num[rootIndex]);
//        if(rootIndex-1==0){
//            root.left =  new TreeNode(num[0]);
//        }else 
        	
        if(rootIndex-1>=0){
        	
            int[] left = Arrays.copyOfRange(num, 0, rootIndex);
            
            System.out.println("Array is" + Arrays.toString(left));
            
            root.left =  sortedArrayToBST(left);
        }
//        if(rootIndex+1==num.length-1){
//            root.right = new TreeNode(num[num.length-1]);
//        }else 
//        	
        if(rootIndex+1<=num.length-1){
            int[] right = Arrays.copyOfRange(num, rootIndex+1, num.length);
            
            System.out.println("Array is" + Arrays.toString(right));
            root.right = sortedArrayToBST(right);
        }
        return root;
        
    }
    
    
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        
        ArrayList<ArrayList<TreeNode>>  l = new ArrayList<ArrayList<TreeNode>>();
        ArrayList<ArrayList<Integer>>  ret = new ArrayList<ArrayList<Integer>>();    
        ArrayList<ArrayList<Integer>>  retReverse = new ArrayList<ArrayList<Integer>>();  
        java.util.Deque<TreeNode>  stack = new java.util.LinkedList<TreeNode>();
        if(root==null) return ret;
        
        l.add(new ArrayList<TreeNode>(java.util.Arrays.asList(new TreeNode[]{root})));
        int i=0;

        while(!reachingEnd(l.get(i))){
            ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
            for(TreeNode t:l.get(i)){
                if(t.left !=null) temp.add(t.left);
                if(t.right !=null) temp.add(t.right);
                }
                
            l.add(temp);
            i++;
        
        }
        
        
        for(ArrayList<TreeNode> x:l){
            ArrayList<Integer> temp1 = new ArrayList<Integer>();
            for(TreeNode y:x){
                temp1.add(y.val);
            }
            
            ret.add(temp1);
        }
        
        
        for(i=ret.size()-1;i>=0;i++)retReverse.add(ret.get(i));
        return retReverse;
        
    }
    
    public boolean reachingEnd(ArrayList<TreeNode> nodes){
        for(TreeNode t:nodes){
            if(t.right !=null || t.left !=null) return false;
        }
        
        return true;
        
    }

    
}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
