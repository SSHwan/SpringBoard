<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../includes/head.jsp"%>
<title>Insert title here</title>
</head>
<body>
<%@ include file="../includes/header.jsp"%>
<div class="container mb-5">

<form method="post">
	<input type="hidden" name="userId" value="${user.user_id}">
	<input type="hidden" name="userName" value="${user.user_name}">
<div class="row pt-5 border-bottom">
<div class="col-2"></div>
<div class="col-1 p-3"><h4>제목</h4></div>
<div class="col p-3"><input type="text" name="articleTitle" style="width:100%;height:100%;font-size:30px;" required></div>
<div class="col-2"></div>
</div>

<div class="d-flex justify-content-end my-2 p-2 mr-5">
<div class="p-1">이름 : ${user.user_name}</div>
</div>
 <div class="border mx-5 mt-3 p-5" style="height: auto; min-height: 500px;">
 <textarea class="form-control" name="articleContent" style="width:100%;height:100%;min-height: 500px;" required></textarea>
 </div>
<!-- style="white-space: pre-line;" 줄바꿈 및 공백 처리 -->

<div class="row mx-5 mt-3 px-4 float-right">
<input type="submit" value="작성" class="btn btn-outline-secondary btn-sm" formaction="${pageContext.request.contextPath}/article/createArticle">&nbsp;&nbsp;
<input type="button" value="취소" class="btn btn-outline-secondary btn-sm" onclick="history.back()">&nbsp;&nbsp;
</div>
</form>
</div><br><br><br><br><br>
</body>
</html>