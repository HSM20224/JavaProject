
public class BankAccount {
	String name;
	int a_num, balance;
	double rate;

	void setName(String n) {
		name = n;
	}

	void setAccountnumber(int a) {
		a_num = a;
	}

	void setBalance(int b) {
		balance = b;
	}

	void setRate(double r) {
		rate = r;
	}

	String getName() {
		return name;
	}

	int getAccountnumber() {
		return a_num;
	}

	int getBalance() {
		return balance;
	}

	double getRate() {
		return rate;
	}

	public BankAccount() {
	}

	public BankAccount(String n, int a, int b, double rate) {
		this.name = n;
		this.a_num = a;
		this.balance = b;
		this.rate = rate;
	}
}
