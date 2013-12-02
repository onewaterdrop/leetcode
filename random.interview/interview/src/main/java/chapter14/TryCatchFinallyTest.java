package chapter14;


 class TryCatchFinallyTest implements Runnable {

	private void testMethod() throws InterruptedException
	{
		try
		{
			System.out.println("In try block");
			throw new NullPointerException();
		}
		catch(NullPointerException npe)
		{
			System.out.println("In catch block");
		}
		finally
		{
			System.out.println("In finally block");
		}
	}

	public void run() {
		try {
			testMethod();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("In finalize block");
		super.finalize();
	}
	
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		for(int i=1;i<=3;i++)
		{
			new Thread(new TryCatchFinallyTest()).start();
			Runtime.runFinalizersOnExit(true);
		}
	}
}


 class TestMain
{
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		for(int i=1;i<=3;i++)
		{
			new Thread(new TryCatchFinallyTest()).start();
			Runtime.runFinalizersOnExit(true);
		}
	}
}