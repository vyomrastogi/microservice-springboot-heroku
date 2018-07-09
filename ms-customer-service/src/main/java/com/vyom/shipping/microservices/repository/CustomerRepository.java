/**
 * 
 */
package com.vyom.shipping.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vyom.shipping.microservices.entity.Customer;

/**
 * @author vyomr
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
