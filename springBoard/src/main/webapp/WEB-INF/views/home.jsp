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
<div class="container-fluid">

<div class="card my-4" style="max-width: 50rem;">
<div class="card-header">안녕하세요!</div>
<div class="card-body">
<h5 class="card-title">Spring Framework으로 회원가입, 로그인, 답글 게시판, 댓글 기능 등을 제작했습니다.</h5>
<p class="card-text"> - 회원가입(유효성검사, 아이디 중복 체크, 비밀번호 Bcrypt로 암호화)</p>
<p class="card-text"> - 로그인(interceptor), 로그아웃 (게시판은 로그인을 해야 접근 가능하도록 interceptor 처리)</p>
<p class="card-text"> - 계층형 게시판(답글, 댓글(ajax), page, 검색(제목or내용or작성자 검색, MyBatis 동적 SQL 활용))</p></div>
<div class="card-footer">제 이메일 주소는 gksl4157@naver.com 입니다.</div>
</div>

<c:if test="${not empty user}">
<div class="card my-3" style="max-width: 50rem;">
<div class="card-header">
<h2>${user.user_name}님 환영합니다.</h2>
</div>
<div class="card-body">
<h5 class="card-title">게시판을 자유롭게 이용 가능합니다.</h5></div>
<div class="card-footer"><a href="${pageContext.request.contextPath}/user/logout" class="card-link">로그아웃</a></div>
</div>
</c:if>

<c:if test="${empty user}">
<div class="card my-3" style="max-width: 50rem;">
<div class="card-header">
<h2>로그인이 필요합니다.</h2>
</div>
<div class="card-body">
<h5 class="card-title">게시판을 이용하려면 로그인이 필요합니다.</h5></div>
<div class="card-footer">
<a href="${pageContext.request.contextPath}/user/loginForm" class="card-link">로그인</a>
<a href="${pageContext.request.contextPath}/user/joinForm" class="card-link">회원가입</a></div>
</div>
</c:if> 

</div>
<script>
	var msg = "${msg}";
	if(msg === "joinSuccess") {
		alert("회원가입이 완료되었습니다.");
	}
</script>
<%@ include file="./includes/footer.jsp"%>
</body>
</html>