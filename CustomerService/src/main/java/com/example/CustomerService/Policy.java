package com.example.CustomerService;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class Policy {
	
	int policynum;
	String policyName;
	double policPeriod;
	
    public Policy() {
		
	}

	public int getPolicynum() {
		return policynum;
	}

	public void setPolicynum(int policynum) {
		this.policynum = policynum;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public double getPolicPeriod() {
		return policPeriod;
	}

	public void setPolicPeriod(double policPeriod) {
		this.policPeriod = policPeriod;
	}

	public Policy(int policynum, String policyName, double policPeriod) {
		super();
		this.policynum = policynum;
		this.policyName = policyName;
		this.policPeriod = policPeriod;
	}


}
