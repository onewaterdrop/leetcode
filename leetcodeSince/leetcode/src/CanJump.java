import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CanJump {
	
	public static void main(String[] args) {
		CanJump c = new CanJump();
		long tic=System.currentTimeMillis();
//		System.out.println(c.canJump(new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6}));
		System.out.println(c.canJump(new int[]{0,1}));
//		System.out.println(c.canJump(new int[]{1,2,2,6,3,6,1,8,9,4,7,6,5,6,8,2,6,1,3,6,6,6,3,2,4,9,4,5,9,8,2,2,1,6,1,6,2,2,6,1,8,6,8,3,2,8,5,8,0,1,4,8,7,9,0,3,9,4,8,0,2,2,5,5,8,6,3,1,0,2,4,9,8,4,4,2,3,2,2,5,5,9,3,2,8,5,8,9,1,6,2,5,9,9,3,9,7,6,0,7,8,7,8,8,3,5,0}));
//		System.out.println(c.canJump(new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6}));
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.indexOf(a);
		Map<Integer,Integer> m = new HashMap<Integer,Integer>();
		
		long tac=System.currentTimeMillis();
		System.out.println(tac-tic);
	}
	
    public boolean canJump1(int[] A) {
        
        try{
            jump(A[0],0,A);
        }catch(Exception e){
            return true;
        }
        return false;
        
    }
    
    public void jump(int forw,int cur,int[] A) throws Exception{
        if(cur+ forw >= A.length-1) throw new Exception("Solution Found");
        if(forw==0) return ;
        else {
        	int i=forw;
            while( i>0){
                if(cur+i<A.length-1){
                	if(A[cur+i]==0)i--;
                	else {
                		jump(A[cur+i],cur+i,A);
                		break;
                	}
                }else{
                	throw new Exception("Solution Found");
                }
            }
            if(i==0)return;
        }
        
    }
    
    public boolean canJump(int[] A) {
        
        int reach = 1;
        for (int i = 0; i < reach && reach < A.length; ++i){
            reach = Math.max(reach, A[i] + i + 1);
            System.out.println("reach=" + reach + "\t i="+ i + "\t A[i]="+ A[i]);
        }
        return reach >= A.length;
        
    }
    
}
