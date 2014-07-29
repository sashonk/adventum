<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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

<div class="left"></div>
<div class="right"></div>
<div class="content">
	<div class="menu public"><a href="help.html">Help</a></div>
	<div class="menu public"><a href="public/public.html">Public</a></div>	
	<div class="menu public"><a href="private/gallery.html">Gallery</a></div>	
	<sec:authorize access="hasRole('manager') or hasRole('admin')">
		<div class="menu private"><a href="admin/personal.html">User control</a></div>	
	</sec:authorize>
</div>


	
<jsp:include page="foot.jsp" />
</div>
</body>
</html>