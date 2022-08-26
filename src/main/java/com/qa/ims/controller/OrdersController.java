package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

public class OrdersController implements CrudController<Orders> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrdersDAO ordersDAO;
	private Utils utils;
	

	public OrdersController(OrdersDAO ordersDAO, Utils utils) {
		super();
		this.ordersDAO = ordersDAO;
		this.utils = utils;
	}
// reads all orders to the logger
	@Override
	public List<Orders> readAll() {
		List<Orders> orders = ordersDAO.readAll();
		for (Orders order : orders) {
			LOGGER.info(order);
		}
		return null;
	}

	@Override
	public Orders create() {
	LOGGER.info("Please enter );
		return null;
	}

	@Override
	public Orders update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete() {
			LOGGER.info("Please enter the id of the customer you would like to delete");
			Long id = utils.getLong();
			return ordersDAO.delete(id);
	}

}
