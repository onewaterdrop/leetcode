package chapter14;

abstract class AbstractMethod {

	/**
	 * @param args
	 */
	
	abstract void myMethod();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractMethod m1 = new AbstractMethod1();
		AbstractMethod m2 = new AbstractMethod2();
		m1.myMethod();
		m2.myMethod();
	}

}


 class AbstractMethod1 extends AbstractMethod{

	 public static void main(String[] args) {
		 // TODO Auto-generated method stub
		 AbstractMethod m1 = new AbstractMethod1();
		 AbstractMethod m2 = new AbstractMethod2();
		 m1.myMethod();
		 m2.myMethod();
	 }
	@Override
	void myMethod() {
		// TODO Auto-generated method stub
		System.out.println("in Method1");
	}
	
}


 class AbstractMethod2 extends AbstractMethod{

	@Override
	void myMethod() {
		// TODO Auto-generated method stub
		System.out.println("in Method2");
		
	}
	
}
