
public class Library { 	//도서관 정보
	String name; 	//도서관명
	int user; 	// 이용자수
	int Manager; 	//관리자수 
	
}

class People { 	//이용자 정보
	 String userName; 	//이용자 이름
	 int PhoneNumber; 	//이용자 전화번호
	 
	 String userId; 	// 아이디
	 String userPassword; 	//비밀번호
	 String borrowedBooks; 	//빌린 책들
}

class Book { 	//책 정보
	String genre; 	//장르
	String category; 	//항목
	String title; 	//제목 
	String writer; 	//저자
	String publisingHouse;	//출판사
	int bookNumber; //책 번호
	int borrowedNumber; 	//빌린 횟수 
	boolean loanStatus = true;		//대출여부
	boolean popularity = false; 	//베스트셀러여부
		
}
