<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Donors</title>
</head>
<body>
<h2>View All Donors Record</h2>
<form action="MainServlet" method="post">
<input type="hidden" name="operation" value="viewAllRecords"><br><br>
<input type="submit" value="View All Donors">
</form>
</body>
</html>