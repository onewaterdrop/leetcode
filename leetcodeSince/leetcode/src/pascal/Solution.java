package pascal;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generate(80));
	}

    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> s = new ArrayList<ArrayList<Integer>>();
        if(numRows<=0)return s;
        s.add(new ArrayList<Integer>(java.util.Arrays.asList(new Integer[]{1})));
        if(numRows==1)return s;
        s.add(new ArrayList<Integer>(java.util.Arrays.asList(new Integer[]{1,1})));       
        if(numRows == 2) return s;
        for(int i=3;i<=numRows;i++){
            Integer[] sub= new Integer[i];
            sub[0]=1;
            sub[i-1]=1;
            for(int j=1;j<i-1;j++){
                sub[j]=s.get(i-2).get(j-1) + s.get(i-2).get(j);
            }
            
            s.add(new ArrayList<Integer>(java.util.Arrays.asList(sub)));
        }
        
        return s;
    }
}
