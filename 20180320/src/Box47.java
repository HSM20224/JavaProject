
public class Box47 {
	int width, length, height;
	int volume;
	
	Box47(int w, int l, int h) {
		width = w;
		length = l;
		height = h;
		volume = w*l*h;
	}
	
	Box47 whosLargest(Box47 box1, Box47 box2){
		if(box1.volume > box2.volume) {
			return box1;
		} else {
			return box2;
		}
	}
	
	public static void main(String[] args){
		Box47 obj1 = new Box47(10,20,50);
		Box47 obj2 = new Box47(10,30,30);
		
		Box47 largest = obj1.whosLargest(obj1, obj2);
		System.out.println("("+largest.width+","+largest.length+","+largest.height+")");
	}
}
