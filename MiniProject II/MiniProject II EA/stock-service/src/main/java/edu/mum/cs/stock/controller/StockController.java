package edu.mum.cs.stock.controller;


import edu.mum.cs.stock.model.Product;
import edu.mum.cs.stock.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable("productId") Long productId){
        return productService.getProduct(productId);
    }

    @GetMapping("/check/{productId}")
    public Integer checkQuantity(@PathVariable("productId") Long productId){
        return productService.getProduct(productId).getProducQuantity();
    }



    @GetMapping("/all")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    
    @PostMapping("/addproduct")
    public Product addProduct(@RequestBody Product p) {
    	return productService.save(p);
    }
}
