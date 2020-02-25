package com.kj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kj.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
