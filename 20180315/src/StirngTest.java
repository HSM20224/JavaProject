import java.util.Scanner;

public class StirngTest {
	public static void main(String a[]) {
		String str;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("���ڿ��� �Է��ϼ���>");
			str = sc.next();
			if (str.equals("quit") == true)
				break;
			System.out.println(str);
		}
	}
}
