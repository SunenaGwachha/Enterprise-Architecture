package edu.mum.cs.ea.catalog.service.Implementation;

import edu.mum.cs.ea.catalog.model.Product;
import edu.mum.cs.ea.catalog.repository.ProductRepository;
import edu.mum.cs.ea.catalog.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
//        return restTemplateBuilder.build();
//    }
//
//
//    @Autowired
//    private RestTemplate restTemplate;


    @Autowired
    private ProductRepository productRepository;

    @Override
    public String getProducts() {

//        return restTemplate.getForObject("http://stock-service.default.svc.cluster.local:8097/stock/all/", String.class);
        return null;
    }

    @Override
    public Product getProduct(Long productId) {
        return productRepository.findById(productId).get();
    }

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

}
