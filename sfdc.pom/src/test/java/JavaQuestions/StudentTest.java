package JavaQuestions;

import java.util.ArrayList;
import java.util.List;

public class StudentTest {

	public static void main(String[] args) {
		
		StudentHighestMarks s1 = new StudentHighestMarks("Tom", 1234, 100, 18);
		StudentHighestMarks s2 = new StudentHighestMarks("Peter", 1235, 90, 18);
		StudentHighestMarks s3 = new StudentHighestMarks("Lisa", 1236, 80, 18);
		StudentHighestMarks s4 = new StudentHighestMarks("Helen", 1237, 70, 18);
		
		// add all student obj to arrayList
		List<StudentHighestMarks> studentList = new ArrayList<StudentHighestMarks>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		
		System.out.println(studentList.size());
		
		for(StudentHighestMarks s : studentList){
			System.out.println(s);
		}

		//Top Student 
		StudentHighestMarks topStudent = null;
		int maxMarks =0;
		for(int i =0;i<studentList.size();i++){
	        if (studentList.get(i).getMarks() > maxMarks) {
	        	topStudent=studentList.get(i);
	        	maxMarks= studentList.get(i).getMarks();
	        }
	        }
		if(topStudent != null){
			System.out.println("Top Student Details : ");
			System.out.println("Name : " + topStudent.getName());
			System.out.println("Age : " + topStudent.getAge());
			System.out.println("Roll No : " + topStudent.getRollNum());
			System.out.println("Marks : " + topStudent.getMarks());
		}

		}
		

	

}
