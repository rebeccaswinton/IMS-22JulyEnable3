package com.qa.ims.persistence.dao;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;

public class ItemsDAOTest {
	
	private final ItemsDAO DAO = new ItemsDAO();
	
	@Before
public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}		
		
	
	@Test
	public void testCreate() {
		final Items created = new Items(2L,"Champagne hollywood Mirror LED lights",49.99,15);
		assertEquals(created, DAO.create(created));
	}
	
	@Test
	public void testReadAll() {
		List<Items> expected = new ArrayList<>();
		expected.add(new Items(1L, "Jane Linda Handheld Fan Rechargeable White", 11.99, 29));
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testReadLatest() {
	assertEquals(new Items(3L,"Champagne hollywood Mirror LED lights",49.99,15), DAO.readLatest());
	
	}
	
	@Test 
	public void testRead() {
		final Long ID = 2L;
		assertEquals(new Items(ID,"Champagne hollywood Mirror LED lights",49.99,15), DAO.read(ID));
		
	}
	
	@Test
	public void testUpdate() {
	final Items updated = new Items (1L,"Apple iPhone 13 Pink",629.99,30);
	assertEquals(updated, DAO.update(updated));
	}
	
	
	 @Test
	 public void testDelete() {
		 assertEquals(1, DAO.delete(1));
	 }
	
}