package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.OrdersItems;
import com.qa.ims.utils.DBUtils;

public class OrdersItemsDAO implements Dao<OrdersItems>{
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public OrdersItems modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("order_item_id");
		Long fk_order_id = resultSet.getLong("fk_order_id");
		Long fk_item_id = resultSet.getLong("fk_item_id");
		int quantity = resultSet.getInt("quantity");
		
		return new OrdersItems(id, fk_order_id, fk_item_id, quantity);
	}
	
@Override
	public List<OrdersItems> readAll() {
		try( Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders_items");){
			List<OrdersItems> ordersItems = new ArrayList<OrdersItems>();
			while(resultSet.next()) {
				ordersItems.add(modelFromResultSet(resultSet));
				}
			return ordersItems;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<OrdersItems>();		
	}
		
public OrdersItems readLatest()	{
	try(Connection connection = DBUtils.getInstance().getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM orders_items ORDER BY order_item_id DESC LIMIT 1"); ){
		resultSet.next();
		return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
	return null;
}
// id ignored as it is auto increment
@Override 
	public OrdersItems create(OrdersItems ordersItems) {
	try (Connection connection = DBUtils.getInstance().getConnection();
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO orders_items(fk_order_id, fk_item_id, quantity) VALUES (?, ?, ?)");) {
		statement.setLong(1, ordersItems.getFk_order_id());
		statement.setLong(2, ordersItems.getFk_item_id());
		statement.setInt(3, ordersItems.getQuantity());
		statement.executeUpdate();
		return readLatest();
	} catch (Exception e) {
		LOGGER.debug(e);
		LOGGER.error(e.getMessage());
	}
	return null;
	}
// read by id
@Override
	public OrdersItems read(Long id) {
	try (Connection connection = DBUtils.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders_items WHERE order_item_id = ?");) {
		statement.setLong(1, id);
		try (ResultSet resultSet = statement.executeQuery();) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		}
	} catch (Exception e) {
		LOGGER.debug(e);
		LOGGER.error(e.getMessage());
	}
	return null;
}
	

	@Override
	public OrdersItems update(OrdersItems ordersItems) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE orders_items SET fk_order_id = ?, fk_item_id = ?, quantity = ? WHERE order_item_id = ?");) {
			statement.setLong(1, ordersItems.getFk_order_id());
			statement.setLong(2, ordersItems.getFk_item_id());
			statement.setInt(3, ordersItems.getQuantity());
			statement.executeUpdate();
			return read(ordersItems.getId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long id) {
		try(Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders_items WHERE order_item_id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
			} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
			}	
		return 0;
	}

	

}
