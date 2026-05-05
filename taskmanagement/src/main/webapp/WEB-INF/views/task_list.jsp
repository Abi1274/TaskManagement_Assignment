<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<center>
<div style="border:1px solid black; width:600px; padding:15px;">

<h2>Task List</h2>

<a href="add">➕ Add Task</a>
<br><br>

<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Description</th> <!-- ✅ added -->
        <th>Status</th>
        <th>Priority</th>
        <th>Employee</th>
        <th>Actions</th>
    </tr>

    <c:forEach items="${tasks}" var="t">
        <tr>
            <td>${t.taskId}</td>
            <td>${t.taskTitle}</td>
            <td>${t.description}</td> <!-- ✅ added -->
            <td>${t.status}</td>
            <td>${t.priority}</td>
            <td>${t.assignedEmployee.employeeName}</td>

            <td>
                <a href="edit/${t.taskId}">Edit</a> |
                <a href="delete/${t.taskId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</div>

</center>