package com.qa.rest.test;

import com.qa.files.Payload;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonPath js = new JsonPath(Payload.coursePrice());
		//print no of courses
		int count = js.getInt("courses.size()");
		System.out.println(count);
		//print purchase amt
		int total_amt = js.getInt("dashboard.purchaseAmount");
		System.out.println(total_amt);
		//print first title
		String title_firstCourse = js.get("courses[0].title");
		System.out.println(title_firstCourse);
		//course title and resp prices
		for(int i =0;i<count;i++){
			String courseTitle = js.get("courses["+i+"].title");
			int Prices = js.getInt("courses["+i+"].price");
			System.out.println("Course Title is : "+ courseTitle + " and Course Price is " + " ::: "+ Prices);

		}
		//get copies only when title is RPA
		for(int i =0;i<count;i++){
			String courseTitle = js.get("courses["+i+"].title");
			if(courseTitle.equalsIgnoreCase("RPA")){
				int copies = js.get("courses["+i+"].copies");
				System.out.println(copies);
				break;
			}

		}
		

	}

}
