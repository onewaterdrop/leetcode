
public class RootToLeafNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int sumNumbers(TreeNode root) {
        Integer sum = new Integer(0);
        sumNumber(root,0,sum);
        return sum;
        
    }
    
    public void sumNumber(TreeNode root,int num,Integer sum){
        if(root ==null) return;
        num = num *10 + root.val;
        if(root.right==null && root.left==null){
        	sum+=num;
        }else{
            sumNumber(root.left,num,sum);
            sumNumber(root.right,num,sum);
        }
        
        num /= 10;
    }

}


 class TreeNode {
	 TreeNode left, right;
	 int val;
	 TreeNode(int x){
		 this.val=x;
	 }
 }