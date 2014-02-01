import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;


public class Combination {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Combination c = new Combination();
		System.out.println(c.combinationSum(new int[]{1,1,2},40));
		java.util.Queue<TreeNode> Q = new LinkedList<TreeNode>();
	}
	
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        if(candidates==null)return arr;
        int len= candidates.length;
        if(target<candidates[0])return arr;
        
        for(int i=1;i<=candidates.length;i++){
            if(candidates[0]*i<=target &&target<=candidates[len-1]*i)selectCandidates(arr,candidates,target,i);
        }
        return arr;
        
    }
    
    void selectCandidates(ArrayList<ArrayList<Integer>> arr,int[] candidates, int target,int k){
        int[] runner=new int[k];
        int len= candidates.length;
        int j=0;
        while(runner[k-1]<len &&j<k){
            int sum=0;
            for(int i=0;i<k;i++){
                sum+=candidates[runner[i]];
            }
            if(sum==target){
                ArrayList<Integer> sol = new ArrayList<Integer>();
                for(int i=0;i<k;i++){
                    sol.add(candidates[runner[i]]);
                }
                arr.add(sol);
            }else if(sum>target){
                return;
            }else{
               if(runner[j]==len-1){
                    j++;
                }
                runner[j]++;  //move the jth runner step forward. 
            }

        }
    }

}
