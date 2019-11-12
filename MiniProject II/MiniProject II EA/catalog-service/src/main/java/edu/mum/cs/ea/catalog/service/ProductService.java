package edu.mum.cs.ea.catalog.service;

import org.springframework.stereotype.Service;

import edu.mum.cs.ea.catalog.model.Product;

import java.util.List;

@Service
public interface ProductService {

    public String getProducts();
    public Product getProduct(Long productId);
    public Product save(Product product);

}
