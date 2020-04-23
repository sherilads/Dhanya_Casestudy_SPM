package com.example.SimplepoolicyManagement;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PolicyService {
	
	@Autowired
	private PolicyRepository policyRepository;
	public void createPolicy(Policy policy) {
		policyRepository.save(policy);
	}
	
	
	public List<Policy> Fetchallpolicy(){
	List <Policy> policylist = new ArrayList<Policy>();
		policyRepository.findAll().forEach(policylist::add);
	return policylist;
	}
	
	public void updatePolicy(Policy policy, int id) {
		System.out.println("At update");
		policyRepository.findById(id).get().setPolicynum(id);
		policyRepository.findById(id).get().setPolicyName(policy.getPolicyName());
		System.out.println("POlicyname :"+policyRepository.findById(id).get().getPolicyName());
		policyRepository.findById(id).get().setPolicPeriod(policy.getPolicPeriod());
		policyRepository.save(policyRepository.findById(id).get());
	}
    public void deletePolicy(int id) {
    	policyRepository.deleteById(id);
    }
    public Policy getpolicybyid(int id) {
    	return 	policyRepository.findById(id).get();
    
    	 
    }
}
