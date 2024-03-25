package com.app.service;


import java.util.List;

import com.app.model.Customer;
import com.app.model.Orders;

public interface OrderService {

	Orders saveOrder(Orders order);
	List<Orders> getAllOrders();
	List<Orders> getCustomerOrders(Customer customer);
	Orders findById(int id);
}
