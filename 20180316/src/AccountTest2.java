import java.util.Scanner;

public class AccountTest2 {

	public static void main(String[] args) {

		Account2 obj = new Account2();

		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);

		System.out.println("이름을 입력하세요. >");
		obj.setName(scan.next());
		System.out.println("통장 잔고를 입력하세요. >");
		obj.setBalance(scan2.nextInt());

		System.out.println("이름은 " + obj.getName() + ", 통장 잔고는 " + obj.getBalance() + "입니다.");
	}

}
