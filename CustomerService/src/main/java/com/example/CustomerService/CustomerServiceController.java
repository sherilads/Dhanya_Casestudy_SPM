package com.example.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableAutoConfiguration
@RequestMapping("/test")
public class CustomerServiceController {
@Autowired
private CustometService customerService;

@Autowired
private DiscoveryClient discoveryClient;

@RequestMapping("/service-instances/{applicationName}")
public List<ServiceInstance> serviceInstancesByApplicationName(
		@PathVariable String applicationName) {
	return this.discoveryClient.getInstances(applicationName);
}


@RequestMapping(value = "/Customers/{id}", method = RequestMethod.GET)
public @ResponseBody Customer getCustomer(@PathVariable("id") long id) throws
Exception { Customer customer = this.customerService.getbyid(id); return
customer; }


@RequestMapping(value="/Customers", method=RequestMethod.GET)
public @ResponseBody List<Customer> getAllCustomers() throws Exception{
	return this.customerService.displayCustomer();
}
@RequestMapping(value="/Customers",method=RequestMethod.POST)
	  public void addCustomers(@RequestBody Customer customer) throws Exception{
	 RestTemplate restTemplate = new RestTemplate();
	 long pid=customer.getPolicyid();
	 Map<String, Long> vars = new HashMap<String, Long>();
	 vars.put("pid", pid);
	 
	 
	Policy policy=restTemplate.getForObject("http://localhost:8888/data/Policy/{pid}",Policy.class,vars);
	customer.setPolicy(policy);
			 this.customerService.createCustomer(customer);
		
	  }
  

@RequestMapping(method=RequestMethod.PUT, value="/Customers/{id}") 
public void updateCategory(@RequestBody Customer customer, @PathVariable long id) {
	  this.customerService.updateCustomer(customer, id); }

@RequestMapping(method=RequestMethod.DELETE, value="/Customers/{id}") 
public void deleteCustomer(@PathVariable long id) {
	  this.customerService.deleteCustomer(id); }


}
