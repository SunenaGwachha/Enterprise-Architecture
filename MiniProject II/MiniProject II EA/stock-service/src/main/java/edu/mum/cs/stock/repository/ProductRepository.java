package edu.mum.cs.stock.repository;

import edu.mum.cs.stock.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
