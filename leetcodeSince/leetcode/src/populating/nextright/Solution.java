package populating.nextright;

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode n1 = new TreeLinkNode(1);
		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n3 = new TreeLinkNode(3);
		TreeLinkNode n4 = new TreeLinkNode(4);
		TreeLinkNode n5 = new TreeLinkNode(5);
		TreeLinkNode n6 = new TreeLinkNode(6);
		TreeLinkNode n7 = new TreeLinkNode(7);
		TreeLinkNode n8 = new TreeLinkNode(8);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;

		connect(n1);

	}

	public static void connect(TreeLinkNode root) {
		
		TreeLinkNode leftPart = root;
		while(leftPart != null){
			TreeLinkNode across = leftPart;
			while (across !=null) {
                if (across.left != null) {
                    across.left.next = across.right;
                }

                if (across.right != null && across.next != null) {
                    across.right.next = across.next.left;
                }

                across = across.next;
	
			}
			
			leftPart =leftPart.left;
		}

	}

	public static void levelorder(TreeLinkNode root) {
		java.util.Queue<TreeLinkNode> queue = new java.util.LinkedList<TreeLinkNode>();
		if (root != null)
			queue.add(root);

		while (!queue.isEmpty()) {
			TreeLinkNode cur = queue.remove();
			System.out.println("Data is " + cur.val);
			if (cur.left != null) {
				queue.add(cur.left);
				cur.left.next = cur.right;
			}
			if (cur.right != null) {
				queue.add(cur.right);

			}

		}

	}

}
