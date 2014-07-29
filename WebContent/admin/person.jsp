<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<c:choose>
		<c:when test="${not empty message}">
			<c:out value="${message}" />
		</c:when>
		<c:otherwise>
			<c:if test="${not empty errors}">
				<ul class="errors">
				<c:forEach items="${errors}" var="err">
					<li><c:out value="${err}"></c:out></li>				
				</c:forEach>
				</ul>
			</c:if>
			<form:form action="/admin/person.html" modelAttribute="personForm"  method="POST">
					<table class="person">
					<tr>
						<td><span>Имя:</span></td><td><form:input path="firstName"   /></td>
					</tr>
					<tr>
						<td><span>Фамилия:</span></td><td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td><span>e-mail:</span></td><td><form:input path="email"/></td>
					</tr>
	
					
					<tr>
						<td><span>Роли:</span></td>
						<td>Adm:<form:checkbox  path="roleAdmin"/>
						Man:<form:checkbox   path="roleManager"/>
						Usr:<form:checkbox  path="roleUser"/></td>
						
					</tr>	
						
				</table>
				<button>Сохранить</button>
				<form:hidden  path="id"/>
			</form:form>
		</c:otherwise>
	</c:choose>



	
	
	<div class="back"><a href="personal.html" >назад</a></div>	
	</div>
</div>


<jsp:include page="../foot.jsp" />
</div>
</body>
</html>