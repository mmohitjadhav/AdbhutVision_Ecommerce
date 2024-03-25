package com.app.repository;
import com.app.model.*;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

	List<OrderDetails> findByOrders(Orders order);
	Optional<OrderDetails> findById(int id);
	
}
