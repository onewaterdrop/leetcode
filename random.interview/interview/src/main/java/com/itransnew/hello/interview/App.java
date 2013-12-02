package com.itransnew.hello.interview;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apfloat.ApfloatRuntimeException;
import org.apfloat.internal.IntBuilderFactory;
import org.apfloat.samples.Pi;
import org.apfloat.samples.PiParallel;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static Logger log = Logger.getLogger(App.class);
	
    public static void main( String[] args )
    {
    	
    	
    	log.setLevel(Level.ERROR);
    	log.error("test error");
        System.out.println( "Hello World!" );
		int[] arrayInt={1,2,3,4,5,6,7};

		
		
		Integer[] array={1,2,3,4,5,6,7,7};
		
		arrayInt = ArrayUtils.toPrimitive(array);
		
		array = ArrayUtils.toObject(arrayInt);

		
//		Set s = new TreeSet<Integer>();
		Set<Integer> set = new TreeSet<Integer>(Arrays.asList(array));
		Collections.addAll(set, array);
		if (set.size()<array.length) {
			System.out.println("has duplicates");
		}else{
			System.out.println("Do not have duplicates");
		}
		
        
		
//		IntBuilderFactory f = new IntBuilderFactory();
		
		try {
			//chudnovsky Ramanujan Borwein
			
//			PiParallel.main(new String[]{"123","0","7"});
			Pi.main(new String[]{"12","3","10"});
			
		} catch (ApfloatRuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		int x=10;
		int y=20;
		

		int z= x++ + ++ y;
		
		System.err.println("z="+ z);
		
		System.out.println("kou");
//		int i=0;
//		new Runnable() {
//			public void run() {
//				System.out.println(i);
//			}
//		}
		System.out.println(x++>10 || ++y<20);
		
		boolean a =  ++y == 20||x++ == 10;
		
	/*	System.err.println("10/20="+ 10/20);
		
		System.err.println("x="+ x++);
		System.err.println("x="+ x);
		System.err.println("x="+ ++x);
		System.err.println("x="+ x);*/
		System.err.println("a="+a);
		System.err.println("x="+ x);
		System.err.println("y="+ y);
		
    }
}
