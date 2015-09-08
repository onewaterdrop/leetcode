import java.util.Arrays;
import java.util.HashMap;


public class AnySumImpl implements AnySum {

	public int[] twoSum(int[] array) {
		// TODO Auto-generated method stub
		int i=0,j=array.length-1;
		while(i<j){
			if(target==array[i]+array[j]){
				int[] x= new int[]{i,j};
				System.out.println(Arrays.toString(x));
				i++;
			}else if(target>array[i]+array[j]){
				i++;
			}else{
				j--;
			}
		}
		return null;
	}
	public int[] twoSum2(int[] array) {
		// TODO Auto-generated method stub
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		for(int i=0;i<array.length;i++){
			if(hm.containsKey(target-array[i]))
				{
					int[] x= new int[]{i,hm.get(target-array[i])};
					System.out.println(Arrays.toString(x));
				}
			else
				hm.put(array[i],i);
		}
		
		return null;
	}

	public int[] threeSum(int[] num) {

    	for(int i=0;i<num.length;i++){
    		for(int j=0;j<i;j++){
    			for(int k=0;k<j;k++){
    				
//    				System.out.println(Arrays.asList(new Integer[]{num[i],num[j],num[k]}).toString());
    				
    				if(num[i]+num[j]+num[k]==target){
    					
    					return new int[]{i,j,k};
    					
    				}
    				
    				
    			}
    		}
    	}

		
		return null;
	}

	public int[] fourSum(int[] array) {
		// TODO Auto-generated method stub
		return null;
	}

	public int[] anySum(int[] array, int any) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(new AnySumImpl().twoSum(AnySum.sortArray)));
		System.out.println(Arrays.toString(new AnySumImpl().twoSum2(AnySum.sortArray)));
		System.out.println(Arrays.toString(new AnySumImpl().threeSum(AnySum.sortArray)));
	}

}
