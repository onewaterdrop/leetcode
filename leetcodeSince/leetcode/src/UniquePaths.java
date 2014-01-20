
public class UniquePaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths2(44,40));
	//	Integer.parseInt(s, radix)
	}

    public static int uniquePaths(int m, int n) {
        if(m==1 || n==1)return 1;
        else{
            return uniquePaths(m-1,n) + uniquePaths(m,n-1);
        }
    }
    
    public static int uniquePaths2(int m, int n) {
        if(m==1 || n==1)return 1;
        int[][] A= new int[m+1][n+1];
        java.util.Arrays.fill(A[1],1);
        for(int j=1;j<=m;j++){
            A[j][1]=1;
        }
        
        for(int i=2;i<=m;i++){
            for(int j=2;j<=n;j++){
                A[i][j]=A[i-1][j]+A[i][j-1];
                System.out.println(A[i][j] + ",");
            }
        }
        
        return A[m][n];
        
    }
    
}
