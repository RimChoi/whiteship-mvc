<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maseong
  Date: 2020-05-27
  Time: 오후 3:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>EVENT LIST</h1>
    <h2>${message}</h2>
    <table>
        <thead>
            <tr>
                <th>이름</th>
                <th>시작</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${events}" var="event">
                <tr>
                    <td>${event.name}</td>
                    <td>${event.starts}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
