import java.util.ArrayList;


public class SpiralMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] x ={{1,2,3},{8,9,4},{7,6,5},{2,3,4}};
		System.out.println(new SpiralMatrix().spiralOrder(x));
	}
	
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if(matrix == null)return arr;
        
        int m= matrix.length;
        int n= matrix[0].length;

        int i=0;
        int beginX=0,beginY=0;
        int endX=n-1;
        int endY=m-1;
        
        while(true){
            
            for(i=beginX;i<=endX;i++){
                arr.add(matrix[beginY][i]);
            }
            if (++beginY > endY) break;
            
            for(i=beginY;i<=endY;i++){
                arr.add(matrix[i][endX]);
            }
            if (beginX > --endX) break;
            for(i=endX;i>=beginX;i--){
                arr.add(matrix[endY][i]);
            }
             if (beginY > --endY) break;
            for(i=endY;i>=beginY;i--){
                arr.add(matrix[i][beginX]);
            }
            if (++beginX > endX) break;
        
        }
        
        return arr;
        
    }

}
