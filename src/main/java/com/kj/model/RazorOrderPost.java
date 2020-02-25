package com.kj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RazorOrderPost {

	
	@JsonIgnore
private String id;
private String currency;

private String receipt;

private int amount;



public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getCurrency() {
	return currency;
}

public void setCurrency(String currency) {
	this.currency = currency;
}

public String getReceipt() {
	return receipt;
}

public void setReceipt(String receipt) {
	this.receipt = receipt;
}

public int getAmount() {
	return amount;
}

public void setAmount(int amount) {
	this.amount = amount;
}



}
