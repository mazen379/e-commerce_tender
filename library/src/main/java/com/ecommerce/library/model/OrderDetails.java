package com.ecommerce.library.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetails {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_ordDetails;
	
	private int quantity;
	private double totalPrice,unitPrice;
	@ManyToOne
	@JoinColumn(name = "order_id")
	  private Order order;
	 @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	    @JoinColumn(name = "id_product", referencedColumnName = "id_product")
	private Product product;
}
