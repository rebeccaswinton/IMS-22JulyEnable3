package com.qa.ims.persistence.domain;

import java.sql.Date;
import java.util.Objects;


public class Orders {
private Long id;
private Long fk_customer_id;
private Long fk_item_id;
private int quantity; 
private float total;
private Date datePlaced;


public Orders(Long id, Long fk_customer_id, Long fk_item_id, int quantity, float total, Date datePlaced) {
	super();
	this.id = id;
	this.fk_customer_id = fk_customer_id;
	this.fk_item_id = fk_item_id;
	this.quantity = quantity;
	this.total = total;
	this.datePlaced = datePlaced;
}


public Orders(Long fk_customer_id, Long fk_item_id, int quantity, float total, Date datePlaced) {
	super();
	this.fk_customer_id = fk_customer_id;
	this.fk_item_id = fk_item_id;
	this.quantity = quantity;
	this.total = total;
	this.datePlaced = datePlaced;
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public Long getFk_customer_id() {
	return fk_customer_id;
}


public void setFk_customer_id(Long fk_customer_id) {
	this.fk_customer_id = fk_customer_id;
}


public Long getFk_item_id() {
	return fk_item_id;
}


public void setFk_item_id(Long fk_item_id) {
	this.fk_item_id = fk_item_id;
}


public int getQuantity() {
	return quantity;
}


public void setQuantity(int quantity) {
	this.quantity = quantity;
}


public float getTotal() {
	return total;
}


public void setTotal(float total) {
	this.total = total;
}


public Date getDatePlaced() {
	return datePlaced;
}


public void setDatePlaced(Date datePlaced) {
	this.datePlaced = datePlaced;
}


@Override
public String toString() {
	return "Orders [id=" + id + ", fk_customer_id=" + fk_customer_id + ", fk_item_id=" + fk_item_id + ", quantity="
			+ quantity + ", total=" + total + ", datePlaced=" + datePlaced + "]";
}


@Override
public int hashCode() {
	return Objects.hash(datePlaced, fk_customer_id, fk_item_id, id, quantity, total);
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Orders other = (Orders) obj;
	return Objects.equals(datePlaced, other.datePlaced) && fk_customer_id == other.fk_customer_id
			&& fk_item_id == other.fk_item_id && Objects.equals(id, other.id) && quantity == other.quantity
			&& Float.floatToIntBits(total) == Float.floatToIntBits(other.total);
}








}
