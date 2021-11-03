package com.qa.rest.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.files.Payload;

import io.restassured.path.json.JsonPath;

public class SumValidation {
	
	@Test
	public void sumOfCourses(){
		int sum =0;
		JsonPath js = new JsonPath(Payload.coursePrice());
		//verify all prices = purchase amount
				int count = js.getInt("courses.size()");
				for(int i =0;i<count;i++){
					int Prices = js.getInt("courses["+i+"].price");
					int copies = js.getInt("courses["+i+"].copies");
					int amount = (Prices*copies);
					System.out.println(amount);
					sum = sum +amount;
				}
				System.out.println(sum);
				int totalPurchaseAmt = js.getInt("dashboard.purchaseAmount");
				Assert.assertEquals(totalPurchaseAmt, sum);

	}

}
