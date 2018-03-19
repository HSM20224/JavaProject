
public class Date40 {
	private int year;
	private String month;
	private int day;
	
	public Date40(){ // �⺻ ������
		this(1900,"1��",1);
	}
	public Date40(int year){ // ������ 
		this(year,"1��",1);
	}
	public Date40(int year, String month, int day){ //������
		this.year = year; //this�� ���� ��ü�� ����Ų��
		this.month = month;
		this.day = day;
	}
	@Override
	public String toString(){
		return "Date[year ="+year+ ", month ="+month+", day="+day+"]";
	}
	
	public static void main(String[] args){
		Date40 date1 = new Date40(2015, "8��", 10);
		Date40 date2 = new Date40(2020);
		Date40 date3 = new Date40();
		System.out.println(date1);
		System.out.println(date2);
		System.out.println(date3);
	}
}
