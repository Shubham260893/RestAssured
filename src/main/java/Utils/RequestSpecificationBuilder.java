package Utils;

import java.io.File;
import java.io.IOException;

import java.util.Map;

import org.apache.commons.io.filefilter.CanReadFileFilter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import PojoClasses.UserRegistration;
import PojoClasses.Token;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationBuilder {
	
	public static RequestSpecification request;
	public static ReadPropertyFile readFile;
	public static String username;
	public static String password;
	
	public static RequestSpecification buildRequest(String microserviceName) throws IOException
	
	{
		readFile= new ReadPropertyFile();
		readFile.readPropertyFile();
		
		switch(microserviceName.toLowerCase())
		{
		case "identity":
		
		request= RestAssured.given().log().all().baseUri(readFile.getProperty("identityURL")).contentType(ContentType.JSON);
		break;
		
		case "listing":
			
			request= RestAssured.given().log().all().baseUri(readFile.getProperty("listingURL")).contentType(ContentType.JSON);
			break;
		
		}
		return request;
		
	}
	public static String userRegistration() throws IOException
	{
		int Max=10000;
		int Min=1;
		int random=(int) (Math.random() * ((Max - Min) + 1));
		UserRegistration ur= new UserRegistration();
		username= "Test"+random;
		password= "123456";
		ur.setUserName(username);
		 ur.setPassword(password);
		ObjectMapper obj= new ObjectMapper();
		String registration= obj.writerWithDefaultPrettyPrinter().writeValueAsString(ur);
		System.out.println(registration);
		
		generateToken();
		
		return registration;
		
	}
	
	public static Response sendPostRequest(String resource)
	{
		
		Response response= request.when().post(resource);
		return response;
		
		
	}
	public static Map<String, Object> generateToken() throws StreamReadException, DatabindException, IOException
	{
		ObjectMapper obj= new ObjectMapper();
		 Map<String,Object> map= obj.readValue(new File(System.getProperty("user.dir")+"/src/main/java/Payloads/GetTokenPayload.json"), new TypeReference<Map<String,Object>>() {
		});
		
		map.put("userName", username);
		map.put("password", password);
		System.out.println(obj.writerWithDefaultPrettyPrinter().writeValueAsString(map));
		
		return map;
		
	}

}
