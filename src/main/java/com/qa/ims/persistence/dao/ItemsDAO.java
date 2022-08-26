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

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;

public class ItemsDAO implements Dao<Items> {

	public static final Logger LOGGER = LogManager.getLogger();
	
	
	@Override
	public Items modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("item_id");
		String title = resultSet.getString("title");
		double price_decimal = resultSet.getDouble("price_decimal");
		int stock = resultSet.getInt("stock");
		return new Items (id, title, price_decimal, stock);
	}
	
	
	// reading all items and returns as a list
@Override
	public List<Items> readAll() {
		try(Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items");){
			List<Items> items = new ArrayList<Items>();
			while (resultSet.next()) {
				items.add(modelFromResultSet(resultSet));
			}
			return items;
		}
		catch(SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<Items>();
	}

	
	public Items readLatest() {
		try(Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items");){
			resultSet.next();
			return modelFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
		return null;
	}
// takes in item object, id is ignored
	@Override
	public Items create(Items items) {
		try(Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO items(title, price_decimal, stock) VALUES(?, ?,?)");){
			statement.setString(1, items.getTitle());
			statement.setDouble(2, items.getPrice_decimal());
			statement.setInt(3, items.getStock());
			statement.executeUpdate();
			return readLatest();		
			} catch(Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
		return null;
	} 
// read items by id
	@Override
	public Items read(Long id) {
	    try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM items WHERE item_id = ?" );){
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
	public Items update(Items items) {
		try (Connection connection = DBUtils.getInstance().getConnection();
	PreparedStatement statement = connection
			.prepareStatement("UPDATE items SET title = ?, price_decimal = ?, stock = ? WHERE item_id =?");){
			statement.setString(1, items.getTitle());
			statement.setDouble(2, items.getPrice_decimal());
			statement.setInt(3, items.getStock());
			statement.setLong(4, items.getId());
			statement.executeUpdate();	
			return read(items.getId());
			}catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
		return null;
	}
// delete item by id
	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE item_id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}	
		return 0;
	}



 

	

}
