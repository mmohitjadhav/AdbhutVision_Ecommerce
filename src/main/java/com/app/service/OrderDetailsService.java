package com.app.service;


import java.util.List;
import com.app.model.OrderDetails;
import com.app.model.Orders;


public interface OrderDetailsService {

	void saveOrderDetails(OrderDetails od);
	OrderDetails findById(int id);
	List<OrderDetails> findByOrder(Orders order);
	
}
