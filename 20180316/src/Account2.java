import java.util.*;

public class Account2 {
	private int regNumber;
	private String name;
	private int balance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		if (0 > balance) {
			System.out.println("0�̻��� ���ڸ� �Է��ϼ���.");
		} else {
			this.balance = balance;
		}
	}
}
