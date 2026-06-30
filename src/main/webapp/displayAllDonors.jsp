<%@ page import="java.util.List"%>
<%@ page import="com.wipro.bloodbank.bean.BloodBankBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Donor Records</title>
</head>
<body>
<%
List<BloodBankBean> list = (List<BloodBankBean>)request.getAttribute("List");
if(list == null || list.isEmpty()){
%>
<h3>No records available!</h3>
<%
}
else{
for(BloodBankBean bean : list){
%>
<h2>Donor Details</h2>
Record ID : <%=bean.getRecordId()%><br>
Donor Name : <%=bean.getDonorName()%><br>
Blood Group : <%=bean.getBloodGroup()%><br>
Donation Date : <%=bean.getDonationDate()%><br>
Age : <%=bean.getAge()%><br>
Contact : <%=bean.getContact()%><br>
Remarks : <%=bean.getRemarks()%><br>
<hr>
<%}
}%>
</body>
</html>