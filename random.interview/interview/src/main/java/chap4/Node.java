package chap4;

import java.util.List;

public class Node<T> {

	Node<T> left;
	T data;
	Node<T> right;
	
    Node<T> parent;
    List<Node<T>> children;

}
