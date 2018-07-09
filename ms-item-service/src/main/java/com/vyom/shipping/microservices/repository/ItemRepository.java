/**
 * 
 */
package com.vyom.shipping.microservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vyom.shipping.microservices.entity.Item;

/**
 * @author vyomr
 *
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

	public List<Item> findByNameIn (List<String> name);
}
