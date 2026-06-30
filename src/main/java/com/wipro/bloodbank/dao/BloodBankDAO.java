package com.wipro.bloodbank.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.*;

import com.wipro.bloodbank.bean.*;
import java.util.List;
import java.util.ArrayList;

import com.wipro.bloodbank.util.DBUtil;

public class BloodBankDAO {
	public String createRecord(BloodBankBean bloodBean) {
		Connection con=DBUtil.getDBConnection();
		String query ="INSERT INTO BLOODBANK_TB (RECORDID, DONORNAME, BLOODGROUP, DONATION_DATE, AGE, CONTACT, REMARKS) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,bloodBean.getRecordId());
			ps.setString(2,bloodBean.getDonorName());
			ps.setString(3,bloodBean.getBloodGroup());
			ps.setDate(4,new java.sql.Date(bloodBean.getDonationDate().getTime()));
			ps.setInt(5,bloodBean.getAge());
			ps.setString(6,bloodBean.getContact());
			ps.setString(7,bloodBean.getRemarks());
			int rows=ps.executeUpdate();
			if(rows==1) {
				return bloodBean.getRecordId();
			}
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "FAIL";
	}
	
	public BloodBankBean fetchRecord(String donorName,Date donationDate) {
		Connection con=DBUtil.getDBConnection();
		String query="SELECT * FROM BLOODBANK_TB WHERE DONORNAME=? AND DONATION_DATE=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, donorName);
			ps.setDate(2, new java.sql.Date(donationDate.getTime()));
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
			    BloodBankBean bean = new BloodBankBean();
			    bean.setRecordId(rs.getString("RECORDID"));
			    bean.setDonorName(rs.getString("DONORNAME"));
			    bean.setBloodGroup(rs.getString("BLOODGROUP"));
			    bean.setDonationDate(rs.getDate("DONATION_DATE"));
			    bean.setAge(rs.getInt("AGE"));
			    bean.setContact(rs.getString("CONTACT"));
			    bean.setRemarks(rs.getString("REMARKS"));
			    return bean;
			}
			rs.close();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String generateRecordID(String donorName,Date donationDate) {
		String generatedRecordId=null;
		Connection con=DBUtil.getDBConnection();
		String query="SELECT BLOODBANK_SEQ.NEXTVAL FROM DUAL";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				int seqNo=rs.getInt(1);
				String dName=donorName.substring(0,2).toUpperCase();
				DateFormat format=new SimpleDateFormat("yyyyMMdd");
				String temp = format.format(donationDate);
				generatedRecordId=temp+dName+String.format("%02d",seqNo);
			}
			rs.close();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return generatedRecordId;
	}
	
	public boolean recordExists(String donorName,Date donationDate) {
		boolean status=false;
		BloodBankBean _bloodBean = fetchRecord(donorName, donationDate);
		if(_bloodBean!=null) {
			status=true;
		}
		return status;
	}
	
	public List<BloodBankBean> fetchAllRecords(){
		List<BloodBankBean> _list = new ArrayList<>();
		Connection con=DBUtil.getDBConnection();
		String query="SELECT * FROM BLOODBANK_TB";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				BloodBankBean bean = new BloodBankBean();
				System.out.println("Record Found: " + rs.getString("RECORDID"));
				bean.setRecordId(rs.getString("RECORDID"));
				bean.setDonorName(rs.getString("DONORNAME"));
				bean.setBloodGroup(rs.getString("BLOODGROUP"));
				bean.setDonationDate(rs.getDate("DONATION_DATE"));
				bean.setAge(rs.getInt("AGE"));
				bean.setContact(rs.getString("CONTACT"));
				bean.setRemarks(rs.getString("REMARKS"));
				_list.add(bean);
			}
			System.out.println("Total Records = " + _list.size());
			rs.close();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return _list;
	}
}
