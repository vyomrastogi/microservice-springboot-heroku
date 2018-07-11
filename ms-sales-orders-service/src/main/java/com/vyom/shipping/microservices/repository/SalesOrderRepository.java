/**
 * 
 */
package com.vyom.shipping.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vyom.shipping.microservices.entity.SalesOrder;

/**
 * @author vyomr
 *
 */
@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {

}
