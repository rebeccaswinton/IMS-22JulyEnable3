package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrdersItemsDAO;
import com.qa.ims.persistence.domain.OrdersItems;
import com.qa.ims.utils.Utils;

public class OrdersItemsController implements CrudController<OrdersItems> {
	
	public static final Logger LOGGER = LogManager.getLogger();

	private OrdersItemsDAO ordersitemsDAO;
	private Utils utils;
	
	
	
	
	public OrdersItemsController(OrdersItemsDAO ordersitemsDAO, Utils utils) {
		super();
		this.ordersitemsDAO = ordersitemsDAO;
		this.utils = utils;
	}

	@Override
	public List<OrdersItems> readAll() {
		List<OrdersItems> ordersitems = ordersitemsDAO.readAll();	
		for (OrdersItems ordersitem : ordersitems) {
			LOGGER.info(ordersitem);
		}
		return ordersitems;
	}

	@Override
	public OrdersItems create() { 
		LOGGER.info("Please enter the order ID" );
		Long fk_order_id = utils.getLong();		
		LOGGER.info("Please enter the item ID");
		Long fk_item_id = utils.getLong();	
		LOGGER.info("Please enter the quantity");
		int quantity = utils.getInt();	
		OrdersItems ordersitems = ordersitemsDAO.create(new OrdersItems(fk_order_id, fk_item_id, quantity));
		LOGGER.info("Order-Item Created");
		return ordersitems;
	}

	@Override
	public OrdersItems update() {
		
		LOGGER.info(" Please enter the id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter the corresponding order ID" );
		Long fk_order_id = utils.getLong();		
		LOGGER.info("Please enter the corresponding item ID");
		Long fk_item_id = utils.getLong();	
		LOGGER.info("Please enter the quantity");
		int quantity = utils.getInt();	
		OrdersItems ordersitems = ordersitemsDAO.update(new OrdersItems(fk_order_id, fk_item_id, quantity));
		LOGGER.info("Order-Item Updated");
		return ordersitems;
}
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order-item you would like to remove");
		Long id = utils.getLong();
		LOGGER.info("Order-Item Deleted!");
		return ordersitemsDAO.delete(id);

	}

}
