package com.example.demo.controllers;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.JwtTokenUtil;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.JwtRequest;
import com.example.demo.model.JwtResponse;
import com.example.demo.model.ResponseBody;
import com.example.demo.service.impl.JwtUserDetailsService;
import org.springframework.web.client.RestTemplate;


@RestController
public class JwtAuthenticationController {

	@Autowired
	UserRepository userRepository;
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
		return restTemplateBuilder.build();
	}


	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	private String userLoggedIn;
	private String userAddress;

	@Value("${STOCK_SERVICE:#{null}}")
	private String stockService;


	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);
		userLoggedIn = userDetails.getUsername();
		userAddress =  userRepository.findByEmail(userLoggedIn).getAddress();

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}



	
	@GetMapping("/viewauthorizedpage")
	public String  makeOrder(@RequestBody String userAddress){
		return "Only Authorised Users!";
	}

	@GetMapping("/viewProducts")
	public String viewProducts() {

		StringBuffer sb = new StringBuffer();

		final String uri = String.format("http://%s/stock/all", stockService);
		System.out.println(String.format("http://%s/stock/all", stockService));

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


		//return restTemplate.getForObject("http://localhost:8095/products/all", String.class);

	}
	
	

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
