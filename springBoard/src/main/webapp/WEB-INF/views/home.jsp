<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./includes/head.jsp"%>
<title>Home</title>
</head>
<body>
<%@ include file="./includes/header.jsp"%>
<div class="container">
<h1> Hello world! </h1>
<P> The time on the server is ${serverTime}. </P>
<p> destination is "${destination}" </p>

<c:if test="${not empty user}">
<p>${user.user_id}</p>
<p>${user.user_name}님 환영합니다.</p>

<p><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></p>
</c:if>

<c:if test="${empty user}">
<p>로그인해주세요.</p>
<p><a href="${pageContext.request.contextPath}/user/loginForm">로그인</a>
&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/user/joinForm">회원가입</a>
</p>
</c:if>
</div>

<br/><br/>
<p>interceptor 방식</p>
<p><a href="${pageContext.request.contextPath}/userPage">회원 페이지</a>&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/adminPage">관리자 페이지</a></p><br>
<p>메뉴</p>
<p><a href="${pageContext.request.contextPath}/article/article">게시판</a>&nbsp;&nbsp;
</p>

<script>
	var msg = "${msg}";
	if(msg === "joinSuccess") {
		alert("회원가입이 완료되었습니다.");
	}
</script>
<%@ include file="./includes/footer.jsp"%>
</body>
</html>