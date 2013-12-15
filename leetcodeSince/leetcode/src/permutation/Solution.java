package permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(permute(new int[]{1,2,3}));

	}
    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        int n= num.length;
        if(n<=0)return new ArrayList<ArrayList<Integer>>();
        if(n==1){
            ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> num1 =new  ArrayList<Integer>();
            num1.add(num[0]);
            ret.add(num1);
            return ret;
        }
        
        if(n==2){
            ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
            java.util.ArrayList<Integer> num1 = new ArrayList<Integer>();
            num1.add(num[0]);
            num1.add(num[1]);
            ret.add(num1);
            
            java.util.ArrayList<Integer> num2 = num1 = new ArrayList<Integer>();
            num2.add(num[1]);
            num2.add(num[0]);
            ret.add(num2);
            return ret;
        }
        
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        
        for(ArrayList<Integer> x:permute(java.util.Arrays.copyOfRange(num,1,n)) ){
            for(int i=0;i<=x.size();i++){
                ArrayList<Integer> temp = (ArrayList<Integer>) x.clone();
        //        java.util.Collections.copy(temp, x);
                temp.add(i,num[0]);
                ret.add(temp);
            }
            
        }
        
        return ret;
        
    }

}
