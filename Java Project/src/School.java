
public class School {
	String name;
	String majorName;
	String type;
	String building;
	int student;
	
	void print() {
		System.out.println("�б����� "+name+ "�Դϴ�. �л���"+student+ "�� �Դϴ�.�ǹ��� "+building+ "�� �ֽ��ϴ� ."  );
		System.out.println("�а��� ������ "+majorName+"�� �ֽ��ϴ�. �б��� "+type+"����б� �Դϴ�.");
	}
}

 class Room { 
	 int number;
	 String name;
	 
	 void print() {
		 System.out.println("���� "+number+"��, ���� ������" +name+"�� �ֽ��ϴ�. ");
	 }
 }
 
 class Student { 
	 int carStudent;
	 int itStudent;
	 String carSkill;
	 String itSkill;
	 
	 void print() {
		 System.out.println("�����ڵ����� �л��� "+carStudent+"��, �����ڵ����� ��ɹ���" +itStudent+"���̰�, ");
		 System.out.println("�ڵ���IT�� ��ɹ��� "+carSkill+ "�� ��ϰ� �ְ�, �ڵ���IT�� ��ɹ��� "+itSkill+"�� ��ϰ� �ֽ��ϴ�.");
	 }
 }
 
 

