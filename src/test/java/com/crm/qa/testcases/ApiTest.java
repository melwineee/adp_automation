package com.crm.qa.testcases;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;


public class ApiTest{
	

	public ApiTest(){
		super();
	}
	
	public String generateRandomEmail(int length) {
	   
	    String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
	    String email = "";
	    String temp = RandomStringUtils.random(length, allowedChars);
	    email = temp.substring(0, temp.length() - 9) + "@gmail.com";
	    return email;
	}
	
	String apiToken ="8e82afb32e5acd2f1ffcd5f5229259c91ddd1f312ae3f363bc7fc3e814947eab";
	int userId;
	
	@Test(priority=1)
	public void createNewUserPositiveScenario(){
	try {	 
			OkHttpClient client = new OkHttpClient();
			String payload = "{\"name\":\"Test User\",\"email\":\""+generateRandomEmail(20)+"\",\"gender\":\"male\",\"status\":\"active\"}";
				MediaType mediaType = MediaType.parse("application/json");
				RequestBody body = RequestBody.create(mediaType, payload);
				Request request = new Request.Builder()
				  .url("https://gorest.co.in/public/v2/users")
				  .method("POST", body)
				  .addHeader("Authorization", "Bearer "+apiToken)
				  .addHeader("Content-Type", "application/json")
				  .build();
				Response response = client.newCall(request).execute();
if (response.code()==201) {
					
	System.out.println("Create New User API");
	System.out.println("Response Code: "+response.code());
String bodyString1 = response.body().string();

        JSONObject obj = new JSONObject(bodyString1);
     int   id = obj.getInt("id");
     System.out.println("ID: "+id);
     userId =id;
     System.out.println("Create New User API Positive Scenario Test Passed");	   
		        }
		        else {
		        	 System.out.println("Create New User API Positive Scenario Test Failed");
		        	Assert.fail("Create New User API Positive Scenario Test Failed");
		           
		        }
System.out.println("*************************************************");	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
@Test(priority=2)	
public void createNewPostPositiveScenario(){
		try {	 
			
			OkHttpClient client = new OkHttpClient();
					  
					MediaType mediaType = MediaType.parse("application/json");
					RequestBody body = RequestBody.create(mediaType, "{\r\n\r\n    \"user_id\": 1440251,\r\n    \"title\": \"Corporis vinum conitor aveho caelum alter viridis clamo.\",\r\n    \"body\": \"Iste deorsum tenetur. Aer cunctatio decerno. Arma abscido tunc. Amissio adipiscor itaque. Aegrotatio stultus confugo. Nesciunt officia appono. Ambulo curatio quo. Vere ullam curia. Candidus conitor tempora. Cuius cribro spoliatio. Admoneo velociter dolorem. Canonicus turba et.\"\r\n}");
					Request request = new Request.Builder()
					  .url("https://gorest.co.in/public/v2/posts")
					  .method("POST", body)
					  .addHeader("Authorization", "Bearer "+apiToken)
					  .addHeader("Content-Type", "application/json")
					  .build();
					Response response = client.newCall(request).execute();
if (response.code()==201) {
					
	System.out.println("Create New Post API Positive Scenario");
	System.out.println("Response Code: "+response.code());
String bodyString1 = response.body().string();

        JSONObject obj = new JSONObject(bodyString1);
     int   id = obj.getInt("id");
     System.out.println("ID: "+id);
     System.out.println("Create New Post API Positive Scenario Test Passed");	   
		        }
		        else {
		        	 System.out.println("Create New Post API Positive Scenario Test Failed");
		        	Assert.fail("Create New Post API Positive Scenario Test Failed");
		           
		        }
				
System.out.println("*************************************************");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

@Test(priority=3)	
public void createNewCommentPositiveScenario(){
		try {	 
			
			OkHttpClient client = new OkHttpClient();

			String payload = "{ \"post_id\": \"18695\", \"name\": \"Asha Asan\", \"email\": \""+generateRandomEmail(20)+"\", \"body\": \"Dolorem doloribus voluptatum. Ipsa tempore aut. Id perferendis doloribus.\" }";

					MediaType mediaType = MediaType.parse("application/json");
					RequestBody body = RequestBody.create(mediaType, payload);
					Request request = new Request.Builder()
					  .url("https://gorest.co.in/public/v2/comments")
					  .method("POST", body)
					  .addHeader("Authorization", "Bearer 8e82afb32e5acd2f1ffcd5f5229259c91ddd1f312ae3f363bc7fc3e814947eab")
					  .addHeader("Content-Type", "application/json")
					  .build();
					Response response = client.newCall(request).execute();
if (response.code()==201) {
					
	System.out.println("Create New Comment API Positive Scenario");
	System.out.println("Response Code: "+response.code());
String bodyString1 = response.body().string();

        JSONObject obj = new JSONObject(bodyString1);
     int   id = obj.getInt("id");
     System.out.println("ID: "+id);
     System.out.println("Create New Comment API Positive Scenario Test Passed");	   
		        }
		        else {
		        	 System.out.println("Create New Comment API Positive Scenario Test Failed");
		        	Assert.fail("Create New Comment API Positive Scenario Test Failed");
		           
		        }
				
System.out.println("*************************************************");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

@Test(priority=4)	
public void createtodoPositiveScenario(){
		try {	 
			
			OkHttpClient client = new OkHttpClient();
					MediaType mediaType = MediaType.parse("application/json");
					RequestBody body = RequestBody.create(mediaType, "{\"user_id\":"+userId+",\"title\":\"Administratio nihil vomica dedecor viduo auctor est.\",\"due_on\":\"2023-05-31T00:00:00.000+05:30\",\"status\":\"pending\"}");
					Request request = new Request.Builder()
					  .url("https://gorest.co.in/public/v2/todos")
					  .method("POST", body)
					  .addHeader("Authorization", "Bearer 8e82afb32e5acd2f1ffcd5f5229259c91ddd1f312ae3f363bc7fc3e814947eab")
					  .addHeader("Content-Type", "application/json")
					  .build();
					Response response = client.newCall(request).execute();
if (response.code()==201) {
					
	System.out.println("Create New Todo API Positive Scenario");
	System.out.println("Response Code: "+response.code());
String bodyString1 = response.body().string();

        JSONObject obj = new JSONObject(bodyString1);
     int   id = obj.getInt("id");
     System.out.println("ID: "+id);
     System.out.println("Create New Todo API Positive Scenario Test Passed");	   
		        }
		        else {
		        	 System.out.println("Create New Todo API Positive Scenario Test Failed");
		        	Assert.fail("Create New Todo API Positive Scenario Test Failed");
		           
		        }
				
System.out.println("*************************************************");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

@Test(priority=5)
public void createNewUserNegativeScenarioSameEmail(){
	// Using an already used email id to create a user
try {	 
		OkHttpClient client = new OkHttpClient();
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, "{\"name\":\"Tanushrhhi Siddngh\",\"email\":\"singh_tanuvvvshri@ddjast-schiller.test\",\"gender\":\"male\",\"status\":\"active\"}");
			Request request = new Request.Builder()
			  .url("https://gorest.co.in/public/v2/users")
			  .method("POST", body)
			  .addHeader("Authorization", "Bearer "+apiToken)
			  .addHeader("Content-Type", "application/json")
			  .build();
			Response response = client.newCall(request).execute();
if (response.code()==422) {
				
System.out.println("Create New User API Negative Scenario Negative Scenario with already used email id");
System.out.println("Response Code: "+response.code());
String bodyString1 = response.body().string().replace("[", "").replace("]", "");

    JSONObject obj = new JSONObject(bodyString1);
 	  String message= obj.getString("message");
 	 String field= obj.getString("field");
 	 
 System.out.println("message: "+field+" "+message);

 System.out.println("Test Passed : Unable to create User as "+field+" "+message);	        }
	        else {
	        	 System.out.println("Create New User API Negative Scenario with already used email id Test Failed");
	        	Assert.fail("Create New User API Negative Scenario with already used email id Test Failed");
	           
	        }
System.out.println("*************************************************");	
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}


@Test(priority=6)
public void createNewUserNegativeScenarioInvalidEmailFormat(){
	// Invalid Email Format
try {	 
		OkHttpClient client = new OkHttpClient();
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, "{\"name\":\"Tanushrhhi Siddngh\",\"email\":\"singh_tanuvvvshst-schiller.test\",\"gender\":\"male\",\"status\":\"active\"}");
			Request request = new Request.Builder()
			  .url("https://gorest.co.in/public/v2/users")
			  .method("POST", body)
			  .addHeader("Authorization", "Bearer "+apiToken)
			  .addHeader("Content-Type", "application/json")
			  .build();
			Response response = client.newCall(request).execute();
if (response.code()==422) {
				
System.out.println("Create New User API Negative Scenario Invalid Email Format");
System.out.println("Response Code: "+response.code());
String bodyString1 = response.body().string().replace("[", "").replace("]", "");

    JSONObject obj = new JSONObject(bodyString1);
 	  String message= obj.getString("message");
 	 String field= obj.getString("field");
 	 
 System.out.println("message: "+field+" "+message);

 System.out.println("Test Passed : Unable to create User as "+field+" "+message);	   
	        }
	        else {
	        	 System.out.println("Create New User API Negative Scenario Invalid Email Format Test Failed");
	        	Assert.fail("Create New User API Negative Scenario Invalid Email Format Test Failed");
	           
	        }
System.out.println("*************************************************");	
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

@Test(priority=7)
public void createNewUserNegativeScenarioMandatoryFieldMissing(){
	// Mandatory Field Missing
try {	 
		OkHttpClient client = new OkHttpClient();
		String payload = "{\"email\":\""+generateRandomEmail(20)+"\",\"gender\":\"male\",\"status\":\"active\"}";

			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, payload);
			Request request = new Request.Builder()
			  .url("https://gorest.co.in/public/v2/users")
			  .method("POST", body)
			  .addHeader("Authorization", "Bearer "+apiToken)
			  .addHeader("Content-Type", "application/json")
			  .build();
			Response response = client.newCall(request).execute();
if (response.code()==422) {
				
System.out.println("Create New User API Negative Scenario Mandatory Field Missing");
System.out.println("Response Code: "+response.code());
String bodyString1 = response.body().string().replace("[", "").replace("]", "");

    JSONObject obj = new JSONObject(bodyString1);
 	  String message= obj.getString("message");
 	 String field= obj.getString("field");
 	 
 System.out.println("message: "+field+" "+message);

 System.out.println("Test Passed : Unable to create User as "+field+" "+message);	   
	        }
	        else {
	        	 System.out.println("Create New User API Negative Scenario Mandatory Field Missing Failed");
	        	Assert.fail("Create New User API Negative Scenario Mandatory Field Missing Failed");
	           
	        }
System.out.println("*************************************************");	
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

@Test(priority=8)
public void fetchCreatedUserDetailsAndCompare(){
	// fetch Created User Details And Compare
try {	 
		OkHttpClient client = new OkHttpClient();

				Request request = new Request.Builder()
				  .url("https://gorest.co.in/public/v2/users/1511570")
				  .method("GET", null)
				  .addHeader("Authorization", "Bearer "+apiToken)
				  .build();
				Response response = client.newCall(request).execute();
if (response.code()==200) {
				
System.out.println("Fetch Created User Details And Compare");
System.out.println("Response Code: "+response.code());
String bodyString1 = response.body().string();

    JSONObject obj = new JSONObject(bodyString1);
    int   id = obj.getInt("id");
 	  String name= obj.getString("name");
 	 String email= obj.getString("email");
 	String gender= obj.getString("gender");
 	String status= obj.getString("status");
 	
 	if (id==1511570)  {
 		
 		 System.out.println("ID Hardcoded: 1511570 matcheswith ID from API: "+id);
 	}	else {
 		System.out.println("ID Hardcoded: 1511570 is not matching with ID from API: "+id);
 	}
 	
 	if (email.contentEquals("4z8e9ei1diy@gmail.com"))  {
 		
		 System.out.println("email Hardcoded: 4z8e9ei1diy@gmail.com matches with email from API: "+email);
	}	else {
		System.out.println("email Hardcoded: 4z8e9ei1diy@gmail.com is not matching with email from API: "+email);
	}
 	if (gender.contentEquals("male"))  {
 		
		 System.out.println("gender Hardcoded: male matches with gender from API: "+gender);
	}	else {
		System.out.println("gender Hardcoded: male is not matching with gender from API: "+gender);
	}
 	if (status.contentEquals("active"))  {
 		
		 System.out.println("status Hardcoded: active matches with status from API: "+status);
	}	else {
		System.out.println("status Hardcoded: active is not matching with status from API: "+status);
	}
	
  	   
	        }
	        else {
	        	 System.out.println("Create New User API Negative Scenario Mandatory Field Missing Failed");
	        	Assert.fail("Create New User API Negative Scenario Mandatory Field Missing Failed");
	           
	        }
System.out.println("*************************************************");	
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
