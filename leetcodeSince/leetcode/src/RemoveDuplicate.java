
public class RemoveDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(removeDuplicates(new int[]{1}));
	}
	
	   public static int removeDuplicates(int[] A) {
	        
	        java.util.Map<Integer,Integer> m = new java.util.TreeMap<Integer,Integer>();
	        for(int i=A.length-1;i>=0;i--){
	            if(m.containsKey(A[i])){
	                m.put(A[i],m.get(A[i])+1);
	            }else{
	                m.put(A[i],1);
	            }
	        }
	        
	        int count=0;
	        
	        java.util.List<Integer> l = new java.util.LinkedList<Integer>();
	        
	        System.out.println(m.keySet());
	        for(Integer a:m.keySet()){
	            if(m.get(a)>=2){
	                count+=2;
	                l.add(a);
	                l.add(a);
	            }else{
	                count+=1;
	                l.add(a);
	            }

	            System.out.println(a);
	        }
	        
	        for(int i=0;i<l.size();i++){
	            A[i]=l.get(i);
	        }
	        
	        return count;
	    }

}
