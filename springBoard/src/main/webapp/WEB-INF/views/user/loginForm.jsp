<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../includes/head.jsp"%>
</head>
<body>
<%@ include file="../includes/header.jsp"%>
<div class="container">
<div align="center" class="m-5">
<h1>로그인</h1>
</div>
<hr style="color: black;" /><br>
<form
         method="POST"
         action="${pageContext.request.contextPath}/user/login">

	<div class="form-row m-4">
		<div class="d-flex col-sm-4 justify-content-end">
    		<label for="user_id">ID : </label>
    	</div>
      <div class="col-sm-4">
      	<input class="form-control" name="user_id" id="user_id" autofocus="autofocus" required/>
      </div>
    </div>
	<div class="form-row m-4">
		<div class="d-flex col-sm-4 justify-content-end">
    		<label for="user_pw">PASSWORD : </label>
    	</div>
      <div class="col-sm-4">
      	<input class="form-control" type="password" name="user_pw" id="user_pw" required/>
      </div>
    </div>
    <div class="form-row m-2">
    <div class="col-sm-5"></div>
	<input class="btn btn-primary" type="submit" value="로그인">&nbsp;&nbsp;&nbsp;&nbsp;
	<input class="btn btn-secondary" type="button" value="돌아가기" onclick="history.back()">
	</div>
</form>
</div>
</body>
</html>