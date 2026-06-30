<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Donors</title>
</head>
<body>
<h2>View Donor Records</h2>
<form action="MainServlet" method="post">
<input type="hidden" name="operation" value="viewRecord">
Donor Name:<input type="text" name="donorName"><br><br>
Donation Date:<input type="date" name="donationDate"><br><br>
<input type="submit" value="Search">
</form>
</body>
</html>