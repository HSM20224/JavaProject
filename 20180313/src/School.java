
public class School {
	String name;
	String majorName;
	String type;
	String building;
	int student;
	
	void print() {
		System.out.println("학교명은 "+name+ "입니다. 학생은"+student+ "명 입니다.건물은 "+building+ "이 있습니다 ."  );
		System.out.println("학과의 종류는 "+majorName+"가 있습니다. 학교는 "+type+"고등학교 입니다.");
	}
}

 class Room { 
	 int number;
	 String name;
	 
	 void print() {
		 System.out.println("실은 "+number+"개, 실의 종류는" +name+"이 있습니다. ");
	 }
 }
 
 class Student { 
	 int carStudent;
	 int itStudent;
	 String carSkill;
	 String itSkill;
	 
	 void print() {
		 System.out.println("에코자동차과 학생은 "+carStudent+"명, 에코자동차과 기능반은" +itStudent+"명이고, ");
		 System.out.println("자동차IT과 기능반은 "+carSkill+ "을 운영하고 있고, 자동차IT과 기능반은 "+itSkill+"을 운영하고 있습니다.");
	 }
 }
 
 

