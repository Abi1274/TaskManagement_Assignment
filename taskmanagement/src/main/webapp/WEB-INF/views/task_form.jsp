<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<center>
<div style="border:1px solid black; width:600px; padding:15px;">
<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>
<h2>Add Task</h2>

<form action="${pageContext.request.contextPath}/task/save" method="post">

    <input type="hidden" name="taskId" value="${task.taskId}">

    Title: <input type="text" name="taskTitle" value="${task.taskTitle}" /><br><br>

    Description: <input type="text" name="description" value="${task.description}" /><br><br>

    Priority:
    <select name="priority">
        <option ${task.priority == 'HIGH' ? 'selected' : ''}>HIGH</option>
        <option ${task.priority == 'MEDIUM' ? 'selected' : ''}>MEDIUM</option>
        <option ${task.priority == 'LOW' ? 'selected' : ''}>LOW</option>
    </select><br><br>

    Status:
    <select name="status">
        <option ${task.status == 'PENDING' ? 'selected' : ''}>PENDING</option>
        <option ${task.status == 'IN_PROGRESS' ? 'selected' : ''}>IN_PROGRESS</option>
        <option ${task.status == 'COMPLETED' ? 'selected' : ''}>COMPLETED</option>
    </select><br><br>

    Assign Employee:
    <select name="empId">
        <c:forEach items="${employees}" var="e">
            <option value="${e.employeeId}"
                ${task.assignedEmployee != null && task.assignedEmployee.employeeId == e.employeeId ? 'selected' : ''}>
                ${e.employeeName}
            </option>
        </c:forEach>
    </select><br><br>

    <button type="submit">Save</button>
   
</form>
<br>
<a href="list">⬅ Back to Task List</a>
</div>
</center>