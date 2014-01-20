
public class BSTCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTCheck b = new BSTCheck();
		
		TreeNode t1 = new TreeNode(0);
		TreeNode t2 = new TreeNode(-1);
		t1.left=t2;
		System.out.println(b.isValidBST(t1));
	}
	
    static Integer last =Integer.MIN_VALUE;
    
    public boolean isValidBST(TreeNode root) {
        if(root==null)return true;
        if(!isValidBST(root.left))return false;
        if(root.val <= last) return false;
        
        last = root.val;
        
        if(!isValidBST(root.right))return false;

        return true;
        
    }

}
