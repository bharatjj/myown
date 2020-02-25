package com.kj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kj.model.Customer;
import com.kj.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
