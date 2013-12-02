package chap3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> s = new Stack<Integer>();
		s.push(5);
		s.push(6);
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		Queue<Integer> d = new LinkedList<Integer>();
		d.add(5);
		System.out.println(d.poll());
		
	}

}
