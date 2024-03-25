package com.app.repository;
import com.app.model.*;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{
	
	List<Orders> findByCustomer(Customer customer);
	
}
