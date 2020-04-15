<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../includes/head.jsp"%>
<title>article</title>
</head>
<body>
<%@ include file="../includes/header.jsp"%>
<div class="container my-5 pb-5">
<div class="d-flex bd-highlight mb-3" style="padding-top:20px">
  <div class="p-2 bd-highlight"><h3>자유 게시판</h3></div>
  <div class="ml-auto p-2 bd-highlight"><a class="btn btn-primary" href="/article/articleWrite" role="button">글작성</a></div>
</div>
<table class="table">
<thead>
<tr class="table-info">
	<th>번호</th>
	<th>작성자</th>
	<th>제목</th>
	<th>조회수</th>
	<th>날짜</th>
</tr>
</thead>
<c:forEach items="${list}" var="dto">
<tr>
	<td>${dto.articleId}</td>
	<td>${dto.userName}</td>
	<td>
	<c:forEach begin="1" end="${dto.articleIndent}">
  	<c:out value="▶" />
 	</c:forEach>
	<a href="${pageContext.request.contextPath}/article/articleView${pageMaker.criteria.makeQuery()}&articleId=${dto.articleId}">${dto.articleTitle}</a>
	</td>
	<td>${dto.articleHit}</td>
	<td><fmt:formatDate value="${dto.articleDate}" pattern="YYYY-MM-dd a HH:mm"/></td>
</tr>
</c:forEach>
</table>
<form id="actionForm">
	<input type="hidden" name="page" value="${pageMaker.criteria.page}">
	<input type="hidden" name="articlePerPage" value="${pageMaker.criteria.articlePerPage}">
	<input type="hidden" name="searchType" value="${pageMaker.criteria.searchType}">
	<input type="hidden" name="keyword" value="${pageMaker.criteria.keyword}">
</form>
<div>
	<ul class="pagination justify-content-center">
		<c:if test="${pageMaker.prev}">
			<li class="page-item to begin">
				<a class="page-link" href="1">◀◀</a>
			</li>
		</c:if>
		<c:if test="${pageMaker.prev}">
			<%-- <li class="paginate_button previous"><a href="${pageContext.request.contextPath}/article/article?page=${pageMaker.startPage-1}">이전</a></li>
			<a href="${pageContext.request.contextPath}/article/article${pageMaker.makeQuery(pageMaker.startPage-1)}">이전</a> --%>
			<li class="page-item previous">
				<a class="page-link" href="${pageMaker.startPage-1}">◀</a>
			</li>
		</c:if>
		<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
			<%-- <li class="paginate_button"><a href="${pageContext.request.contextPath}/article/article?page=${num}">${num}</a></li>
			<a href="${pageContext.request.contextPath}/article/article${pageMaker.makeQuery(num)}">${num}</a> --%>
			<li class="page-item ${pageMaker.criteria.page == num ? "active" : ""}">
				<a class="page-link" href="${num}">${num}</a>
			</li>
		</c:forEach>
		<c:if test="${pageMaker.next}">
			<%-- <li class="paginate_button next"><a href="${pageContext.request.contextPath}/article/article?page=${pageMaker.endPage+1}">다음</a></li>
			<a href="${pageContext.request.contextPath}/article/article${pageMaker.makeQuery(pageMaker.endPage+1)}">다음</a> --%>
			<li class="page-item next">
				<a class="page-link" href="${pageMaker.endPage+1}">▶</a>
			</li>
		</c:if>
		<c:if test="${pageMaker.next}">
			<li class="page-item to end">
				<a class="page-link" href="${pageMaker.realEnd}">▶▶</a>
			</li>
		</c:if>
	</ul>
</div>

<div>
<form class="form-inline justify-content-center" id='searchForm' action="${pageContext.request.contextPath}/article/article${criteria.makeQuery()}" method="get">
<div class="input-group col-auto">
  <select name='searchType'>
	<option value="${pageMaker.criteria.searchType == null?'selected':''}">--</option>
	<option value="T"${pageMaker.criteria.searchType eq 'T'?'selected':''}>제목</option>
	<option value="C"${pageMaker.criteria.searchType eq 'C'?'selected':''}>내용</option>
	<option value="W"${pageMaker.criteria.searchType eq 'W'?'selected':''}>작성자</option>
	<option value="TC"${pageMaker.criteria.searchType eq 'TC'?'selected':''}>제목 or 내용</option>
	<option value="TW"${pageMaker.criteria.searchType eq 'TW'?'selected':''}>제목 or 작성자</option>
	<option value="TWC"${pageMaker.criteria.searchType eq 'TWC'?'selected':''}>제목 or 내용 or 작성자</option>
  </select>
  <input type='text' name='keyword' value='${pageMaker.criteria.keyword}' class="form-control"/>
  <input type='hidden' name='page' value='${pageMaker.criteria.page}'>
  <input type='hidden' name='articlePerPage' value='${pageMaker.criteria.articlePerPage}'>
  <button class="btn btn-outline-secondary">검색</button>
</div>
</form>
</div>
</div>
<script src="<c:url value="https://code.jquery.com/jquery-3.2.1.min.js" />"></script>
<script type="text/javascript">
$(document).ready(function() {
 	var actionForm = $("#actionForm");
	$(".page-item a").on("click", function(e) {
		e.preventDefault();
		actionForm.find("input[name='page']").val($(this).attr("href"));
		actionForm.submit();
	});
	
	var searchForm = $("#searchForm");
	$("#searchForm button").on("click", function(e) {
		if(!searchForm.find("input[name='keyword']").val()){
			alert("검색어를 입력하세요.");
			window.location.href = "${pageContext.request.contextPath}/article/article";
			return false;
		}
		if(!searchForm.find("option:selected").val()){
			alert("검색 종류를 선택하세요.");
			return false;
		}
		searchForm.find("input[name='page']").val("1");
		e.preventDefault();
		searchForm.submit();
	});
});
</script>
<%@ include file="../includes/footer.jsp"%>
</body>
</html>