package com.wipro.bloodbank.service;

import com.wipro.bloodbank.bean.BloodBankBean;
import com.wipro.bloodbank.dao.BloodBankDAO;
import com.wipro.bloodbank.util.*;
import java.util.Date;
import java.util.List;

public class Administrator {
	public String addRecord(BloodBankBean bloodBean) {
		try {
			if(bloodBean==null || bloodBean.getDonorName()==null || bloodBean.getDonationDate()==null) {
				throw new InvalidInputException("Invalid input Error: ");
			}
			if(bloodBean.getDonorName().length()<2) {
				return "INVALID DONOR NAME";
			}
			if(bloodBean.getDonationDate().after(new Date())) {
				return "INVALID DATE";
			}
			BloodBankDAO dao = new BloodBankDAO();
			boolean recordExist=dao.recordExists(bloodBean.getDonorName(),bloodBean.getDonationDate());
			if(recordExist) {
				return "ALREADY EXISTS";
			}
			String recordId=dao.generateRecordID(bloodBean.getDonorName(), bloodBean.getDonationDate());
			bloodBean.setRecordId(recordId);
			return dao.createRecord(bloodBean);	
		}
		catch(InvalidInputException e) {
		    return "INVALID INPUT";
		}
		catch(Exception e) {
		    e.printStackTrace();
		    return "FAIL";
		}
	}
	
	public BloodBankBean viewRecord(String donorName,Date donationDate) {
		BloodBankDAO dao=new BloodBankDAO();
		return dao.fetchRecord(donorName, donationDate);
	}
	
	public List<BloodBankBean> viewAllRecords(){
		BloodBankDAO dao=new BloodBankDAO();
		return dao.fetchAllRecords();
	}
}
