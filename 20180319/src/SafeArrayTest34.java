
public class SafeArrayTest34 {
	public static void main(String args[]) {
		SafeArray34 array = new SafeArray34(3);

		for (int i = 0; i < (array.length + 1); i++) {
			array.put(i, i * 10);
		}
	}
}
