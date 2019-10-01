<%@ page import="java.util.concurrent.atomic.AtomicInteger" %>
<%--
  Created by IntelliJ IDEA.
  User: 16079
  Date: 29.09.2019
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stat</title>
</head>
<body>
<%
    AtomicInteger countMale = (AtomicInteger) request.getAttribute("male");
    AtomicInteger countFemale = (AtomicInteger) request.getAttribute("female");
    AtomicInteger countMarried = (AtomicInteger) request.getAttribute("married");
    AtomicInteger countSingle = (AtomicInteger) request.getAttribute("single");
%>
Статистика ответов<br>
<table>
    <tr>
        <td>Пол </td>
        <td>М </td>
        <td><%= countMale%> </td>
        <td>Ж </td>
        <td><%= countFemale%> </td>
    </tr>
    <br>
    <tr>
        <td>Брак </td>
        <td>В браке </td>
        <td><%= countMarried%> </td>
        <td>Не в браке </td>
        <td><%= countSingle%> </td>
    </tr>
    <br>
</table>
</body>
</html>
