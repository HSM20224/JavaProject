
public class Animal {
	private double weight;
	String picture;

	void eat() {
		System.out.println("eat() �޼ҵ尡 ȣ���");
	}

	void sleep() {
		System.out.println("sleep() �޼ҵ尡 ȣ���");
	}

	void hunt() {
		System.out.println("hunt() �޼ҵ尡 ȣ���");
	}

	void pee() {
		System.out.println("pee() �޼ҵ尡 ȣ���");
	}
}

class Lion extends Animal {
	private int legs = 4;

	void roar() {
		System.out.println("roar() �޼ҵ尡 ȣ���");
	}
}

class Eagle extends Animal {
	private int wings = 2;

	void fly() {
		System.out.println("fly() �޼ҵ尡 ȣ���");
	}
}
