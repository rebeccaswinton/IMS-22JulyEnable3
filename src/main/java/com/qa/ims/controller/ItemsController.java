package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.Utils;

public class ItemsController implements CrudController<Items> {

	public static final Logger LOGGER = LogManager.getLogger();
	
	private ItemsDAO itemsDAO;
	private Utils utils;
	

	public ItemsController(ItemsDAO itemsDAO, Utils utils) {
		super();
		this.itemsDAO = itemsDAO;
		this.utils = utils;
	}
// reads all items to the logger
	@Override
	public List<Items> readAll() {
	List<Items> items = itemsDAO.readAll();	
	for(Items item : items) {
		LOGGER.info(item);
	}
	return items;
	}
// creates an item by taking in user input 
	@Override
	public Items create() {
		LOGGER.info("Please enter a Title" );
		String title  = utils.getString();
		LOGGER.info("Please enter the price of" + title);
		double price_decimal = utils.getDouble();
		LOGGER.info("Please enter the stock quantity");
		int stock = utils.getInt();	
		Items item = itemsDAO.create(new Items(title, price_decimal, stock));
		LOGGER.info("Item Created");
		return item;
		
	}
	// updates an item by taking in user input 
	@Override
	public Items update() {
		LOGGER.info(" Please enter the id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter a title of the item");
		String title = utils.getString();
		LOGGER.info("Please enter the price");
		double price_decimal = utils.getDouble();
		LOGGER.info("What is the stock quanity?");
		int stock = utils.getInt();
		Items item = itemsDAO.update(new Items(id, title, price_decimal, stock));
		LOGGER.info("Item Updated");
		return item;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to remove");
		Long id = utils.getLong();
		return itemsDAO.delete(id);
	}

}
