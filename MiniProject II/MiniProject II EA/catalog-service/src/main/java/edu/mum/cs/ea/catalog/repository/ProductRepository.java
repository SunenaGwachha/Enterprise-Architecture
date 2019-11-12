package edu.mum.cs.ea.catalog.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.ea.catalog.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
