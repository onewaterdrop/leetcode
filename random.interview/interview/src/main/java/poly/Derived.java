package poly;

public class Derived extends Base {
	public static int f() {
		return 4;
		}
	
	
	public static void main(String[] args) {
		Base b = new Derived();
		System.out.println(b.f());
		System.out.println(Base.f());
		System.out.println(Derived.f());
	}
}


