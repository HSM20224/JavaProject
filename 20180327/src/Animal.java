
public class Animal {
	private double weight;
	String picture;

	void eat() {
		System.out.println("eat() 메소드가 호출됨");
	}

	void sleep() {
		System.out.println("sleep() 메소드가 호출됨");
	}

	void hunt() {
		System.out.println("hunt() 메소드가 호출됨");
	}

	void pee() {
		System.out.println("pee() 메소드가 호출됨");
	}
}

class Lion extends Animal {
	private int legs = 4;

	void roar() {
		System.out.println("roar() 메소드가 호출됨");
	}
}

class Eagle extends Animal {
	private int wings = 2;

	void fly() {
		System.out.println("fly() 메소드가 호출됨");
	}
}
