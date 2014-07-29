<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
<div id="container">

<jsp:include page="../head.jsp" />

<div class='content'>
	<div class="img"><img src="../resources/1.jpg" /></div>
	<div class="img"><img src="../resources/2.jpg" /></div>
	<div class="img"><img src="../resources/3.jpg" /></div>
	
	
	<sec:authorize access="hasRole('manager')">
	<div class="img manager"><img src="../resources/4.jpg" /></div>
	<div class="img manager"><img src="../resources/5.jpg" /></div>
	<div class="img manager"><img src="../resources/6.jpg" /></div>	
	</sec:authorize>
	
	<div class="clear"></div>					
	<div class="back">	<a href="../index.html">на главную</a></div>	
</div>


<jsp:include page="../foot.jsp" />
</div>
</body>
</html>