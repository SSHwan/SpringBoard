<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../includes/head.jsp"%>
<title>article</title>
</head>
<body>
<%@ include file="../includes/header.jsp"%>
<div class="container mb-5">

<form method="post">
	<input type="hidden" name="articleId" value="${article.articleId}">
	<input type="hidden" name="userId" value="${article.userId}">
	<input type="hidden" name="userName" value="${article.userName}">
	<input type="hidden" name="articleTitle" value="${article.articleTitle}">
	<input type="hidden" name="articleContent" value="${article.articleContent}">
	<input type="hidden" name="articleGroup" value="${article.articleGroup}">
	<input type="hidden" name="articleStep" value="${article.articleStep}">
	<input type="hidden" name="articleIndent" value="${article.articleIndent}">
<%-- 	<input type="hidden" name="searchType" value="${criteria.searchType}">
	<input type="hidden" name="keyword" value="${criteria.keyword}">
	<input type="hidden" name="page" value="${criteria.page}">
	<input type="hidden" name="articlePerPage" value="${criteria.articlePerPage}"> 
	submit타입에 formaction안에 makeQuery()로 URL을 만드니 searchType과 keyword이 두번 넘어감 
	없을경우 ','가 계속 붙음, 검색어가 'aa'일 경우 'aa,aa' 이런식  --%>
<div class="row pt-5 border-bottom">
<div class="col-2"></div>
<div class="col-1 p-3"><h4>${article.articleId}&nbsp;.</h4></div>
<div class="col p-2"><h3 class="mb-0 mt-1" style="height:100%;">${article.articleTitle}</h3></div>
<div class="col-2"></div>
</div>

<div class="d-flex justify-content-end my-2 p-2 mr-5">
<div class="p-1">이름 : ${article.userName}</div>
<div class="p-1">/</div>
<div class="p-1">조회수 : ${article.articleHit}</div>
<div class="p-1">/</div>
<div class="p-1"><fmt:formatDate value="${article.articleDate}" pattern="YYYY-MM-dd a HH:mm"/></div>
</div>
 <div class="border mx-5 mt-3 p-5" style="height: auto; min-height: 300px;">
 <p class="text-break" style="white-space: pre-line;">${article.articleContent}<p></div>
<!-- style="white-space: pre-line;" 줄바꿈 및 공백 처리 -->

<div class="row mx-5 mt-3 px-4 float-right">
<input type="submit" value="목록" class="btn btn-outline-secondary btn-sm" formaction="${pageContext.request.contextPath}/article/article${criteria.makeQuery()}">&nbsp;&nbsp;
<input type="submit" value="답변" class="btn btn-outline-secondary btn-sm" formaction="${pageContext.request.contextPath}/article/reply">&nbsp;&nbsp;
<c:if test="${user.user_id == article.userId}">
<input type="submit" value="수정" class="btn btn-outline-secondary btn-sm" formaction="${pageContext.request.contextPath}/article/modify">&nbsp;&nbsp;
<input type="submit" value="삭제" class="btn btn-outline-secondary btn-sm" formaction="${pageContext.request.contextPath}/article/delete${criteria.makeQuery()}&articleId=${article.articleId}">
</c:if>
</div>
</form>

</div><!-- end container -->

<div class="container my-5 py-5">
<div class="mx-5 p-5 border-top">
	<!-- <form> -->
	<div class="row justify-content-center align-items-center" style="height: 100px; background-color: rgba(255,0,0,0.1);">
		<div class="col-auto"><h4>댓글 작성</h4></div>
		<div class="col-6 py-2 h-auto">
			<textarea class="form-control" rows="2" id="newReply" placeholder="댓글을 작성해주세요." required></textarea>
		</div>
		
		<div class="col-auto"><button class="btn btn-outline-dark btn-lg" type="submit" id='addReplyBtn'>댓글 등록</button></div>
	</div>
	<!-- </form> -->
</div>
<div class="mx-5 px-5">
	<div>
		<ul class="replies mb-4">
			<!-- replies -->
		</ul>
	</div>
	<div class="pagination justify-content-center">
		<!-- pagination -->
	</div>
</div>
</div><!-- end reply container -->

	<!-- The Modal --> <!-- 댓글 모달 -->
  <div class="modal" id="replyModal">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h5 class="modal-title">댓글 수정하기</h5>
          <button type="button" class="close" data-dismiss="modal">×</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
   			<div class="form-group">
				<textarea class="form-control" rows="6" id="replyContent" name="text" style="white-space: pre-line;"></textarea>
			</div>
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
        	<button type="submit" class="modifyReplyBtn btn btn-primary">수정</button>
            <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
        </div>
        
      </div>
    </div>
  </div>
	<!-- /.Modal -->
	
	<script type="text/javascript" src="/resources/js/reply.js?ver=1"></script>
	<!-- '?ver=1' 수정된 js,css 파일이 적용이 안될때 해결방법 -->
	
	<script>
	$(document).ready(function() {
		var article_id = '<c:out value="${article.articleId}"/>';
		var user_id = '<c:out value="${user.user_id}"/>';
		var user_name = '<c:out value="${user.user_name}"/>';
		var replyUL = $(".replies"); //.은 class값이 replies일때
		showList(1);
		function showList(page) { // 댓글 리스트 출력
			console.log("show list " + page);
			replyService.getList({article_id:article_id,page:page||1}, function(list, pageMaker) {// 'page||1'이란 page 인자값이 있나? or 1
				var str="";
				if(list == null || list.length == 0) {
					replyUL.html("댓글이 없습니다.");
					return;
				}
				$(list).each(function () {
					str += "<li data-reply_id='"+this.reply_id+"'>";
					str += "<div><div class='header'><strong>"+this.user_name+"</strong>&emsp;";
					str += "<small><span>"+replyService.displayTime(this.reg_date)+"</small></span>";
					str += "<div class='float-right'><c:if test='${user_id == list[i].user_id}'>";
					str += "<button type='button' id='modifyReplyBtn' class='btn btn-outline-light btn-sm text-dark' data-toggle='modal' data-target='#replyModal'>수정</button>&emsp;";
					str += "<button type='button' id='removeReplyBtn' class='btn btn-outline-light btn-sm text-dark'>삭제</button>";
					str += "</c:if></div></div>";
					str += "<p class='reply_content mx-5 pr-5' style='white-space: pre-line;'>"+this.reply_content+"</p>";
					str += "</div></li>";
				});
				replyUL.html(str);
				showReplyPage(pageMaker);
			});
		}/* end showList */
		
			//엔터키로 댓글 등록, shift + enter로 줄바꿈
		/* $('#newReply').on('keydown', function(event) { 
	        if (event.keyCode == 13)
	            if (!event.shiftKey){
	                event.preventDefault();
	                $('#addReplyBtn').click();
	            }
	    }); */
		
		$("#addReplyBtn").on("click", function() {
		var reply_content = $("#newReply");			
			var reply = {
					reply_content: reply_content.val(),
					user_id: user_id,
					user_name: user_name,
					article_id: article_id
			};
			replyService.add(reply, function(result){
				alert("댓글이 등록되었습니다.");
				document.getElementById("newReply").value = "";
				showList(1);
			});
		});
		
	    var modal = $("#replyModal");
	    $(".replies").on("click", "#modifyReplyBtn", function() {
	    	var reply = $(this).closest("li");
	    	
	    	var reply_id = reply.attr("data-reply_id");
	    	var reply_content = reply.find(".reply_content").text();
	    	
	    	$("#replyContent").val(reply_content);
	    	modal.data("reply_id", reply_id);
	    });
	    
	    $(".replies").on("click", "#removeReplyBtn", function() {
	    	var reply = $(this).closest("li");
	    	
	    	var reply_id = reply.attr("data-reply_id");
	    	
	    	replyService.remove(reply_id, function(result){
	    		alert("댓글이 삭제되었습니다.");
	    		showList(pageNum);
	    	});
	    });

		$(".modifyReplyBtn").on("click", function() {
			var reply = {
					reply_id: modal.data("reply_id"),
					reply_content: modal.find("#replyContent").val()
			};
			replyService.update(reply, function(result){
				alert("댓글이 수정되었습니다.");
				modal.find("#replyContent").val("");
				modal.modal("hide");
				showList(pageNum);
			});
		});
		
		var pageNum = 1;
		function showReplyPage(pageMaker) {
			var str = "<ul class='pagination' id='pagination'>";
			if(pageMaker.prev) {
				str += "<li class='page-item'><a class='page-link' href='"+(pageMaker.startPage-1)+"'>이전</a></li>";
			}
			for(var i=pageMaker.startPage; i<= pageMaker.endPage; i++) {
				var active = pageMaker.criteria.page == i ? "active" : "";
				str += "<li class='page-item "+active+"'><a class='page-link' href='"+i+"'>"+i+"</a></li>";
			}
			if(pageMaker.next) {
				str += "<li class='page-item'><a class='page-link' href='"+(pageMaker.endPage+1)+"'>다음</a></li>";
			}
			str += "</ul>";
			$(".pagination").html(str);
		}
		
		$(".pagination").on("click", "li a", function(e) {
			e.preventDefault();
			console.log("page click");
			pageNum = $(this).attr("href");
			console.log("pageNum : " + pageNum);
			showList(pageNum);
		});

	});
	</script>
	
</body>
</html>