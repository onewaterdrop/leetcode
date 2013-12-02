package real.interview;

import java.awt.Point;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class MergeInterval {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeInterval mi = new MergeInterval();
		
//		int[] ins = {0, 8, 7, 9,15, 2,10,8,11,15};
		
		
		int x =15;
		int y =123;
		System.out.println("x^y="+(x^y));
		System.out.println("y="+(x^y^x));
		System.out.println("x="+(x^y^y));
		
//		 System.out.println(Arrays.toString(ins));
		
//		Point[] ins=null;
		
//		Point[] result = mi.getMergedI3(ins);
		
		
		LinkedList<Point> ins =new LinkedList<Point>();
		Point p1 = new Point(0,2);
		Point p2 = new Point(8,10);
		Point p3 = new Point(7,8);
		Point p4 = new Point(9,11);
		Point p5 = new Point(15,15);
		
		ins.add(p1);
		ins.add(p2);
		ins.add(p3);
		ins.add(p4);
		ins.add(p5);
		
		
		mi.getMergedI4(ins);
		
		System.out.println(Arrays.toString(ins.toArray()));
		

	}
	
	public Point[] getMergedI3(Point[] ins){
		
		 int Num = ins.length/2;

		 sortByFirst(ins);
		 
		 for(int i=0;i<Num-1;i++){
			 if(ins[i].y>=ins[i+1].x){
				 if(ins[i].y<ins[i+1].y){
					 ins[i].y= ins[i+1].y;
					// delete node i+1;
					// Arrays.copyOfRange(ins, from, to);
				 }else{
					// delete node i+1;
				 }
			 }
		 }
		 
		 
		return ins;
		
	}
	
	
	public LinkedList<Point> getMergedI4(LinkedList<Point> ins){

		 sortByFirst(ins);
		 
		 for(int i=0;i<ins.size()-1;i++){
			 while(ins.get(i).y>=ins.get(i+1).x){
				 if(ins.get(i).y<ins.get(i+1).y){
					 ins.get(i).y=ins.get(i+1).y;
					 ins.remove(i+1);
					// delete node i+1;
					// Arrays.copyOfRange(ins, from, to);
				 }else{
					 ins.remove(i+1);
					// delete node i+1;
				 }
				 
				 
			 }
		 }
		 
		 
		return ins;
		
	}
	
	private void sortByFirst(LinkedList<Point> ins) {
		// TODO Auto-generated method stub
		 for(int i=0;i<ins.size();i++){
			   for(int j=i+1;j<ins.size();j++){
			     if(ins.get(j).x<=ins.get(i).x){
			    	  Collections.swap(ins, i, j);
			         }
			      }
			 }
		
	}

	private void sortByFirst(Point[] ins) {
		// TODO Auto-generated method stub
		 for(int i=0;i<ins.length;i++){
			   for(int j=i+1;j<ins.length;j++){
			     if(ins[j].x<=ins[i].x){
			    	 swap(ins[j],ins[i]);
			         }
			      }
			 }
		
		
	}

	private void swap(Point point, Point point2) {
		// TODO Auto-generated method stub
		Point temp = new Point();
		temp = point;
		point = point2;
		point2 =temp;
		
		
	}

	public int[] getMergedI(int[] ins){

		 int Num = ins.length/2;

//		 System.out.println(Num);
		 
//		 System.out.println(Arrays.toString(ins));
		 for(int i=0;i<Num;i++){
		   for(int j=i+1;j<Num;j++){
		     if(ins[j]<=ins[i]){
		    	 ins[j]=(ins[j])^(ins[i]); 
		    	 ins[i]=(ins[j])^(ins[i]);
		    	 ins[j]=(ins[j])^(ins[i]);
		    	 
		    	 System.out.println("ins[i]="+ins[i]+" ins[j]" + ins[j]);
		         ins[j+Num]=ins[j+Num]^ins[i+Num];
		         ins[i+Num]=ins[j+Num]^ins[i+Num];
		         ins[j+Num]=ins[j+Num]^ins[i+Num];
		         
		    	 System.out.println("ins[i]="+ins[i+Num]+" ins[j]" + ins[j+Num]);
		         }
		      }
		 }

//	 System.out.println(Arrays.toString(ins));

		   for(int i=0;i<Num;i++){
			   if(ins[i+Num]>=ins[i+1]){
				   ins[i+Num]=ins[i+1+Num];
				   for(int j=i+1;j<Num-1;j++){
					   ins[j]=ins[j+1];
					   ins[j+Num]=ins[j+1+Num];
				   }
				   Num--;
			   }

		   }
		   
		   return ins;
		   
		 }
	
	
	public int[] getMergedI2(int[] ins){

		
		 int Num = ins.length/2;

//		 System.out.println(Num);
		 
//		 System.out.println(Arrays.toString(ins));
		 for(int i=0;i<Num;i++){
		   for(int j=i+1;j<Num;j++){
		     if(ins[j]<=ins[i]){
		    	 
				 System.out.println("Run this");
		    	 
		    	 ins[j]=(ins[j])^(ins[i]); 
		    	 ins[i]=(ins[j])^(ins[i]);
		    	 ins[j]=(ins[j])^(ins[i]);
		    	 
		    	 System.out.println("ins[i]="+ins[i]+" ins[j]" + ins[j]);
		         ins[j+Num]=ins[j+Num]^ins[i+Num];
		         ins[i+Num]=ins[j+Num]^ins[i+Num];
		         ins[j+Num]=ins[j+Num]^ins[i+Num];
		         
		    	 System.out.println("ins[i]="+ins[i+Num]+" ins[j]" + ins[j+Num]);
		         }
		      }
		 }

//	 System.out.println(Arrays.toString(ins));
		 
		   
		 int Fixed = Num;

		   for(int i=0;i<Fixed-1;i++){
			   if(ins[i+Fixed]>=ins[i+1]){
				   System.out.println("Run this");
				   ins[i+Fixed]=ins[i+1+Fixed];
				   for(int j=i+1;j<Fixed-1;j++){
					   ins[j]=ins[j+1];
					   ins[j+Fixed]=ins[j+1+Fixed];
				   }
			   }

		   }
		   
		   
		   
		   for(int i=0;i<Fixed-1;i++){
			   if(ins[i+Fixed]>=ins[i+1]){
				   System.out.println("Run this");
				   ins[i+Fixed]=ins[i+1+Fixed];
				   for(int j=i+1;j<Fixed-1;j++){
					   ins[j]=ins[j+1];
					   ins[j+Fixed]=ins[j+1+Fixed];
				   }
			   }

		   }
		   
			System.out.println(Arrays.toString(ins));
		   System.out.println(Num);
		   
		   int[] result = new int[Num*2];
		   for(int i=0;i<Num;i++){
			   result[i]=ins[i];
			   result[i+Num]=ins[i+Fixed];
		   }
		   
		   
		   return result;
		   
		 }

}
