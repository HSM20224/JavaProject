
abstract class Shape97 {
	private int x,y;
	public void move(int x,int y){
		this.x = x;
		this.y = y;
	}
	public abstract void draw();
}

class Rectangle97 extends Shape97 {
	private int width, height;
	public void draw(){
		System.out.println("�簢�� �׸��� �޼ҵ�");
	}
}

class circle extends Shape97 {
	private int radius;
	public void draw(){
		System.out.println("�� �׸��� �޼ҵ�");
	}
}