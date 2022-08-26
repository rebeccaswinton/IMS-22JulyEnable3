package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

// import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {
	
private Customer customer;
	@Before
public void setup() {
		customer = new Customer();
		}		

	//@Test
	//public void testEquals() {
	//	EqualsVerifier.simple().forClass(Customer.class).verify();
	//}
	
@Test
	public void getAndSetIdTest() {
	customer.setId(1L);
	Long actual = customer.getId();
	Long expected = 1L;
	assertEquals(expected, actual);
	}
@Test
public void getAndSetFirstNameTest() {
	customer.setFirstName("Keely");
	String actual = customer.getFirstName();
	String expected = "Keely";
	assertEquals(expected, actual);
}

@Test
public void getAndSetLastNameTest(){
	customer.setSurname("Joseph");
	String actual = customer.getSurname();
	String expected = "Joseph";
	assertEquals(expected, actual);
}
@Test 
public void constructorTest() {
Customer customer = new Customer(1L, "Hayley", "Brown");
Long actual = customer.getId();
Long expected = 1L;
String actual1 = customer.getFirstName(); 
String expected1 = "Hayley"; 
String actual2 = customer.getSurname();
String expected2 = "Brown";

assertEquals(expected, actual, 1L);
assertEquals(expected1, actual1, "Hayley");
assertEquals(expected2, actual2, "Brown");

}

@Test
public void noIdConstructorTest2() {
Customer customer = new Customer("Jackie", "Topaz");
String actual1 = customer.getFirstName();
String expected1 = "Jackie";
String actual2 = customer.getSurname();
String expected2 = "Topaz";

assertEquals(expected1, actual1); 
assertEquals(expected2, actual2);
}	
@Test
	public void hashCodeTest() {
	Customer customer1 = new Customer("Jenny","Harper");
	Customer customer2 = new Customer("Jenny", "Harper");
	Map<Customer, String> map = new HashMap<>();
	map.put(customer1, "Patrick");
			assertEquals("Patrick",map.get(customer2));
	
	

	
	}
	
	
	
	
}
