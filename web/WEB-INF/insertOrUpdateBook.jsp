<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/11/12
  Time: 下午 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style type="text/css">
    table{
        width: 100%;
    }
    table id{
        border-color: #000000;
        border-width: 1px;
        border-style: solid;
    }
</style>
<head>
    <title>Title</title>
</head>
<body>
<form action="/javaWeb/book/insertOrUpdate.do" method="post">
    <input type="hidden" name="id" value="${book.id}"/>

    <table>
    <tr>
        <td>书名：</td>
        <td>
        <input type="text" name="name" value="${book.name}"/>
        </td>>
    </tr>
    <tr>
        <td>作者：</td>
        <td>
            <input type="text" name="anther" value="${book.anther}"/>
        </td>>
    </tr>
    <tr>
        <td colspan="2"></td>
        <td>
            <input type="submit" value="提交"/>
        </td>>
    </tr>
    </table>
</form>>
</body>
</html>
