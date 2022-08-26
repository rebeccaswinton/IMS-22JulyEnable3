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
		return orders;
	}

	@Override
	public Orders create() {
	LOGGER.info("Please enter customer id");
	Long fk_customer_id = utils.getLong();	
	Orders orders = ordersDAO.create(new Orders(fk_customer_id));
	LOGGER.info("Order Created!");
	
	return orders;

	}

	@Override
	public Orders update() {
		LOGGER.info("Please enter the id for the order you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter the customer id");
		Long fk_customer_id = utils.getLong();
		Orders orders = ordersDAO.update(new Orders(id, fk_customer_id));
		return orders;

	}

	@Override
	public int delete() {
			LOGGER.info("Please enter the id of the order you would like to delete");
			Long id = utils.getLong();

			LOGGER.info("Order Deleted!");

			return ordersDAO.delete(id);
	}

}
