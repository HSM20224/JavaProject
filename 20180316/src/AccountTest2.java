import java.util.Scanner;

public class AccountTest2 {

	public static void main(String[] args) {

		Account2 obj = new Account2();

		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);

		System.out.println("�̸��� �Է��ϼ���. >");
		obj.setName(scan.next());
		System.out.println("���� �ܰ� �Է��ϼ���. >");
		obj.setBalance(scan2.nextInt());

		System.out.println("�̸��� " + obj.getName() + ", ���� �ܰ�� " + obj.getBalance() + "�Դϴ�.");
	}

}
