<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 46844
  Date: 2020/12/2
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
        td {
            width: 120px;
            height: 30px;
            text-align: center;
        }

        td:hover {
            box-shadow: 3px 3px 5px orangered;
        }

        tr:nth-child(even) {
            background-color: lightseagreen;
        }

        tr:nth-child(odd) {
            background-color: antiquewhite;
        }
    </style>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/findbyempno?empno={empno}">
    Empno:<input type="text" placeholder="编号" id="empno" name="empno">
    <input type="submit" value="精确查询">
</form>
<br>
<form method="post" action="${pageContext.request.contextPath}/findbyname">
    Ename:<input type="text" placeholder="姓名" id="ename" name="ename">
    <input type="submit" value="模糊查询">
</form>
<br>
<a href="${pageContext.request.contextPath}/newemp.jsp">添加</a>
<br><br>
<table id="empsInfo" border="1">
<%--    <%= new Date().toLocaleString()%>--%>
    <tr>
        <th>empno</th>
        <th>ename</th>
        <th>hiredate</th>
        <th>sal</th>
        <th>operation</th>
    </tr>
    <c:forEach items="${empsFromServer}" var="emp">
        <tr>
            <td>${emp.empno}</td>
            <td>${emp.ename}</td>
            <td>${emp.hiredate}</td>
            <td>${emp.sal}</td>
            <td>
                <a href="${pageContext.request.contextPath}/findbyempno?empno=${emp.empno}">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/empdelete?empno=${emp.empno}" onclick="return confirm('Are you 确定 ?')">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<script src="js/jquery.js" type="text/javascript"></script>
</body>
</html>

