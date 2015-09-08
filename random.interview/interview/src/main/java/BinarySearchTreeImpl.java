
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BinarySearchTreeImpl implements BinarySearchTree {

	public Node insert(Node node, int data) {
		// TODO Auto-generated method stub
		if(node==null){
			node= new Node(data);
		}else{
			if(data<=node.data)
				node.left=insert(node.left,data);
			else 
				node.right=insert(node.right,data);
		}
		return node;
	}
	
	public void preOrder(Node node) {
		Stack<Node> st = new Stack<Node>();
		ArrayList<Integer> st2 = new ArrayList<Integer>();		
		st.push(node);
		while(!st.isEmpty()){
			Node tmp = st.pop();
			st2.add(tmp.data);
			System.out.print("\t"+tmp.data);

			if(tmp.right!=null)st.push(tmp.right);
			if(tmp.left!=null)st.push(tmp.left);

			
		}
	}

	public void postOrder(Node node) {
		Stack<Node> st = new Stack<Node>();		
		Stack<Node> out = new Stack<Node>();		
		st.push(node);
		while(!st.isEmpty()){
			Node tmp =st.pop() ;
			out.push(tmp);
			if(tmp.left!=null)st.push(tmp.left);
			if(tmp.right!=null)st.push(tmp.right);

		}
		while(!out.isEmpty()){
			System.out.print("\t"+out.pop().data);
		}


	}
	
	public void postOrder2(Node node) {
		Stack<Node> st = new Stack<Node>();		
		Node lastVisited = null;
		Node cur = node;
		while(!st.isEmpty() || cur !=null){
			if(cur !=null){
				st.push(cur);
				cur =cur.left;
			}else{
				Node peekNode = st.peek();
				if(peekNode.right !=null && lastVisited !=peekNode.right){
					cur = peekNode.right;
				}else{
					System.out.print("\t"+peekNode.data);
					st.pop();
					lastVisited = peekNode;
				}
			}
		}


	}

	public void inOrder(Node node) {	
		Stack<Node> st = new Stack<Node>();	
		Node cur = node;
		while(!st.isEmpty() || cur !=null){
			if(cur !=null){
				st.push(cur);
				cur= cur.left;
			}else{
				cur = st.pop();
				System.out.print("\t"+cur.data);
				cur = cur.right;
			}		
		}
		
	}
	

	ArrayList<Node> traveral = new ArrayList<Node>();
	


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTreeImpl bst = new BinarySearchTreeImpl();
		System.out.print("pre order \n");
		bst.preOrder(bst.root);
		System.out.print("\n post order \n");
		bst.postOrder(bst.root);
		System.out.print("\n post order \n");
		bst.postOrder2(bst.root);
		System.out.print("\n in order \n");
		bst.inOrder(bst.root);

		System.out.print("\n level order \n");
		bst.levelOrder(bst.root);
		System.out.print("\n level order \n");		
		bst.levelOrder2(bst.root);
		
		// bst.print(bst.root,4);
		System.out.print("\n level order \n");
		for(int i=1;i<4;i++){
			System.out.print("\n" + i);
			bst.levelOrder(bst.root,i);				
		}
		
		bst.image(bst.root);
		for(int i=1;i<4;i++){
			System.out.print("\n" + i);
			bst.levelOrder(bst.root,i);				
		}
		
	}
	
	BinarySearchTreeImpl(){
		root =null;
		int[] data = {6,4,8,3,5,7,10};
		for(int x:data){
			root=insert(root,x);
		}
	}
	
	private Node root;



	public void print(Node node, int level){
		if(node==null) return ;
		if(level==1)System.out.print("\t"+node.data);
		else{
			print(node.left,level-1);
			print(node.right,level-1);
		}
	}
	
	
	public void levelOrder(Node node) {
		if(node == null)return ;
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		while(!q.isEmpty()){
			Node tmp = q.remove();
			System.out.print("\t" + tmp.data);
			if(tmp.left!=null)q.add(tmp.left);
			if(tmp.right!=null)q.add(tmp.right);
			
		}

		
	}
	

	public void levelOrder(Node n, int level) {
		// TODO Auto-generated method stub
		    if( n==null|| level<1)return;
		    if(level==1)System.out.print("\t" +n.data);
		    if(level>1){
		    	levelOrder(n.left, level-1);
		    	levelOrder(n.right, level-1);
		    }
	}

	public void image(Node node) {
		// TODO Auto-generated method stub
		if(node ==null) return ;
		
		Node tmp = node.left;
		node.left = node.right;
		node.right = tmp;
		image(node.left);
		image(node.right);
		
	}

	public void levelOrder2(Node node) {
		// TODO Auto-generated method stub
		if(node == null)return ;
		Queue<Node> cur = new LinkedList<Node>();
		Queue<Node> next = new LinkedList<Node>();
		cur.add(node);
		
		while(!cur.isEmpty()){
			Node tmp = cur.remove();
			System.out.print("\t" + tmp.data);
			if(tmp.left!=null)next.add(tmp.left);
			if(tmp.right!=null)next.add(tmp.right);
			
			if(cur.isEmpty()){
				System.out.println();
				swap(cur, next);
			}
			
		}
		
		
		
	}

	private void swap(Queue<Node> cur, Queue<Node> next) {
		// TODO Auto-generated method stub
		while(next.size()>0){
			cur.add(next.remove());
		}
	}

}
