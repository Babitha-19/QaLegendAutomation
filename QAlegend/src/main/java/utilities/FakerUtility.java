package utilities;

import java.util.Random;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;

public class FakerUtility {
	public static String getFirstFakeName() { //to create fake name
		
		Faker faker=new Faker();
		Address address=faker.address();  //interface
		String firstname=address.firstName();
		return firstname;
		
	}
	
public static String getLastFakeName() {
		
		Faker faker=new Faker();
		Address address=faker.address();
		String lastname=address.lastName();
		return lastname;
		
	}

	public static int randomNumberGenerator() {
		
		Random rand= new Random();
		int randomnumber=rand.nextInt(10000);
		return randomnumber;
	}

}
