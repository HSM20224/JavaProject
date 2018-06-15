
public class ScoreDTO {
	private String name;
	private int kor, eng, math, sum, average;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}

	@Override
	public String toString() {
		return "ScoreDTO [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum=" + sum
				+ ", average=" + average + "]";
	}

}
