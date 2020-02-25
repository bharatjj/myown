package com.kj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kj.model.Customer;
import com.kj.repository.CustomerRepository;


@Service

public class CustomerDaoImpl implements CustomerDao{

	
	
	@Autowired
	CustomerRepository custrepo;
	
	
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return custrepo.findAll();
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return custrepo.findById(id).get();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return custrepo.save(customer);
	}
}
