package cybersoft.javabackend.java16.exercise.ManagerStudent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static <T> void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Student> studentList = new ArrayList<Student>();
		int choose,n;
		do {
			displayMenu();
			choose = Integer.parseInt(sc.nextLine());
			switch(choose) {
			case 1:
				System.out.print("Nhập số sinh viên cần thêm: ");
				n = Integer.parseInt(sc.nextLine());
				for (int i = 0; i < n; i++) {
					Student student = new Student();
					student.input(i);
					student.configAgvScore();
					student.configRatings();
					studentList.add(student);
				}
				break;
			case 2:
				for (Student student : studentList) {
					student.display();
				}
				break;
			case 3:
				Collections.sort(studentList, new Comparator<Student>() {
					@Override
					public int compare(Student o1, Student o2) {
						return o1.getAgvScore() > o2.getAgvScore() ? -1 : 1;
					}
				});
				for (Student student : studentList) {
					student.displayRatings();
				}
				break;
			case 4:
				System.out.println("GoodBye!!");
				break;
			default:
				System.err.println("Chọn lỗi!!");
				break;
			}
		}while(choose != 4);

	}
	public static void displayMenu() {
		System.out.println("1.Nhập thông tin sinh viên.");
		System.out.println("2.Hiển thị thông tin sinh viên.");
		System.out.println("3.Xếp loại sinh viên theo loại.");
		System.out.println("4.Thoát");
		System.out.print("Chọn: ");
	}

}
