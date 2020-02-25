package com.kj;

import java.util.List;

import com.kj.model.Customer;

public interface CustomerDao {
	
	
		public abstract List<Customer> getAllCustomer();
		public abstract Customer getCustomerById(int id);
		public abstract Customer addCustomer(Customer customer);

}
