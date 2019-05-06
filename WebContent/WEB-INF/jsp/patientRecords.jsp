<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Records</title>
</head>
<body>
	<input type="button" value="View" />
	<input type="button" value="Add" />
	<input type="button" value="Update" />
	<input type="button" value="Delete" />

	<table>
		<tr>
			<th>Serial Number</th>
			<th>Patient Name</th>
			<th>Age</th>
		</tr>

		<c:forEach var="p" items="${patientList}">
			<tr>
				<td><c:out value="${p.id}" /></td>
				<td><c:out value="${p.name}" /></td>
				<td><c:out value="${p.age}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>