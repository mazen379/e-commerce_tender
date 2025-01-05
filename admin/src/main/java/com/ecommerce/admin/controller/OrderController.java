package com.ecommerce.admin.controller;
import com.ecommerce.library.model.Order;
import com.ecommerce.library.model.OrderDetails;

import com.ecommerce.library.model.Category;
import com.ecommerce.library.service.CategoryService;
import com.ecommerce.library.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;


	/*@GetMapping("/orders")
	public String showAllOrders(Model model) {

		List<Order> orders = orderService.getAllOrdersWithDetails();
		model.addAttribute("orders", orders);
		return "admin-orders"; // Page Thymeleaf
	}*/
	@GetMapping("/orders")
	public String getOrders(Model model) {
		List<Order> orders = orderService.getAllOrdersWithDetails();

		model.addAttribute("orders", orders);
		return "admin-orders";
	}
	@GetMapping("/orders/{id}")

	public String getOrderById(@PathVariable Long id, Model model)  {
		Order order = orderService.getOrderById(id);

			// Ajout de l'objet Order au modèle pour l'afficher dans la vue
			model.addAttribute("order", order);
			// Retour de la vue HTML (par exemple 'admin-orders.html' si vous utilisez Thymeleaf)
			return "order_details";

		}

    }




