package edu.mum.cs.stock.service;

import edu.mum.cs.stock.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    public List<Product> getProducts();
    public Product getProduct(Long productId);
    public Product save(Product product);

}
