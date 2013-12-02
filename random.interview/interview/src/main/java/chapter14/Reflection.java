package chapter14;

import java.lang.reflect.*;
import java.sql.Connection.*;

public class Reflection {

	/**
	 * @param args
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 try {
			 Class c = Class.forName("java.lang.reflect.Array");
			 Method m[] = c.getDeclaredMethods();
			 for (int i = 0; i < m.length; i++) {
			 System.out.println(m[i].toString());
			  }
			 } catch (Throwable e) {
			 System.err.println(e);
			 }

	}

}
