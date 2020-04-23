package com.example.CustomerService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustometService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public void createCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	public List<Customer> displayCustomer(){
		List <Customer> customerlist=new ArrayList<Customer>();
		customerRepository.findAll().forEach(customerlist::add);
		return customerlist;
	}
	public void updateCustomer(Customer customer,long id) {
		customerRepository.save(customer);
	}
	public void deleteCustomer(long id) {
		customerRepository.deleteById(id);
	}
	public Customer getbyid(long id) {
	return	customerRepository.findById(id).get();
	}

}
