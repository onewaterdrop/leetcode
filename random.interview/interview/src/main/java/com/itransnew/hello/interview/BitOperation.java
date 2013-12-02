package com.itransnew.hello.interview;

import java.io.IOException;

public class BitOperation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=0xFF;
		int y=0xF0;
		int z=x^y;
		int m=x & y;
		int n = x|y;

		int octoal = 077;
		
		System.out.println("x^y:"+z);
		System.out.println("x&y:"+m);
		System.out.println("x|y:"+n);
		System.out.println(octoal);
		
		
		System.out.println(Integer.toBinaryString(15));
		System.out.println(Integer.toOctalString(15));
		System.out.println(Integer.toHexString(15));
		System.out.println(String.format("%x", 15));
		System.out.format("%x", 15);
		System.out.println();
		

		try {
			x=System.in.read();
			System.out.println(x);
			System.out.format("%x",System.in.read());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
