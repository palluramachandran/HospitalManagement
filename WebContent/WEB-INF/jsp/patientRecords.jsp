<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Records</title>
</head>
<body>
<form:form>
	<input type="submit" value="View" onclick='this.form.action="viewPatient";'/>
	<input type="submit" value="Add" onclick='this.form.action="addPatient";'/>
	<input type="submit" value="Update" onclick='this.form.action="updatePatient";'/>
	<input type="submit" value="Delete" onclick='this.form.action="deletePatient";'/>
	

	<table>
		<tr>
			<th>Serial Number</th>
			<th>Patient Name</th>
			<th>Age</th>
		</tr>

		<c:forEach var="p" items="${patientList}">
			<tr>
				<td><input type="radio" name="id" value="${p.id}"/></td>
				<td><c:out value="${p.id}" /></td>
				<td><c:out value="${p.name}" /></td>
				<td><c:out value="${p.age}" /></td>
			</tr>
		</c:forEach>
	</table>
	</form:form>
</body>
</html>