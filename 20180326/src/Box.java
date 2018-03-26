
public class Box {
	private int width, height, length;
	boolean empty = false;

	public Box() {
		width = 0;
		height = 0;
		length = 0;
		empty = true;
	}

	public Box(int w, int h, int l) {
		this.width = w;
		this.height = h;
		this.length = l;
		empty = true;
	}

	void setWidth(int w) {
		this.width = w;
	}

	void setHeight(int h) {
		this.height = h;
	}

	void setLength(int l) {
		this.length = l;
	}

	void setEmpty(boolean e) {
		this.empty = e;
	}

	int getWidth() {
		return width;
	}

	int getHeight() {
		return height;
	}

	int getLength() {
		return length;
	}

	boolean isEmpty() {
		return empty;
	}

}
