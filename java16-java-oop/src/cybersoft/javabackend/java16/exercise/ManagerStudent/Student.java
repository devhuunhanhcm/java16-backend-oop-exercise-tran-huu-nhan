package cybersoft.javabackend.java16.exercise.ManagerStudent;

import java.util.Scanner;

public class Student {
	private String name;
	private int id;
	private float mathScore;
	private float chemistryScore;
	private float physicalScore;
	private float agvScore;
	private String ratings = "Chưa xếp loại";

	public Student() {
	}

	public Student(String name, int id, float mathScore, float chemistryScore, float physicalScore) {
		this.name = name;
		this.id = id;
		this.mathScore = mathScore;
		this.chemistryScore = chemistryScore;
		this.physicalScore = physicalScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getMathScore() {
		return mathScore;
	}

	public void setMathScore(float mathScore) {
		this.mathScore = mathScore;
	}

	public float getChemistryScore() {
		return chemistryScore;
	}

	public void setChemistryScore(float chemistryScore) {
		this.chemistryScore = chemistryScore;
	}

	public float getPhysicalScore() {
		return physicalScore;
	}

	public void setPhysicalScore(float physicalScore) {
		this.physicalScore = physicalScore;
	}
	
	public float getAgvScore() {
		return agvScore;
	}

	public void setAgvScore(float agvScore) {
		this.agvScore = agvScore;
	}

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	public void configAgvScore() {
		this.agvScore = this.agvScore = (mathScore + chemistryScore + physicalScore) / 3;
	}

	public void configRatings() {
		float x = this.agvScore;
		if (x >= 9) {
			this.ratings = "Xuất Sắc";
		} else if (x < 9 && x >= 8) {
			this.ratings = "Giỏi";
		} else if (x < 8 && x >= 7) {
			this.ratings = "Khá";
		} else if (x >= 6 && x < 7) {
			this.ratings = "TB Khá";
		} else if (x < 6 && x >= 5) {
			this.ratings = "TB";
		} else {
			this.ratings = "Yếu";
		}
	}
	public void input(int i) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập vào tên sinh viên " + "["+ (i + 1) + "]: ");
		name = sc.nextLine();
		System.out.print("Nhập mã số sinh viên: ");
		id = Integer.parseInt(sc.nextLine());
		
		mathScore = validateScore("toán");
		chemistryScore = validateScore("hóa");
		physicalScore = validateScore("lý");
		
	}
	public float validateScore(String name) {
		Scanner sc = new Scanner(System.in);
		float score;
		do {
			System.out.print("Nhập vào điểm môn " + name + " : ");
			score = Float.parseFloat(sc.nextLine());
		}while(score > 10 || score < 0);
		
		return score;
	}

	public void display() {
		System.out.println("Tên: " + name
				+ " | MSSV: " + id 
				+ " | Toán: " + mathScore + " | Hóa: " + chemistryScore
				+ " | Lý: " + physicalScore 
				+ " | Điểm Trung bình: " + agvScore);
	}
	public void displayRatings() {
		System.out.println("Tên: " + name
				+ " | MSSV: " + id 
				+ " | Toán: " + mathScore
				+ " | Hóa: " + chemistryScore
				+ " | Lý: " + physicalScore 
				+ " | Điểm Trung bình: " + agvScore 
				+ " | Xếp loại: " + ratings);
	}

}
