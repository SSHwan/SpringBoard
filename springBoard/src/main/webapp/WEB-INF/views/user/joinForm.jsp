<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../includes/head.jsp"%>
<title>Insert title here</title>
<script>
	function checkInput() {
		var f = document.joinForm;
		if(f.user_pw.value != f.user_pw_check.value) {
			alert('비밀번호가 일치하지 않습니다');
			return false;
		}else if(flag == false){
			alert("ID 중복체크를 해주세요!");
			return false;
		} else if(flag == true) {
			if(f.user_id.value != validID){
				console.log("validID : " + user_id);
				console.log("id : " + document.joinForm.user_id.value);
				console.log("f.user_id.value : " + f.user_id.value);
				
				alert("중복확인 후 ID가 바뀌었습니다. 다시 중복체크를 해주세요!");
				return false;
			}
		}
		else {
			document.joinForm.submit();
		}
	}
</script>
<script type="text/javascript">
$(document).ready(function() {
	// 중복체크를 위한 FLAG
	flag = false;
	//validID = "";
	
	// 리스너 등록
	$("#id_Check").on("click", function() {
		user_id = $("#user_id").val();
		console.log(user_id);
		
		// AJAX CALL
		$.ajax({
			url: "${pageContext.request.contextPath}/user/userIdCheck",
			type: "post",
			data: {user_id: user_id},
			dataType: "json",
			success: function(result){
				console.log(result);
				
				if(result < 0) {
					alert("ID를 입력해주세요.");
					flag = false;
				} else if(result === 1){
					alert("이미 가입되어 있는 아이디 입니다.");
					flag = false;
				} else {
					alert("사용 가능한 아이디 입니다.");
					flag = true;
					validID = user_id;
					console.log("validID : " + user_id);
					console.log("id : " + document.joinForm.user_id.value);
				}
			},
			error: function(xhr, status, error){
				alert("error");
			}
		});	
	});
});
	//비밀번호 확인
	$(function(){
        $("#alert-success").hide();
        $("#alert-fail").hide();
        $("input").keyup(function(){
            var pw=$("#user_pw").val();
            var pw_check=$("#user_pw_check").val();
            if(pw != "" || pw_check != ""){
                if(pw == pw_check){
                    $("#alert-success").show();
                    $("#alert-fail").hide();
                }else{
                    $("#alert-success").hide();
                    $("#alert-fail").show();
                }    
            }
        });
    });
	
</script>
</head>
<body>
<%@ include file="../includes/header.jsp"%>

<div class="container">
<div align="center" class="m-5">
<h1>회원가입</h1>
</div>
<hr style="color: black;" /><br>
<form:form name="joinForm"
         modelAttribute="userDto"
         method="POST"
         action="${ pageContext.servletContext.contextPath }/user/join"
         onsubmit="return checkInput()">

	<div class="form-row m-3">
		<div class="d-flex col-sm-4 justify-content-end">
    		<label for="user_id">ID : </label>
    	</div>
      <div class="col-sm-4">
      	<input class="form-control" name="user_id" id="user_id" value="${userDto.user_id }" required/>
      	<form:errors class="text-danger" path="user_id"/>
      </div>
      <div class="col-sm-4 text-danger">
      	<input class="btn btn-light" type="button" id="id_Check" value="아이디 중복체크">
      </div>
    </div>
    <div class="form-row m-3">
		<div class="d-flex col-sm-4 justify-content-end">
    		<label for="user_pw">PASSWORD : </label>
    	</div>
      <div class="col-sm-4">
      	<input class="form-control" type="password" name="user_pw" id="user_pw" required/>
      	<%-- <form:errors class="text-danger" path="user_pw"/> --%>
      	<!-- <small id="passwordHelpInline" class="text-muted">
      Must be 8-20 characters long.
    </small>  패스워드 양식 알려주기! -->
      </div>
      <div class="col-sm-4 text-danger">
      	<form:errors path="user_pw"/>
      </div>
    </div>
    <div class="form-row m-3" >
		<div class="d-flex col-sm-4 justify-content-end">
    		<label for="user_pw_check">PASSWORD 확인 : </label>
    	</div>
      <div class="col-sm-4">
      	<input class="form-control" type="password" name="user_pw_check" id="user_pw_check" required/>
      </div>
      <div class="col-sm-4 text-danger">
      	<div class="text-success" id="alert-success">비밀번호가 일치합니다.</div>
		<div class="text-danger" id="alert-fail">비밀번호가 일치하지 않습니다.</div>
      </div>
    </div>
    <div class="form-row m-3">
		<div class="d-flex col-sm-4 justify-content-end">
    		<label for="user_name">이름 : </label>
    	</div>
      <div class="col-sm-4">
      	<input class="form-control" path="user_name" name="user_name" value="${userDto.user_name }" required/>
      	<%-- <form:errors class="text-danger" path="user_name"/> --%>
      </div>
      <div class="col-sm-4 text-danger">
      	<form:errors path="user_name" />
      </div>
    </div>
    <div class="form-row m-3">
		<div class="d-flex col-sm-4 justify-content-end">
    		<label for="user_email">이메일 : </label>
    	</div>
      <div class="col-sm-4">
      	<input class="form-control" path="user_email" name="user_email" value="${userDto.user_email }" required/>
      	<%-- <form:errors class="text-danger" path="user_email"/> --%>
      </div>
      <div class="col-sm-4 text-danger">
      	<form:errors path="user_email" />
      </div>
    </div>
    <div class="form-row m-2">
    <div class="col-sm-5"></div>
	<input class="btn btn-primary" type="submit" value="가입하기">&nbsp;&nbsp;&nbsp;&nbsp;
	<input class="btn btn-secondary" type="button" value="돌아가기" onclick="history.back()">
	</div>
</form:form>
</div>
</body>
</html>