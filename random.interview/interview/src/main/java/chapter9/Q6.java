package chapter9;

import java.util.Arrays;

public class Q6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array ={{1,2,3,4,5},
						{3,4,5,6,7},
						{4,5,6,7,8},
						{8,9,10,11,12}};
		
		System.out.println(Arrays.toString(find(array,13)));

	}
	
		static int[] find(int[][] array, int x){
			int[] location = {-1,-1};
			int i=0;
			for(i=0;i<array.length;i++){
				if(x==array[i][0]){
					location[0]=i;
					location[1]=0;
				}
				else if(x>array[i][0])
					i++;
				else 
					break;
			}
			
			i--;
			
			for(int j=0;j<array[0].length;j++){
				if(x==array[i][j]){
					location[0]=i;
					location[1]=j;
				}else if(x>array[i][j])
					j++;
				else
					break;
				

			}
			
			return location;
		}

}

