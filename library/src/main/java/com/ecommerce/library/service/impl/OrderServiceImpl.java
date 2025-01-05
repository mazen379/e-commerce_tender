package com.ecommerce.library.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.library.model.CartItem;
import com.ecommerce.library.model.Order;
import com.ecommerce.library.model.OrderDetails;
import com.ecommerce.library.model.ShoppingCart;
import com.ecommerce.library.repository.CartitemRepository;
import com.ecommerce.library.repository.OrderRepository;
import com.ecommerce.library.repository.OrederDetailsRepository;
import com.ecommerce.library.repository.ShoppingCartRepository;
import com.ecommerce.library.service.OrderService;

import javax.validation.constraints.Null;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrederDetailsRepository detailsRepository;
	@Autowired
	private ShoppingCartRepository cartRepository;
	@Autowired
	private CartitemRepository cartitemRepository;
	@Override
	public void saveOrder(ShoppingCart shoppingCart) {
		Order order = new Order();
		order.setOrderStatus("PINDING");
		order.setOrderDate(new Date());
		order.setTotalPrice(shoppingCart.getTotalPrice());
		order.setUser(shoppingCart.getUser());
		List<OrderDetails> orderDetailsList=new ArrayList<>();
		
		for(CartItem cartItem : shoppingCart.getCartItem())
		{
			OrderDetails details=new OrderDetails();
			details.setOrder(order);
			details.setProduct(cartItem.getProduct());
			details.setQuantity(cartItem.getQuantity());
			details.setUnitPrice(cartItem.getProduct().getCastPrice_prod());
			details.setTotalPrice(shoppingCart.getTotalPrice());
			detailsRepository.save(details);
			orderDetailsList.add(details);
			cartitemRepository.delete(cartItem);
			
		}
		order.setOrderDetailList(orderDetailsList);
		shoppingCart.setCartItem(new HashSet<>());
		shoppingCart.setTotlaitem(0);
		shoppingCart.setTotalPrice(0);
		cartRepository.save(shoppingCart);
		orderRepository.save(order);
	}

	@Override
	public List<Order> getAllOrdersWithDetails() {
		// Récupère toutes les commandes avec leurs détails
		List<Order> orders = orderRepository.findAll();
		orders.forEach(order -> {
			// Charge les détails de chaque commande, vous pouvez aussi utiliser @EntityGraph pour éviter des requêtes supplémentaires
			order.setOrderDetailList(detailsRepository.findByOrderId(order.getId()));
		});
		return orders;
	}

	@Override
	public Order getOrderById(Long orderId) {
		// Récupère une commande par son ID
		Order order = orderRepository.findById(orderId).orElse(null);

		return order; // ou lever une exception comme EntityNotFoundException
	}

	@Override
	public OrderDetails getOrderDetailsById(Long id) {
		// Récupère les détails d'une commande par son ID
		Optional<OrderDetails> orderDetails = detailsRepository.findById(id);
		return orderDetails.orElse(null); // ou lever une exception si vous préférez
	}

	@Override
	public Order getOrderWithDetails(Long orderId) {
		// Récupère une commande avec ses détails
		Optional<Order> order = orderRepository.findById(orderId);
		if (order.isPresent()) {
			order.get().setOrderDetailList(detailsRepository.findByOrderId(orderId));
			return order.get();
		}
		return null; // ou lever une exception comme EntityNotFoundException
	}

}
