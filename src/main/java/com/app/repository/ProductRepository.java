package com.app.repository;
import com.app.model.*;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findBySeller(Seller seller);

	List<Product> findByCategory(Category category);
	
}
