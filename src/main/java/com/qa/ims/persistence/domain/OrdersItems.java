package com.qa.ims.persistence.domain;

public class OrdersItems {
private Long id;
private Long fk_order_id;
private Long fk_item_id;
private int quantity;
private double price;

public OrdersItems(Long id, Long fk_order_id, Long fk_item_id, int quantity, double price) {
	super();
	this.id = id;
	this.fk_order_id = fk_order_id;
	this.fk_item_id = fk_item_id;
	this.quantity = quantity;
	this.price = price;
}
public OrdersItems(Long fk_order_id, Long fk_item_id, int quantity, double price) {
	super();
	this.fk_order_id = fk_order_id;
	this.fk_item_id = fk_item_id;
	this.quantity = quantity;
	this.price = price;
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
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
@Override
public String toString() {
	return "OrdersItems [id: " + id + ", fk_order_id: " + fk_order_id + ", fk_item_id: " + fk_item_id + ", quantity: "
			+ quantity + ", price: " + price;
}








}


