<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/11/7
  Time: 下午 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
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
</head>
<body>
   <table>
       <tr>
           <td colspan="5">
               <a href="/javaWeb/insertOrUpdateBook.jsp">新建</a>
           </td>
           <td>ID</td>
           <td>书名</td>
           <td>作者</td>
           <td>创建时间</td>
           <td>操作</td>
       </tr>
       <c:forEach var="book" items="${bookList}" varStatus="s">
       <tr>
           <td>${s.id}</td>
           <td>${book.name}</td>
           <td>${book.anther}</td>
           <td>${book.createTime}</td>
           <td>
               <a href="/javaWeb/book/toUpdate.do?${book.id}">修改</a>
               <a href="/javaWeb/book/del.do?${book.id}">删除</a>
           </td>
       </tr>
           </c:forEach>
       <tr>
           <td colspan="5">
               <a href="">首页</a>
               <a href="">上一页</a>
               <span>当前页/总页</span>
               <a href="">下一页</a>
           </td>
       </tr>
   </table>>
</body>
</html>
