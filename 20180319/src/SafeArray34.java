
public class SafeArray34 {
	private int a[];
	public int length;
	public SafeArray34(int size){
		a = new int[size];
		length = size;
	}
	public int get(int index){
		if(index >= 0 && index < length){
			return a[index];
		}
		return -1;
	}
	public void put(int index, int value){
		if(index >= 0 && index < length){
			a[index] = value;
		} else {
			System.out.println("잘못된 인덱스 " + index);
		}
	}
}
