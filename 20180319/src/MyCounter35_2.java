
public class MyCounter35_2 {
	int counter;
	MyCounter35_2(int value){
		counter = value;
	}
	
	public static void main(String args[]){
		MyCounter35_2 obj1 = new MyCounter35_2(100);
		MyCounter35_2 obj2 = new MyCounter35_2(200);
		
		System.out.println("��ü 1�� counter = "+obj1.counter);
		System.out.println("��ü 2�� counter = "+obj2.counter);
	}
}
