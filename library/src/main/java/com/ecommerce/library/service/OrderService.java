package com.ecommerce.library.service;

import com.ecommerce.library.model.Order;
import com.ecommerce.library.model.OrderDetails;
import com.ecommerce.library.model.ShoppingCart;

import java.util.List;

public interface OrderService {

	void saveOrder(ShoppingCart shoppingCart);
	 List<Order> getAllOrdersWithDetails();
	Order getOrderById(Long orderId);
	OrderDetails getOrderDetailsById(Long id);
	Order getOrderWithDetails(Long orderId);
	boolean confirmOrder(Long orderId);
}
