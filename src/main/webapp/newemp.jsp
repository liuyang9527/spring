<%--
  Created by IntelliJ IDEA.
  User: 46844
  Date: 2020/12/4
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增员工信息</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/empsave" method="post">
        <table>
            <tr>
                <td>员工姓名</td>
                <td>
                    <input type="text" name="ename" value="liuyang">
                </td>
            </tr>
            <tr>
                <td>入职日期</td>
                <td>
                    <input type="text" name="hiredate" value="2020-09-10">
                </td>
            </tr>
            <tr>
                <td>工资</td>
                <td>
                    <input type="number" name="sal" value="2020">
                </td>
            </tr>
            <tr>
                <td>
                    <button type="reset" >重置</button>
                </td>
                <td>
                    <button type="submit" >新增</button>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
