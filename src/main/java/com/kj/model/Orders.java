package com.kj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Orders {
	
	
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCurrency() {
	return currency;
}

public void setCurrency(String currency) {
	this.currency = currency;
}

public String getReceiptId() {
	return receiptId;
}

public void setReceiptId(String receiptId) {
	this.receiptId = receiptId;
}

public int getAmount() {
	return amount;
}

public void setAmount(int amount) {
	this.amount = amount;
}

public int getAttempt() {
	return attempt;
}

public void setAttempt(int attempt) {
	this.attempt = attempt;
}

private String name;

private String currency;

private String receiptId;

private int amount;

private int attempt;

private String razorpayOrderId;


public String getRazorpayOrderId() {
	return razorpayOrderId;
}

public void setRazorpayOrderId(String razorpayOrderId) {
	this.razorpayOrderId = razorpayOrderId;
}

}
