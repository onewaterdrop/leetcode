package single.number;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(singleNumber(new int[]{1,1,4,2,4,4,1}));
		
		System.out.println("mod "+ 3 %3);
		throw new IllegalArgumentException("test");
	}
	
	
    public static int singleNumber1(int[] A) {
        java.util.Map<Integer,Integer> m = new java.util.HashMap<Integer,Integer>();
        java.util.List<Integer> l = new java.util.LinkedList<Integer>();
        for(int i=0;i<A.length;i++){
            if(m.containsKey(new Integer(A[i]))){
                l.remove(new Integer(A[i]));
            }else{
                m.put(new Integer(A[i]),1);
                l.add(new Integer(A[i]));
            }
            
            
        }
        
        return l.get(0).intValue();
    }
    
    public static int singleNumber(int[] A) {

    int single_number=0; int bit=0;
    for(int i=0;i<32;i++){
         bit=0;
        for(int j=0;j<A.length;j++){
            bit = (bit + (A[j]>>i & 1) ) % 3 ;
   //         if(bit>=3)bit = bit %3 ;
   //         System.out.print(" " + bit);
        }
        

  //      System.out.println(" ");
        single_number += (bit<<i);
        
  //     System.out.println(" " + single_number);
        
    }
        
        return single_number;
        
    }

}
