package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrdersItemsController;
import com.qa.ims.persistence.dao.OrdersItemsDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.persistence.domain.OrdersItems;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrdersItemsControllerTest {
	@Mock
	private Utils utils;

	@Mock
	private OrdersItemsDAO dao;

	@InjectMocks
	private OrdersItemsController controller;
	
	@Test
	public void testCreate() {
		final Long fk_order_id = 1L, fk_item_id = 1L;
		final int quantity = 4;
		final OrdersItems created = new OrdersItems(fk_order_id, fk_item_id, quantity);

		Mockito.when(utils.getLong()).thenReturn(fk_order_id, fk_item_id);
		Mockito.when(utils.getInt()).thenReturn(quantity);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(2)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
	
	
	
	@Test
	public void testReadAll() {
		List<OrdersItems> ordersItems = new ArrayList<>();
		ordersItems.add(new OrdersItems(1L, 1L,7));

		Mockito.when(dao.readAll()).thenReturn(ordersItems);

		assertEquals(ordersItems, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
@Test
	public void testUpdate() {
		OrdersItems updated = new OrdersItems(1L, 1L, 2);

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getInt()).thenReturn(2);
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(3)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getInt();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);

	}

	
public void testDelete() {
	final long ID = 1L;

	Mockito.when(utils.getLong()).thenReturn(ID);
	Mockito.when(dao.delete(ID)).thenReturn(1);

	assertEquals(1L, this.controller.delete());

	Mockito.verify(utils, Mockito.times(1)).getLong();
	Mockito.verify(dao, Mockito.times(1)).delete(ID);
	
	

}
}
