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

import com.qa.ims.controller.ItemsController;
import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

	@Mock
	private Utils utils;
	
	@Mock
	private ItemsDAO dao;
	
	@InjectMocks
	private ItemsController controller;

	@Test
	public void testCreate() {
		
	final String title = "Champagne hollywood Mirror LED lights";
	final double price_decimal = 49.99;
	final int stock = 15;
	final Items created = new Items(title, price_decimal, stock);
	
	
	Mockito.when(utils.getString()).thenReturn(title);
	Mockito.when(utils.getDouble()).thenReturn(price_decimal);
	Mockito.when(utils.getInt()).thenReturn(stock);
	Mockito.when(dao.create(created)).thenReturn(created);
	
	assertEquals(created, controller.create());
	

	Mockito.verify(utils, Mockito.times(1)).getString();
	Mockito.verify(utils, Mockito.times(1)).getDouble();
	Mockito.verify(utils, Mockito.times(1)).getInt();
	Mockito.verify(dao, Mockito.times(1)).create(created);

}
	@Test
	public void testReadAll() {
		List<Items> items = new ArrayList<>();
		items.add(new Items(1L, "Jane Linda Handheld Fan Rechargeable White", 11.99, 29 ));
		
		Mockito.when(dao.readAll()).thenReturn(items);
		
		assertEquals(items, controller.readAll());
		
		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
	@Test 
	public void updateTest() {
		Items updated = new Items (1L, "LG HD HDR LED TV", 299.99, 38);
		
		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getString()).thenReturn(updated.getTitle());
		Mockito.when(this.utils.getDouble()).thenReturn(updated.getPrice_decimal());
		Mockito.when(this.utils.getInt()).thenReturn(updated.getStock());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);
		
		assertEquals(updated, this.controller.update());
		
		Mockito.verify(this.utils,Mockito.times(1)).getLong();
		Mockito.verify(this.utils,Mockito.times(1)).getString();
		Mockito.verify(this.utils,Mockito.times(1)).getDouble();
		Mockito.verify(this.utils,Mockito.times(1)).getInt();
	}
	
	
	@Test
	public void deleteTest(){
		final long ID = 1L;
		
		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);
		
		assertEquals(1L, this.controller.delete());
		
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
		
	}
	

