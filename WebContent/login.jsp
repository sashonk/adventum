<%@page import="adventum.dao.PersonDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adventum</title>
<LINK href="resources/style.css" rel="stylesheet" type="text/css">
<LINK href="resources/jquery/jquery-ui.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="resources/jquery.js"></script>
<script type="text/javascript" src="resources/jquery/jquery-ui.min.js"></script>
<script type="text/javascript" src="resources/script2.js"></script>
</head>



<body>
<div id="container">

<jsp:include page="head.jsp" />

<div class='content'>
	<div class="center">
<form name="f" action="j_spring_security_check" method="POST">
<table cellspacing="5">
    <tr>
	<td>Логин</td>
	<td><input name="j_username" /></td>
    <tr>

    <tr>
	<td>Пароль</td>
	<td><input name="j_password" type="password" /></td>
    </tr>



</table>

    <div style='margin:5px;'><input type="checkbox" name="j_spring_remember_me" /> запомнить меня</div>
    <div style='margin:5px;'><input type="submit" /></div>
</form>


<c:if test="${not empty param.fail}"><div style='color: #ff0000;'>Неверное имя пользователя/пароль! </div></c:if>


	<div class="back">	<a href="index.html" >на главную</a></div>	
</div>
	<div >

<jsp:include page="foot.jsp" />
</div>
</body>
</html>

