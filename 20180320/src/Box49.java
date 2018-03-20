
public class Box49 {
	int width, length, height;
	
	Box49(int w, int l, int h){
		width = w;
		length = l;
		height = h;
	}
	
	boolean isSameBox(Box49 obj){
		if((obj.width == width) & (obj.length == length) & (obj.height == height)){
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Box49 obj1 = new Box49(10,20,50);
		Box49 obj2 = new Box49(10,20,50);
		
		System.out.println("obj1 == obj2 : "+obj1.isSameBox(obj2));
	}
}
