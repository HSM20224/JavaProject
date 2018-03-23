
public class Test60_2 {
	public static void main(String[] args){
		Test60_2 p = new Test60_2();
		p.sub();
	}
	
	void sub(){
		boolean bl = false;
		set(bl);
		System.out.println(bl);
	}
	
	void set(boolean bl){
		bl = true;
	}
}
