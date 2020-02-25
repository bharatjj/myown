package com.kj.model;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.razorpay.Entity;
import com.razorpay.Order;

public class OrdersRazor  {
	



	@JsonIgnore
	private String idord;
	


public String getIdord() {
		return idord;
	}

	public void setIdord(String idord) {
		this.idord = idord;
	}


	@JsonIgnore
private String id;
private String currency;

private String receipt;

private int amount;


public String getId() {
	return id;
}

public String setId(String id) {
	return this.id = id;
}

public String getCurrency() {
	return currency;
}

public void setCurrency(String currency) {
	this.currency = currency;
}


public int getAmount() {
	return amount;
}

public void setAmount(int amount) {
	this.amount = amount;
}



public String getReceipt() {
	return receipt;
}

public void setReceipt(String receipt) {
	this.receipt = receipt;
}



}
