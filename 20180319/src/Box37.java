
public class Box37 {
	private int width;
	private int length;
	private int height;
	private int volume;

	public int getVolume() {
		return volume;
	}

	Box37(int w, int l, int h) {
		width = w;
		length = l;
		height = h;
		volume = width * length * height;
	}

	public static void main(String[] args) {
		Box37 b;
		b = new Box37(20, 20, 30);
		System.out.println("상자의 부피는 " + b.getVolume() + "입니다.");
	}
}
