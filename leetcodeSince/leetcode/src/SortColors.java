import java.util.Arrays;


public class SortColors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A =new int[]{1};
		sortColors(A);
		System.out.println(Arrays.toString(A));
		
	}
	
	public static void sortColors(int[] A) {
	    
	    if(A.length==0)return;
	    
	    int[] x = java.util.Arrays.copyOfRange(A,0,A.length);

		int[] x1=new int[x.length];
		int[] x2=new int[x.length];
		int[] x3=new int[x.length];
		
		int j1=0,j2=0,j3=0;
		for(int i=0;i<x.length;i++){
		    switch(x[i]){
		        case 0:
		            x1[j1++]=x[i];
		            break;
		        case 1:
		            x2[j2++]=x[i];	
		            break;
		        case 2:
		            x3[j3++]=x[i];
		            break;
		    }

		}
		
		System.out.println("j1="+j1);
		System.out.println("j2="+j2);
		System.out.println("j3="+j3);
	     if(j1>0)System.arraycopy(x1, 0, A, 0, j1);
	     if(j2>0)System.arraycopy(x2, 0, A, j1, j2);
	     if(j3>0)System.arraycopy(x3, 0, A, j1+j2, j3);
	     
	     System.out.println(Arrays.toString(x1));
	     System.out.println(Arrays.toString(x2));
	     System.out.println(Arrays.toString(x3));
	     
	     System.out.println(Arrays.toString(A));

	}

}


