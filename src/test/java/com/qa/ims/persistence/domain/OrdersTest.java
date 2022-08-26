package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class OrdersTest {
private Orders orders;
@Before
public void setUp() {
	orders = new Orders();
	}

@Test
public void getAndSetIdTest() {
	orders.setId(1L);
	Long actual = orders.getId();
	Long expected = 1L;
	assertEquals(expected, actual);
}
@Test
public void constructorTest() {
	Orders orders = new Orders(1L, 5L);
	Long actual = orders.getId();
	Long expected = 1L;
Long actual1 = orders.getFk_customer_id();
Long expected1 = 5L;

assertEquals(expected, actual, 1L);
assertEquals(expected1, actual1, 5L);

}

@Test
public void hashCodeTest() {
	Orders order1 = new Orders(1L,4L);
	Orders order2 = new Orders(1L, 4L);
	Map<Orders, Long> map = new HashMap<>(); 
	map.put(order1, 3L);
	assertEquals((Long)3L, map.get(order2));
}



}
