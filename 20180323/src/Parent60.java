
public class Parent60 {
	Parent60() {
		System.out.println("Parent");

	}

}

class Child extends Parent60 {
	public static void main(String[] args) {
		new Child();
		new Parent60();
	}
}
