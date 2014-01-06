package generating.paranthesis;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateParenthesis(5).toString());

	}

	
    public static ArrayList<String> generateParenthesis(int n) {
        return brackets(n,0,"");
}


   public static ArrayList<String> brackets(int openStock, int closeStock, String s) {
           ArrayList<String> temp = new ArrayList<String>();
        if (openStock == 0 && closeStock == 0) {
            temp.add(s);
        }
        if (openStock > 0) {
            temp.addAll(brackets(openStock-1, closeStock+1, s + "("));
        }
        if (closeStock > 0) {
            temp.addAll(brackets(openStock, closeStock-1, s + ")"));
        }
        
        return temp;
}
}
