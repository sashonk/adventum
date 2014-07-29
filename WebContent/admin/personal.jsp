<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adventum</title>
<LINK href="../resources/jquery/jquery-ui.min.css" rel="stylesheet" type="text/css">
<LINK href="../resources/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../resources/jquery.js"></script>
<script type="text/javascript" src="../resources/jquery/jquery-ui.min.js"></script>
<script type="text/javascript" src="../resources/script.js"></script>
</head>



<body>
<div id='container'>
<jsp:include page="../head.jsp" />

<div class='content'>
		<div class="center">
		<div>кол-во администраторов <b><c:out value="${admin_count}"></c:out></b></div>
		<div>кол-во пользователей <b><c:out value="${user_count}"></c:out></b></div>
		<div>кол-во менеджеров <b><c:out value="${manager_count}" ></c:out></b></div>
		
		
	<table class="personal">
	<c:forEach items="${data}" var="item">

					<tr><td><c:out value="${item.lastName}"></c:out></td>
					<td><a href="person.html?id=${item.id}" >редактировать</a><br><a href="delete.html?id=${item.id}" >удалить</a>
					</td></tr>
		
	</c:forEach>
	</table>
	<div><a href="create.html" >добавить</a></div>
	<div class="back">	<a href="../index.html" >вверх</a></div>	
	

</div>
</div>

<jsp:include page="../foot.jsp" />
</div>
</body>
</html>