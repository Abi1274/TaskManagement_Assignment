<%@ page contentType="text/html;charset=UTF-8" %>

<center>

<div style="border:1px solid black; width:300px; padding:15px;">
<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>
<h2>${employee.employeeId == 0 ? "Add Employee" : "Edit Employee"}</h2>

<form action="${pageContext.request.contextPath}/employee/save" method="post">

    <input type="hidden" name="employeeId" value="${employee.employeeId}" />

    Name:<br>
    <input type="text" name="employeeName" value="${employee.employeeName}" required/><br><br>

    Email:<br>
    <input type="email" name="email" value="${employee.email}" required/><br><br>

    Department:<br>
    <input type="text" name="department" value="${employee.department}" required/><br><br>

    Designation:<br>
    <input type="text" name="designation" value="${employee.designation}"/><br><br>

    <button type="submit">Save</button>

</form>

<br>
<a href="${pageContext.request.contextPath}/employee/list">Back</a>

</div>

</center>