
public class Animal2 {

	enum AnimalType{
		Dog,
		Cat;
	}

	public static Animal createAnimal(AnimalType type){
		if(type==AnimalType.Cat) return new Cat();
		if(type==AnimalType.Dog) return new Dog();
		else return null;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(createAnimal(AnimalType.Cat).say());
		System.out.println(createAnimal(AnimalType.Dog).say());

	}

}
