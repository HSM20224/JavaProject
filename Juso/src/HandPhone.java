import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HandPhone {
	static String fname = "C:\\temp\\juso.txt";

	static class address {
		String name;
		String age;
		String phone;

		address(String s1, String s2, String s3) {
			this.name = s1;
			this.age = s2;
			this.phone = s3;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String select = "";
		System.out.println("\n## 친구 연락처 관리 ## \n");

		while (select != "4") {
			print_menu();
			select = sc.next();

			switch (select) {
			case "1":
				view_juso();
				break;
			case "2":
				add_juso();
				break;
			case "3":
				delete_juso();
				break;
			case "4":
				return;
			default:
				System.out.println("\n 잘못 입력했어요. 다시 선택하세요.\n");
			}
		}
	}

	static void print_menu() {
		System.out.println("1. 연락처 출력");
		System.out.println("2. 연락처 등록");
		System.out.println("3. 연락처 삭제");
		System.out.println("4. 끝내기");
	}

	static void view_juso() {
		try {
			File file = new File(HandPhone.fname);
			FileReader fr = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fr);
			while (true) {
				String str = bufferedReader.readLine();
				if (str == null) {
					break;
				}
				System.out.println(str);
			}
			fr.close();
			bufferedReader.close();
		} catch (IOException e) {
			System.out.println(e);
		}

	}

	static void add_juso() {

		String name;
		String age;
		String phone;

		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력 ==> ");
		name = sc.next();
		System.out.println("나이를 입력 ==> ");
		age = sc.next();
		System.out.println("전화번호를 입력 ==> ");
		phone = sc.next();

		try {
			File file = new File(HandPhone.fname);
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			fw.write(name + "     " + age + "     " + phone + "\n");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			System.out.println(e);
		}

	}

	static void delete_juso() {
		
		int position;
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 행 번호는 ?");
		
		position = sc.nextInt()-1;
		
		File file = new File(HandPhone.fname);
		String dummy = "";
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			for (int i = 0; i < position; i++) {
				line = br.readLine();
				dummy += (line + "\r\n");
			}
			String delData = br.readLine();
			while ((line = br.readLine()) != null) {
				dummy += (line + "\r\n");
			}
			FileWriter fw = new FileWriter(HandPhone.fname);
			fw.write(dummy);
			fw.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
