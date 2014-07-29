<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


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
	<c:choose>
		<c:when test="${not empty message}">
			<span class="error">Ошибка! <c:out value="${message}"></c:out></span>
		</c:when>
		<c:otherwise>
			Пользователь <c:out value="${name}"></c:out> удалён
		</c:otherwise>
	</c:choose>

	

	<div class="back"><a href="personal.html" >назад</a></div>	
	
</div>


<jsp:include page="../foot.jsp" />
</div>
</body>
</html>