<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<center>
<div style="border:1px solid black; width:600px; padding:15px;">

<h2>Employee List</h2>

<a href= "add">➕ Add Employee</a>
<br><br>
<form action="search" method="get">
    <input type="text" name="keyword" placeholder="Search by name"/>
    <button type="submit">Search</button>
</form>
<br>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Department</th>
        <th>Actions</th>
    </tr>

    <c:forEach items="${employees}" var="e">
        <tr>
            <td>${e.employeeId}</td>
            <td>${e.employeeName}</td>
            <td>${e.email}</td>
            <td>${e.department}</td>
            <td>
                <a href="edit/${e.employeeId}">Edit</a>
                <a href="${pageContext.request.contextPath}/employee/delete/${e.employeeId}">Delete</a>  </td>
        </tr>
    </c:forEach>
</table>
</div>

</center>