package com.qa.ims.persistence.domain;

import java.util.Objects;


public class Orders {
private Long id;
private Long fk_customer_id;


public Orders(Long id, Long fk_customer_id) {
	super();
	this.id = id;
	this.fk_customer_id = fk_customer_id;

}


public Orders(Long fk_customer_id) {
	super();
	this.fk_customer_id = fk_customer_id;

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



@Override
public String toString() {
	return "Orders id: " + id + ", fk_customer_id: " + fk_customer_id;
}


@Override
public int hashCode() {
	return Objects.hash(fk_customer_id, id);
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
	return Objects.equals(fk_customer_id, other.fk_customer_id) && Objects.equals(id, other.id);
}







}
