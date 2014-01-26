
public class GasStation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new GasStation().canCompleteCircuit(new int[]{2,4}, new int[]{3,4}));
		
	}
	
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        
        for(int i=0;i<gas.length;i++){
            int j=i; int tank=gas[j];
            
            do{
                
                tank -=cost[j];
                
                if(tank<0)break;
                
                System.out.println("tank =\t" + tank);
                System.out.println("j =\t" + j);
                
                tank +=gas[(j+1)%gas.length];
                
                j=(j+1) % gas.length;
            }while(j!=i);
            
            if(tank>=0) return i;
        }
        
        return -1;
        
    }

}
