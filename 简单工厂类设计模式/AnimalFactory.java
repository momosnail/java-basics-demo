package w_13;

public class AnimalFactory {

	private AnimalFactory() {

	}

	public static Animal createAnimal(String animal) {
		if ("dog".equals(animal)) {
			return new Dog();
		} else if ("cat".equals(animal)) {
			return new Cat();
		}
		return null;
	}
}
