package equal;

import java.util.Vector;

public class TestRetain {
   public static void main(String[] args) {
      // create an empty Vector vec with an initial capacity of 7      
      Vector<Integer> vec = new Vector<Integer>(7);
      Vector<Integer> vecretain = new Vector<Integer>(4);

      // use add() method to add elements in the vector
      vec.add(1);
      vec.add(2);
      vec.add(3);
      vec.add(4);
      vec.add(5);
      vec.add(6);
      vec.add(7);
      
      // this elements will be retained
      vecretain.add(5);
      vecretain.add(3);
      vecretain.add(8);

      System.out.println("Calling retainAll()");
      vec.retainAll(vecretain);
      
      // let us print all the elements available in vector
      System.out.println("Numbers after removal :- "); 
      for (Integer number : vec) {         
         System.out.println("Number = " + number);
      }           
   }    
}