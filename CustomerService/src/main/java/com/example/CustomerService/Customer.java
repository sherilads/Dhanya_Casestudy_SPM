package com.example.CustomerService;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	long id;
	String name;
	long phnum;
	long policyid;
	 @Embedded
	Invoice invoice;
	 @Embedded
	 Policy policy;
	 	public Customer() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhnum() {
		return phnum;
	}
	public void setPhnum(long phnum) {
		this.phnum = phnum;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	public long getPolicyid() {
		return policyid;
	}
	public void setPolicyid(long policyid) {
		this.policyid = policyid;
	}
	
	
}
