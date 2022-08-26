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
	  public void testCreate() { final Items created = new
	  Items(3L,"Apple iPhone 13 Pink",629.99,30); assertEquals(created,
	  DAO.create(created)); }
	  
	  @Test 
	  public void testReadAll() { List<Items> expected = new ArrayList<>();
	  expected.add(new Items(4L, "Handheld Fan Rechargeable Blue", 12.99, 21));
	  assertEquals(expected, DAO.readAll()); }
	  
	  @Test public void testReadLatest() { assertEquals(new
	  Items(3L,"Apple iPhone 13 Pink",629.99,30), DAO.readLatest());
	  
	  }
	  
	  @Test 
	  public void testRead() { final Long ID = 3L; assertEquals(new
	 Items(ID,"Apple iPhone 13 Pink",629.99,30), DAO.read(ID));
	  
	  }
	 
	  @Test
	  public void testUpdate() { final Items updated = new Items
	  (1L,"Apple iPhone 13 Pink",629.99,30); assertEquals(updated,
	  DAO.update(updated)); 
	  } 
	 

	@Test
	public void testDelete() {
		assertEquals(0, DAO.delete(4));
	}  
}