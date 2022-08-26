package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.OrdersItems;
import com.qa.ims.utils.DBUtils;

public class OrdersItemsDAOTest {

private final OrdersItemsDAO DAO = new OrdersItemsDAO();


@Before
public void setUp() {
	DBUtils.connect();
	DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");	
}

@Test
public void testCreate() {
	final OrdersItems created = new OrdersItems(1L,1L,5);
	assertEquals(created, DAO.create(created));
}


}

