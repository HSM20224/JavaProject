
public class Shape103 {
	protected int x, y;

	public void draw() {
		System.out.println("Shape Draw");
	}
}

class Triangle103 extends Shape103 {
	private int base, height;

	public void draw() {
		System.out.println("Triangle Draw");
	}
}

class Rectangle103 extends Shape103 {
	private int width, height;

	public void draw() {
		System.out.println("Rectangle Draw");
	}
}

class CIrcle103 extends Shape103 {
	private int radius;

	public void draw() {
		System.out.println("Circle Draw");
	}
}

class test {
	public static void main(String[] args) {
		Shape103 s1, s2, s3, s4;

		s1 = new Shape103();
		s2 = new Rectangle103();
		s3 = new CIrcle103();
		s4 = new Triangle103();
	}
}