package com.wipro.bloodbank.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.wipro.bloodbank.bean.BloodBankBean;
import com.wipro.bloodbank.service.Administrator;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet{
	public String addRecord(HttpServletRequest request) {
		try {
			BloodBankBean _bloodBean = new BloodBankBean();
			_bloodBean.setDonorName(request.getParameter("donorName"));
			_bloodBean.setBloodGroup(request.getParameter("bloodGroup"));
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			_bloodBean.setDonationDate(sdf.parse(request.getParameter("donationDate")));
			_bloodBean.setAge(Integer.parseInt(request.getParameter("age")));
			_bloodBean.setContact(request.getParameter("contact"));
			_bloodBean.setRemarks(request.getParameter("remarks"));
			Administrator admin=new Administrator();
			return admin.addRecord(_bloodBean);
			
		}
		catch(Exception e) {
		    e.printStackTrace();
		    return "FAIL";
		}
	}
	
	public BloodBankBean viewRecord(HttpServletRequest request) {
		try {
			String dName=request.getParameter("donorName");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date date=sdf.parse(request.getParameter("donationDate"));
			Administrator admin=new Administrator();
			return admin.viewRecord(dName, date);
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public List<BloodBankBean> viewAllRecords(HttpServletRequest request){
		try {
			Administrator admin=new Administrator();
			return admin.viewAllRecords();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String operation = request.getParameter("operation");
		if(operation.equals("newRecord")) {
			String result=addRecord(request);
			if(result.equals("FAIL")||result.equals("INVALID INPUT")) {
				response.sendRedirect("error.html");
			}
			else {
				response.sendRedirect("success.html");
			}
		}
		if(operation.equals("viewRecord")) {
			BloodBankBean _bloodBean=viewRecord(request);
			if(_bloodBean==null) {
				request.setAttribute("message", "No matching records exists! Please try again!");
				RequestDispatcher rd=request.getRequestDispatcher("displayDonor.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("BloodBankBean", _bloodBean);
				RequestDispatcher rd=request.getRequestDispatcher("displayDonor.jsp");
				rd.forward(request, response);
			}
		}
		if(operation.equals("viewAllRecords")) {
			List<BloodBankBean> _list=viewAllRecords(request);
			System.out.println("Servlet List Size = " +
			        (_list == null ? "NULL" : _list.size()));
			if(_list == null || _list.isEmpty()) {
				request.setAttribute("message","No records available!");
				RequestDispatcher rd=request.getRequestDispatcher("displayAllDonors.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("List",_list);
				RequestDispatcher rd=request.getRequestDispatcher("displayAllDonors.jsp");
				rd.forward(request, response);
			}
		}
	}
}