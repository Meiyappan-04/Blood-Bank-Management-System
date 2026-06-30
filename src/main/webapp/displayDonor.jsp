<%@ page import="com.wipro.bloodbank.bean.BloodBankBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Donor Details</title>
</head>
<body>
<h2>Donor Details</h2><br><br>
<%BloodBankBean bean = (BloodBankBean)request.getAttribute("BloodBankBean");
if(bean == null){
%>
<h3>No matching records exists! Please try again!</h3>
<%
}
else{%>
<h2>Donor Details</h2>
Record ID : <%=bean.getRecordId()%><br><br>
Donor Name : <%=bean.getDonorName()%><br><br>
Blood Group : <%=bean.getBloodGroup()%><br><br>
Donation Date : <%=bean.getDonationDate()%><br><br>
Age : <%=bean.getAge()%><br><br>
Contact : <%=bean.getContact()%><br><br>
Remarks : <%=bean.getRemarks()%><br><br>
<%}%>
</body>
</html>