package chap4;

import java.util.ArrayList;


public class Tree<T> {
    private Node<T> root;

    public Tree(T rootData) {
        root = new Node<T>();
        root.data = rootData;
        root.children = new ArrayList<Node<T>>();
    }

    
	Tree(int[] a){
		int layer = (int)Math.log(a.length+1);
		
	}
}