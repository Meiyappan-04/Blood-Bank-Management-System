<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Add Donor</h2>
<form action="MainServlet" method="post">
<input type="hidden" name="operation" value="newRecord">
Donor Name:<input type="text" name="donorName"><br><br>
Blood Group:<input type="text" name="bloodGroup"><br><br>
Donation Date:<input type="date" name="donationDate"><br><br>
Age:<input type="number" name="age"><br><br>
Contact:<input type="text" name="contact"><br><br>
Remarks:<input type="text" name="remarks"><br><br>
<input type="submit" value="Add">
</form>
</body>
</html>