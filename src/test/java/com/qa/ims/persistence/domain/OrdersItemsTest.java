package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class OrdersItemsTest {
private OrdersItems ordersItems;

@Before 
public void setUp() {
	ordersItems = new OrdersItems();
	
}
@Test
public void constructorTest () {
	OrdersItems ordersItems = new OrdersItems (1L, 3L, 3L, 2);
	Long actual = ordersItems.getId();
	Long expected = 1L;
	Long actual2 = ordersItems.getFk_order_id();
	Long expected2 = 3L;
	Long actual3 = ordersItems.getFk_item_id();
	Long expected3 = 3L;
	int actual4 = ordersItems.getQuantity();
	int expected4 = 2;

assertEquals(expected, actual, 1L);
assertEquals(expected2, actual2, 3L);
assertEquals(expected3, actual3, 3L);
assertEquals(expected4, actual4,2);

}
@Test
public void noIdConstructorTest ( ) {
	OrdersItems ordersItems = new OrdersItems(3L, 3L, 2);
	Long actual = ordersItems.getFk_order_id();
	Long expected = 3L;
	Long actual2 = ordersItems.getFk_item_id();
	Long expected2 = 3L;
	int actual3 = ordersItems.getQuantity();
	int expected3 = 2; 
	
	assertEquals(expected, actual, 3L);
	assertEquals(expected2, actual2, 3L);
	assertEquals(expected3, actual3,2);
}

@Test 
public void hashCodeTest () {
	OrdersItems ordersitem1 = new OrdersItems(3L, 3L, 2);
	OrdersItems ordersitem2 = new OrdersItems(3L, 3L, 2);
	Map<OrdersItems, Long> map = new HashMap<>();
	map.put(ordersitem1, 5L);
	
	assertEquals((Long)5L, map.get(ordersitem2));
	
}
}

