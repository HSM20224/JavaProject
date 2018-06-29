
public class Student38 {
	private int number;
	private String name;
	private int age;

	Student38() {
		number = 100;
		name = "New Student";
		age = 18;
	}

	Student38(int number, String name, int age) {
		this.number = number;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [number =" + number + ", name =" + name + ", age =" + age + "]";
	}

}
