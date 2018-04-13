
public class Shape95 {
	private int x;
	private int y;
	
	public Shape95(int x, int y){
		System.out.println("Shape95()");
		this.x = x;
		this.y = y;
	}
}

class ColoredRectangle95 extends Rectangle95 {
	String color;
	
	public ColoredRectangle95 (int x, int y, int width, int height, String color) {
		super(x,y,width,height);
		System.out.println("ColoredRectangle9595()");
		this.color = color;
	}
	public static void main(String[] args){
		ColoredRectangle95 obj = new ColoredRectangle95(10,10,20,20,"red");
	}
}

class Rectangle95 extends Shape95 {
	private int width,height;
	public Rectangle95(int x, int y, int width, int height) {
		super(x,y);
		this.height = height;
		this.width = width;
		System.out.println("Rectangle95()");
	}
	double calcArea() {
		return width * height;
	}
}