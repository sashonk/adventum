<%@page import="org.springframework.security.core.Authentication"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    

<div class="header">
	<div class="hleft">
		ADVENTUM TEST
	</div>
	<div class="hright">
	Приветствие, 
		<c:choose>
			<c:when test="${not empty sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}">
				<c:out value=" ${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}"></c:out>

			</c:when>
			<c:otherwise>
				<c:out value=" гость"></c:out>			
			</c:otherwise>
			
		</c:choose>
	
		<br>
	
		<c:choose>
			<c:when test="${not empty sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}">
				<a href="<c:url value="/j_spring_security_logout" />" > выход</a>			

			</c:when>
			<c:otherwise>
				<a href="<c:url value="/login.html" />" > вход</a>				
			</c:otherwise>
			
		</c:choose>
			
</div>

<div class="hcenter">

</div>

<div class="clear"></div>
	
</div>




