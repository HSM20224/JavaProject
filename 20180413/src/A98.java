
public class A98 {
	A98() {}
}

class B extends A98 {
	B() {}
}

class test2 {
	public static void main(String[] args){
		A98 a98 = new B();
	}
}