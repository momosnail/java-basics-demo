package w_13;

public class AnimalDemo {
	public static void main(String[] args) {
		Animal animal1=AnimalFactory.createAnimal("dog");
		Animal animal2=AnimalFactory.createAnimal("cat");
		Animal animal3=AnimalFactory.createAnimal("pig");
		if (animal1!=null) {
			animal1.eat();
		}else {
			System.out.println("对不起，没有您需要的动物");
		}
		if (animal2!=null) {
			animal2.eat();
		}else {
			System.out.println("对不起，没有您需要的动物");
		}
		if (animal3!=null) {
			animal3.eat();
		}else {
			System.out.println("对不起，没有您需要的动物");
		}
	}
}
