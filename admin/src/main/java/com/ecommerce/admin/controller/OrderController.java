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
	public String getOrderDetails(@PathVariable Long id, Model model) {
		// Vérifier si la commande existe
		Order order = orderService.getOrderById(id);
		if (order == null) {
			return "error";  // Retourner une page d'erreur si la commande n'est pas trouvée
		}

		// Ajouter l'objet 'order' au modèle
		model.addAttribute("order", order);

		// Retourner le template Thymeleaf
		return "order_details";  // Le nom du fichier HTML
	}
	@PostMapping("/orders/confirm/{orderId}")
	public String confirmOrder(@PathVariable Long orderId, RedirectAttributes redirectAttributes, Model model) {
//		boolean isConfirmed = orderService.confirmOrder(orderId);
//		if (isConfirmed) {
//			redirectAttributes.addFlashAttribute("successMessage", "Order confirmed successfully.");
//		} else {
//			redirectAttributes.addFlashAttribute("errorMessage", "Failed to confirm the order. Order not found or already confirmed.");
//		}
//		model.addAttribute("isConfirmed", isConfirmed);
		return "redirect:/orders/" + orderId;
	}

    }




