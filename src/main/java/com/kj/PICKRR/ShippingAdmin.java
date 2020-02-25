package com.kj.PICKRR;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShippingAdmin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String   authToken;
	private String   from_name;
	private String   from_phone_number;
	private String   from_address;
	private String   from_pincode;
	private String   pickup_gstin;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getFrom_name() {
		return from_name;
	}
	public void setFrom_name(String from_name) {
		this.from_name = from_name;
	}
	public String getFrom_phone_number() {
		return from_phone_number;
	}
	public void setFrom_phone_number(String from_phone_number) {
		this.from_phone_number = from_phone_number;
	}
	public String getFrom_address() {
		return from_address;
	}
	public void setFrom_address(String from_address) {
		this.from_address = from_address;
	}
	public String getFrom_pincode() {
		return from_pincode;
	}
	public void setFrom_pincode(String from_pincode) {
		this.from_pincode = from_pincode;
	}
	public String getPickup_gstin() {
		return pickup_gstin;
	}
	public void setPickup_gstin(String pickup_gstin) {
		this.pickup_gstin = pickup_gstin;
	}
	
	

}
