package JavaQuestions;

public class StudentHighestMarks {

	private String name;
	private int rollNum;
	private int marks;
	private int age;
	
	public StudentHighestMarks(String name, int rollNum, int marks, int age) {
		this.name = name;
		this.rollNum = rollNum;
		this.marks = marks;
		this.age = age;
	}
	

	@Override
	public String toString() {
		return "StudentHighestMarks [name=" + name + ", rollNum=" + 
	rollNum + ", marks=" + marks + ", age=" + age + "]";
	}


	public String getName() {
		return name;
	}	

	public int getRollNum() {
		return rollNum;
	}	

	public int getMarks() {
		return marks;
	}	

	public int getAge() {
		return age;
	}	
	
}
