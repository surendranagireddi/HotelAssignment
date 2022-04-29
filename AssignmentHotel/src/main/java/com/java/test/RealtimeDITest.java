package com.java.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.java.contorller.MainController1;
import com.java.vo.GuestVO;

public class RealtimeDITest {
	
	public static void main(String[] args) {
		//read inputs from enduser   as String values
		Scanner sc=new Scanner(System.in);
		String name=null,addrs=null,pdaycharge=null,noofdays=null;
		if(sc!=null) {
			System.out.println("Enter guest name::");
			name=sc.next();
			System.out.println("Enter  guest address::");
			addrs=sc.next();
			System.out.println("Enter  perday charge ::");
			pdaycharge=sc.next();
			System.out.println("Enter  number of days::");
			noofdays=sc.next();
		
		}
		//prepare VO class obj having inputs
		GuestVO  vo=new GuestVO();
		
		vo.setName(name);
		vo.setAddress(addrs);
		vo.setPdaycharge(pdaycharge);
		vo.setNoofdays(noofdays);
	
		//create  IOC container
		DefaultListableBeanFactory  factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/java/cfgs/applicationContext.xml");
		//get Controller class obj
		MainController1 controller=factory.getBean("controller",MainController1.class);
		try {
			//invoke the b.method
			String resultMsg=controller.processResult(vo);
			System.out.println(resultMsg);
		}
		catch(Exception e) {
			System.err.println("Problem in guest registration::"+e.getMessage());
			e.printStackTrace();
		}
		

	}//main

}
