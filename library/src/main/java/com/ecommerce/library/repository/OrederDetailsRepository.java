package com.ecommerce.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.library.model.OrderDetails;

import java.util.List;

@Repository
public interface OrederDetailsRepository extends JpaRepository<OrderDetails	, Long> {
    List<OrderDetails> findByOrderId(Long orderId);

}
