package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Items {
private Long id;
private String title;
private double price_decimal;
private int stock;



public Items(Long id, String title, double price_decimal, int stock) {
	super();
	this.id = id;
	this.title = title;
	this.price_decimal = price_decimal;
	this.stock = stock;
}



public Items(String title, double price_decimal, int stock) {
	super();
	this.title = title;
	this.price_decimal = price_decimal;
	this.stock = stock;
}



public Items() {

}



public Long getId() {
	return id;
}



public void setId(Long id) {
	this.id = id;
}



public String getTitle() {
	return title;
}



public void setTitle(String title) {
	this.title = title;
}



public double getPrice_decimal() {
	return price_decimal;
}



public void setPrice_decimal(double price_decimal) {
	this.price_decimal = price_decimal;
}



public int getStock() {
	return stock;
}



public void setStock(int stock) {
	this.stock = stock;
}



@Override
public String toString() {
	return "Items: [id: " + id + ", title: " + title + ", price: " + price_decimal + ", stock: " + stock;
}



@Override
public int hashCode() {
	return Objects.hash(id, price_decimal, stock, title);
}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Items other = (Items) obj;
	return Objects.equals(id, other.id)
			&& Double.doubleToLongBits(price_decimal) == Double.doubleToLongBits(other.price_decimal)
			&& stock == other.stock && Objects.equals(title, other.title);
}


















}
