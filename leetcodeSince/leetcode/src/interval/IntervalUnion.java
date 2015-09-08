package interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntervalUnion{
    class Interval implements Comparable<Interval>{
        private final int left;
        private final int right;
        Interval(int left,int right){
            this.left = left;
            this.right = right;
        }
        public int getRight(){
          return this.right;
        }
        public int getLeft(){
          return this.left; 
        }
        @Override
        public int compareTo(Interval interval){
            if(this.left > interval.left){
              return 1; 
            }else if(this.left < interval.left){
              return -1;    
            }else{
              return 0;
            }
        }
        @Override
        public String toString(){
         return "("+this.left+","+this.right+")";
        }
    }   

    public List<Interval> getUnion(List<Interval> intervals){
        Collections.sort(intervals);
        List<Interval> union = new ArrayList<Interval>();
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for(Interval i:intervals){
            int currentRight = i.getRight();
            int currentLeft = i.getLeft();
            if(currentLeft <= right && currentRight > right){
              right = currentRight;
            }
            if(currentLeft < left && currentRight >= right){
              left = currentLeft;
              right = currentRight; 
            }
            if(currentLeft > right){
              union.add(new Interval(left,right));
              left = currentLeft;
              right = currentRight;
            }
        }
        union.add(new Interval(left,right));
        return union;
    }
    public static void main(String[] args){
      System.out.println("Testing out the union");
      IntervalUnion intervalUnion = new IntervalUnion();  
      final IntervalUnion.Interval i1 = intervalUnion.new Interval(2,4);
      final IntervalUnion.Interval i2 = intervalUnion.new Interval(1,1);
      final IntervalUnion.Interval i3 = intervalUnion.new Interval(3,4);
      final IntervalUnion.Interval i4 = intervalUnion.new Interval(0,3);
      final IntervalUnion.Interval i5 = intervalUnion.new Interval(8,11);
      final IntervalUnion.Interval i6 = intervalUnion.new Interval(7,8);
      final IntervalUnion.Interval i7 = intervalUnion.new Interval(5,7);
      final IntervalUnion.Interval i8 = intervalUnion.new Interval(9,11);
      final IntervalUnion.Interval i9 = intervalUnion.new Interval(13,13);
      final IntervalUnion.Interval i10 = intervalUnion.new Interval(16,17);
      final IntervalUnion.Interval i11 = intervalUnion.new Interval(12,15);
      final IntervalUnion.Interval i12 = intervalUnion.new Interval(12,14);

      List<IntervalUnion.Interval> sample = new ArrayList<IntervalUnion.Interval>()
                    {{
                      add(i1);
                      add(i2);
                      add(i3);
                      add(i4);
                      add(i5);
                      add(i6);
                      add(i7);
                      add(i8);
                      add(i9);
                      add(i10);
                      add(i11);
                      add(i12); 
                    }};

        for (IntervalUnion.Interval i:intervalUnion.getUnion(sample)){
        System.out.println(i);
    }
 }
}