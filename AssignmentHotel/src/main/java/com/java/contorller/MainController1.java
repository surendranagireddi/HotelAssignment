package com.java.contorller;

import com.java.dto.GuestDTO;
import com.java.service.IGuestManagement;
import com.java.vo.GuestVO;

public final class  MainController1 {
	
	// HAS-A Property
	private IGuestManagement service;

	public MainController1(IGuestManagement service) {
		
		System.out.println("MainController.MainController()");
		this.service = service;
	}
	
	public String processResult(GuestVO vo) throws Exception {
		
		// convert vo object to dto obj
		GuestDTO dto = new GuestDTO();
		
		dto.setName(vo.getName());
		dto.setAddress(vo.getAddress());
		dto.setNoofdays(Integer.parseInt(vo.getNoofdays()));
		dto.setPdaycharge(Double.parseDouble(vo.getPdaycharge()));
		
		 //use SErvice
		 String resultMsg=service.registerGuest(dto);
		 return resultMsg;

		
	}
	

}
