import java.util.*;

public class Abc {
	public static void main(String a[]) {

		String s;
		char s2;
		int count1 = 0, count2 = 0, count3 = 0;

		Scanner scan = new Scanner(System.in);
		System.out.print("���ڿ��� �Է��ϼ���");

		s = scan.next();

		for (int i = 0; i < s.length(); i++) {
			s2 = s.charAt(i);
			if (s2 >= 'A' && s2 <= 'Z') {
				count1++;
			} else if (s2 >= 'a' && s2 <= 'z') {
				count2++;
			} else if (s2 >= '0' && s2 <= '9') {
				count3++;
			}
		}
		System.out.println("�빮���� ���� :" + count1 + "\n �ҹ����� ���� :" + count2 + "\n ������ ���� :" + count3);
	}
}
