<%--
  Created by IntelliJ IDEA.
  User: 46844
  Date: 2020/12/4
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改员工信息</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/empupdate" method="post" onsubmit="confirm('Are You 确定?')">
    <table>
        <tr>
            <td>员工编号</td>
            <td>
                ${emp.empno}
                <input type="hidden" name="empno" value="${emp.empno}">
            </td>
        </tr>
        <tr>
            <td>员工姓名</td>
            <td>
                <input type="text" name="ename" value="${emp.ename}">
            </td>
        </tr>
        <tr>
            <td>入职日期</td>
            <td>
                <input type="text" name="hiredate" value="${emp.hiredate}">
            </td>
        </tr>
        <tr>
            <td>工资</td>
            <td>
                <input type="number" name="sal" value="${emp.sal}">
            </td>
        </tr>
        <tr>
            <td>
                <button type="reset" >重置</button>
            </td>
            <td>
                <button type="submit" >修改</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
