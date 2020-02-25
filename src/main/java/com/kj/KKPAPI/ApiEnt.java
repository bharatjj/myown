package com.kj.KKPAPI;

public class ApiEnt {
	
	
	
	private String auth_token;
	private String item_name;
	private String from_name;
	private String from_phone_number;
	private String from_address;
	private String from_pincode;
	private String pickup_gstin ;//0
	private String to_name;
	private String to_phone_number;
	private String to_pincode;
	private String to_address;
	private String quantity ;   //0
	private String invoice_value;
	public String getAuth_token() {
		return auth_token;
	}
	public void setAuth_token(String auth_token) {
		this.auth_token = auth_token;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
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
	public String getTo_name() {
		return to_name;
	}
	public void setTo_name(String to_name) {
		this.to_name = to_name;
	}
	public String getTo_phone_number() {
		return to_phone_number;
	}
	public void setTo_phone_number(String to_phone_number) {
		this.to_phone_number = to_phone_number;
	}
	public String getTo_pincode() {
		return to_pincode;
	}
	public void setTo_pincode(String to_pincode) {
		this.to_pincode = to_pincode;
	}
	public String getTo_address() {
		return to_address;
	}
	public void setTo_address(String to_address) {
		this.to_address = to_address;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getInvoice_value() {
		return invoice_value;
	}
	public void setInvoice_value(String invoice_value) {
		this.invoice_value = invoice_value;
	}
	@Override
	public String toString() {
		return "ApiEnt [auth_token=" + auth_token + ", item_name=" + item_name + ", from_name=" + from_name
				+ ", from_phone_number=" + from_phone_number + ", from_address=" + from_address + ", from_pincode="
				+ from_pincode + ", pickup_gstin=" + pickup_gstin + ", to_name=" + to_name + ", to_phone_number="
				+ to_phone_number + ", to_pincode=" + to_pincode + ", to_address=" + to_address + ", quantity="
				+ quantity + ", invoice_value=" + invoice_value + "]";
	}
	public ApiEnt(String auth_token, String item_name, String from_name, String from_phone_number, String from_address,
			String from_pincode, String pickup_gstin, String to_name, String to_phone_number, String to_pincode,
			String to_address, String quantity, String invoice_value) {
		super();
		this.auth_token = auth_token;
		this.item_name = item_name;
		this.from_name = from_name;
		this.from_phone_number = from_phone_number;
		this.from_address = from_address;
		this.from_pincode = from_pincode;
		this.pickup_gstin = pickup_gstin;
		this.to_name = to_name;
		this.to_phone_number = to_phone_number;
		this.to_pincode = to_pincode;
		this.to_address = to_address;
		this.quantity = quantity;
		this.invoice_value = invoice_value;
	}
	
//	
//	private String cod_amount ;//default 0 then it is prepaid
//	private String client_order_id ;   //o
//	private String item_breadth ;  //o
//	private String item_height ;    //0
//	private String item_length ;    //0
//	
//	private String item_weight  ; 
//	
//	private boolean is_reverse  ;   ///default =true

	
	

}
