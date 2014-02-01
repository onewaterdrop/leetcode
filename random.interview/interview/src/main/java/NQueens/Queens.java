package NQueens;

public class Queens {

	int[] queen;
	static int cnt = 1;
	
	Queens(int N){
		queen = new int[N];
	}
	
	boolean placable(int r,int c){
		
		for(int i=0;i<r;i++){
			if(queen[i]==c) return false;
			if(queen[i]-c==r-i)return false;
			if(c-queen[i]==r-i)return false;
		}
		
		return true;
	}
	
	
	void place(int r, int N){

			for(int j=0;j<N;j++){
				if(placable(r,j)){
					queen[r]=j;
					if(r==N-1){
						System.out.println("Solution:"+ cnt++);
						printQueens(queen);
					}else{
						place(r+1,N);
					}
				}
			}
		
	}
	
	
    public void printQueens(int[] x) {
    	
        int N = x.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (x[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
	private void printAllQueen() {
		// TODO Auto-generated method stub
		for(int i=0;i<8;i++){
			System.out.println("row=i,col="+queen[i]);
		}
		
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=18;
		Queens q = new Queens(N);
		q.place(0,N);

	}

}
