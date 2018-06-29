class Point {
	int x, y;
}

public class Test61 {
	public static void main(String[] args) {
		Test61 obj = new Test61();
		obj.sub();
	}

	void sub() {
		Point p = new Point();
		p.x = 10;
		p.y = 20;
		set(p);
		System.out.println(p.x + "," + p.y);
	}

	void set(Point p) {
		p.x = 30;
		p.y = 40;
	}
}
