package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.java.bo.GuestBO;

public final class GuestDAOImpl implements IGuestDAO{
	
	private  static final String  GUEST_INSERT_QUERY="INSERT INTO HOTELBILL(GNAME,GADDRESS,NOOFDAYS,AMOUNT)  VALUES(?,?,?,?)";
	
	 //HAS -A property
		private  DataSource ds;
		
	
	

	public GuestDAOImpl(DataSource ds) {
		super();
		System.out.println("Guestdao :: 1- param constructor");
		this.ds = ds;
	}

	@Override
	public int insert(GuestBO gbo) throws Exception {
		
		System.out.println("GuestDAOImpl.insert()");
		int count =0;
		
		// get pooled jdbc connection
		
		try(Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(GUEST_INSERT_QUERY)){
			if(ps !=null) {
				
				ps.setString(1, gbo.getName());
				ps.setString(2, gbo.getAddress());
			
				ps.setInt(3, gbo.getNoofdays());
				ps.setDouble(4, gbo.getAmount());
				
				//execute the query
				 count  =ps.executeUpdate();
				 
			}
		}catch(SQLException se) {
	   		   se.printStackTrace();
	  		   throw se;
	   	   }
	   	   catch(Exception e) {
	   		   e.printStackTrace();
	   		   throw e;
	   	   }
		return count;
	}
}
