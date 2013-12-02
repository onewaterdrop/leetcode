package chapter9;

public class Q1MergeAB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,3,5,6,8,10,0,0,0,0};
		int[] B= {12,14,15,17};
		int sizeA =6;
		Q1MergeAB q1=new Q1MergeAB(A,B,sizeA);
		
		A= q1.getA();
		for(int e:A){
			System.out.println(e);
		}

	}
	
	int[] A;
	int[] B;
	
	Q1MergeAB(int[] A1, int[] B1, int sizeA){
		this.A=A1;
		this.B=B1;

		int jA=sizeA-1;
		int jB=B.length-1;
		int i=A.length-1;
		while(jA>=0&&jB>=0){
			
			if(A[jA]>=B[jB]){
				A[i]=A[jA];
				jA--;
			}else{
				A[i]=B[jB];
				jB--;
			};
			
			i--;
			
		}
		
		if(jA>=0){
			while(jA>=0){
				A[i]=A[jA];
				i--;
				jA--;
			}
		}
		
		if(jB>=0){
			while(jB>=0){
				A[i]=B[jB];
				i--;
				jB--;
			}
		}
		
//		for(i=A.length-1;i>=0 ;i--){
//			if(jA>=0 && jB >=0){
//				if(A[jA]>B[jB]){
//					A[i]=A[jA];
//					jA--;
//				}else{
//					A[i]=B[jB];
//					jB--;
//				}
//				
//			}else if(jA<0 && jB>=0){
//				A[i]=B[jB];
//				jB--;
//			}else if (jA>=0 && jB<0) {
//				A[i]=A[jA];
//				jA--;
//			}
//			
//			
//		}
		
		
		
		
	}
	

	public int[] getA() {
		return A;
	}

	public void setA(int[] a) {
		A = a;
	}

	public int[] getB() {
		return B;
	}

	public void setB(int[] b) {
		B = b;
	}
	
	

}
