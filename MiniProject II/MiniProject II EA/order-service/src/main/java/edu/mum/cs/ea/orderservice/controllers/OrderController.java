package edu.mum.cs.ea.orderservice.controllers;

import edu.mum.cs.ea.orderservice.model.Orders;
import edu.mum.cs.ea.orderservice.model.Product;
import edu.mum.cs.ea.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.build();
    }


    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    OrderService orderService;

    @Value("${STOCK_SERVICE:#{null}}")
    private String stockService;

    @Value("${SHIPPING_SERVICE:#{null}}")
    private String shippingService;

    @Value("${PAYMENT_SERVICE:#{null}}")
    private String paymentService;




    @PostMapping("/add")
    public String addToOrder(@RequestBody String address, Product product){
        //Go to stock service and pick productQty by this productID;
        Long productId = product.getProductId();

        //Integer pdtQty =  restTemplate.getForObject("http://localhost:8097/stock/check/"+productId, Integer.class);

        final String uri = String.format("http://%s/stock/all", stockService);
        Integer pdtQty = restTemplate.getForObject(uri, Integer.class);

        if(pdtQty > 0){
            Orders order = new Orders(product.getProductAmount());
            order.setProducts(product);
            orderService.saveOrder(order);
        }
        return "Your Product has been addded to the cart, Please proceed to checkout to place your order";
    }

    @GetMapping("/checkout")
    public String checkout(){


        StringBuffer sb = new StringBuffer();

        final String uri = String.format("http://%s/payments/all", paymentService);

        String result="UNABLE TO CALL";

        try{
//            RestTemplate restTemplate = new RestTemplate();
            result = restTemplate.getForObject(uri, String.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            sb.append(result);
            return sb.toString();
        }

        //return productService.getProducts();
//        return restTemplate.getForObject("http://stock-service.default.svc.cluster.local:8097/stock/all/", String.class);


        //return restTemplate.getForObject("http://localhost:8080/payments/all", String.class);
    }
    @GetMapping("/checkout/{option}")
    public String checkoutoption(@PathVariable String option){

        StringBuffer sb = new StringBuffer();

        final String uri = String.format("http://%s/payments/"+option, paymentService);

        String result="UNABLE TO CALL";

        try{
//            RestTemplate restTemplate = new RestTemplate();
            result = restTemplate.getForObject(uri, String.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            sb.append(result);
            return sb.toString();
        }

        //return productService.getProducts();
//        return restTemplate.getForObject("http://stock-service.default.svc.cluster.local:8097/stock/all/", String.class);


       // return restTemplate.getForObject("http://localhost:8080/payments/"+option, String.class);
    }
    @GetMapping("/shipping")
    public String shipping(){

        StringBuffer sb = new StringBuffer();

        final String uri = String.format("http://%s/ship", shippingService);

        String result="UNABLE TO CALL";

        try{
//            RestTemplate restTemplate = new RestTemplate();
            result = restTemplate.getForObject(uri, String.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            sb.append(result);
            return sb.toString();
        }

        //return productService.getProducts();
//        return restTemplate.getForObject("http://stock-service.default.svc.cluster.local:8097/stock/all/", String.class);


       // return restTemplate.getForObject("http://localhost:8096/ship", String.class);
    }




}
