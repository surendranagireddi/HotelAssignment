package com.java.service;

import com.java.bo.GuestBO;
import com.java.dao.IGuestDAO;
import com.java.dto.GuestDTO;

public final class GuestManagementService implements IGuestManagement{
	
	// HAS -A property
	private IGuestDAO dao ;
	

	public GuestManagementService(IGuestDAO dao) {
		System.out.println("guestManagement:: 1 -param constructor");
		this.dao = dao;
	}
	@Override
	public String registerGuest(GuestDTO dto) throws Exception {
	System.out.println("GuestManagementService.registerGuest()");
	
	// write a business logic calucate amount;
	
	double amount = dto.getNoofdays()*dto.getPdaycharge();
	
	// prepare Guest bo class obj having persist data
	
	GuestBO bo = new GuestBO();
	bo.setName(dto.getName());
	bo.setAddress(dto.getAddress());
	bo.setNoofdays(dto.getNoofdays());
    bo.setAmount(amount);
	
		
		
	//use DAO
	int count= dao.insert(bo);
	//process the result
	 return  count==0?" Registration failed":"Registration succedded:: Total amount::"+amount;
}//method
	
}


