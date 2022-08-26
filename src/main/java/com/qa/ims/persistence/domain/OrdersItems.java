package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrdersItems {
private Long id;
private Long fk_order_id;
private Long fk_item_id;
private int quantity;


public OrdersItems(Long id, Long fk_order_id, Long fk_item_id, int quantity) {
	super();
	this.id = id;
	this.fk_order_id = fk_order_id;
	this.fk_item_id = fk_item_id;
	this.quantity = quantity;

}
public OrdersItems(Long fk_order_id, Long fk_item_id, int quantity) {
	super();
	this.fk_order_id = fk_order_id;
	this.fk_item_id = fk_item_id;
	this.quantity = quantity;

}
public OrdersItems() {

}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Long getFk_order_id() {
	return fk_order_id;
}
public void setFk_order_id(Long fk_order_id) {
	this.fk_order_id = fk_order_id;
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

@Override
public String toString() {
	return "OrdersItems id: " + id + ", fk_order_id: " + fk_order_id + ", fk_item_id: " + fk_item_id + ", quantity: "
			+ quantity;
}
@Override
public int hashCode() {
	return Objects.hash(fk_item_id, fk_order_id, id, quantity);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	OrdersItems other = (OrdersItems) obj;
	return Objects.equals(fk_item_id, other.fk_item_id) && Objects.equals(fk_order_id, other.fk_order_id)
			&& Objects.equals(id, other.id) && quantity == other.quantity;
}








}


