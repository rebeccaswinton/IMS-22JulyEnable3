package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class ItemsTest {
private Items items;

	@Before
	public void setup() {
		items = new Items();	
	}
	
	@Test
	public void constructorTest() {
		Items items = new Items(1L,"Polo Mint", 0.99, 12);
		Long actual = items.getId();
		Long expected = 1L;
		String actual1 = items.getTitle();
		String expected1 = "Polo Mint";
		Double actual2 = items.getPrice_decimal();
		Double expected2 = 0.99;
		int actual3 = items.getStock();
		int expected3 = 12;
		
		
		assertEquals(expected, actual, 1L);
		assertEquals(expected1, actual1, "Polo Mint");
		assertEquals(expected2, actual2, 0.99);
		assertEquals(expected3, actual3, 12);
		
	}
	@Test 
	public void noIdConstructorTest() {
		Items items = new Items ("Water Bottle", 0.79,8);
		String actual = items.getTitle();
		String expected = "Water Bottle";
		Double actual1 = items.getPrice_decimal();
		Double expected1 = 0.79;
		int actual2 = items.getStock();
		int expected2 = 8;
		
		assertEquals(expected, actual, "Water Bottle");
		assertEquals(expected1, actual1, 0.79);
		assertEquals(expected2, actual2, 8);
	
	}
	@Test
	public void hashCodeTest(){
		Items item1 = new Items("Solo 3 wireless headphones", 129.99, 32 );
		Items item2 = new Items("Solo 3 wireless headphones", 129.99, 32);
		Map<Items, String> map = new HashMap<>();
		map.put(item1, "Apple iPhone");
		
	assertEquals("Apple iPhone", map.get(item2));
		
		 
		}
}
