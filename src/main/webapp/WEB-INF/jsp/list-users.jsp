<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employees</title>
    <link rel="stylesheet" type="text/css"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
</head>

<body>
<br>
<div class="container">
    <div style="text-align: center">
        <div class="badge bg-dark text-center">
            <h5>All Employees</h5>
        </div>
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Email</th>
            <th>Password</th>

            <th>Operations</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${requestScope.users}">
            <%--<c:url var="updateBtn" value="/update">
                <c:param name="empId" value="${emp.id}"/>
            </c:url>--%>

            <%--<c:url var="deleteBtn" value="/delete">
                <c:param name="empId" value="${emp.id}"/>
            </c:url>--%>
            <tr>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td>
                    <input type="button" class="btn-dark" value="update"
                           onclick="window.location.href='${updateBtn}'"/>

                    <input type="button" class="btn-dark" value="delete"
                           onclick="window.location.href='${deleteBtn}'"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <input type="button" class="btn btn-dark" value="add"
           onclick="window.location.href='add'"/>
</div>
</body>
</html>
