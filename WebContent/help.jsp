<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adventum</title>
<LINK href="resources/style.css" rel="stylesheet" type="text/css">
<LINK href="resources/jquery/jquery-ui.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="resources/jquery.js"></script>
<script type="text/javascript" src="resources/jquery/jquery-ui.min.js"></script>
<script type="text/javascript" src="resources/script.js"></script>
</head>



<body>
<div id="container">

<jsp:include page="head.jsp" />

<div class='content' >
	
	<ul style="text-align: left;">
		<li>Гость может просматривать страницы HELP, PUBLIC</li>
		<li>В галерею могут зайти только пользователи (те, кто прошел аутентификацию)</li>
		<li>В галерее картинки в желтой рамке могут просматривать только менеджеры</li>
		<li>Попасть в раздел "User control" могут только менеджеры или администраторы (для других пользователей ссылка скрыта)</li>
		<li>Редактировать, добавлять и удалять пользоватей могут только администраторы</li>
		
	</ul>
	
	
	
	
	<div class="back">	<a href="index.html">на главную</a></div>	
</div>


<jsp:include page="foot.jsp" />
</div>
</body>
</html>