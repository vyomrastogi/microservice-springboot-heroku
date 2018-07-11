/**
 * 
 */
package com.vyom.shipping.microservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vyom.shipping.microservices.entity.OrderLineItem;

/**
 * @author vyomr
 *
 */
public interface OrderLineItemRepository extends JpaRepository<OrderLineItem, Long> {
	
	@Query(" select i.name from OrderLineItem i where i.orderId = ?1 ")
	public List<String> findItemNamesByOrderId(Long orderId);

}
