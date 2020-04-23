package com.example.SimplepoolicyManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class PolicyController {
	
	@Autowired
	private PolicyService policyService;
	
	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(
			@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}
	
	@RequestMapping(value="/Policy", method=RequestMethod.POST)
	public void CreatePolicy(@RequestBody Policy policy) {
		this.policyService.createPolicy(policy);
		
	}
   @RequestMapping(value="/Policy",method=RequestMethod.GET)
   public @ResponseBody List<Policy> Fetchallpolicy(){
	    return this.policyService.Fetchallpolicy();
     }
   
   
   @RequestMapping(value="/Policy/{id}", method=RequestMethod.GET)
	public @ResponseBody Policy FindPolicybyid(@PathVariable int id) {
		return this.policyService.getpolicybyid(id);
		
	}
   @RequestMapping(value="/Policy/{id}", method=RequestMethod.DELETE)
  	public void Deletepolicyid(@PathVariable ("id") int id) {
  		 this.policyService.deletePolicy(id);
}
   @RequestMapping(value="/Policy/{id}", method=RequestMethod.PUT)
 	public void Updatepolicy(@RequestBody Policy policy,@PathVariable int id) {
 		 this.policyService.updatePolicy(policy, id);
}
   
}
