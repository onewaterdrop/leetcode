
public interface BinarySearchTree {

	Node insert(Node node, int data);
	void postOrder(Node node);
	void inOrder(Node node);	
	void preOrder(Node node);	
	void levelOrder(Node node);
	void levelOrder2(Node node);
	void levelOrder(Node node, int level);
	void image(Node node);
	
}

class Node {
	int data;
	Node left,right;
	Node(int data){
		this.data=data;
	}
}