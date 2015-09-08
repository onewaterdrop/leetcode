
public abstract class Animal {

	abstract String say();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a = new Dog();
		System.out.println(a.say());
		a = new Cat();
		System.out.println(a.say());

	}

}
