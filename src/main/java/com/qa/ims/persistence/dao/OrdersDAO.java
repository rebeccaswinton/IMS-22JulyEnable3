package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrdersDAO implements Dao<Orders> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public Orders modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("order_id");
		Long fk_customer_id = resultSet.getLong("fk_customer_id");
		
		return new Orders(id, fk_customer_id);
}
@Override	
	public List<Orders> readAll() {
		try( Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");){
			List<Orders> orders = new ArrayList<Orders>();
			while(resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
				}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<Orders>();
			
	}
		
public Orders readLatest() {
	try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");){
		resultSet.next();
		return modelFromResultSet(resultSet);
	} catch (Exception e) {
		LOGGER.debug(e);
		LOGGER.error(e.getMessage());
	}
	return null;
}
// id is ignored
@Override
public Orders create(Orders orders) {
	try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO ORDERS (fk_customer_id) VALUES(?)");){
		statement.setLong(1, orders.getFk_customer_id());
		return readLatest();	
	}catch (Exception e) {
		LOGGER.debug(e);
		LOGGER.error(e.getMessage());
	}
	return null;
}
@Override
public Orders read(Long id) {
	try( Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM orders WHERE order_id = ?" );){
		statement.setLong(1, id);
		try( ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
		}
} catch (Exception e) {
	LOGGER.debug(e);
	LOGGER.error(e.getMessage());
}
	return null;	
	}
// takes in a order object, the id field will be used to
// update that order in the database
@Override
public Orders update(Orders orders) {
	try (Connection connection = DBUtils.getInstance().getConnection();
			PreparedStatement statement = connection
					.prepareStatement("UPDATE orders fk_customer_id = ? WHERE order_id = ?");){
					statement.setLong(1, orders.getFk_customer_id());
					statement.setLong(2, orders.getFk_customer_id());
					statement.executeUpdate();	
					return read(orders.getId());
					}catch (Exception e) {
						LOGGER.debug(e);
						LOGGER.error(e.getMessage());
					}
				return null;
			}

@Override
public int delete(long id) {
	try(Connection connection = DBUtils.getInstance().getConnection();
	PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE order_id = ?");) {
statement.setLong(1, id);
return statement.executeUpdate();
} catch (Exception e) {
LOGGER.debug(e);
LOGGER.error(e.getMessage());
}	
return 0;
}


}
	
	
