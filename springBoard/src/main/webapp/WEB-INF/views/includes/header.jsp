<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="/">
    <i class='fas fa-smile' style='font-size:24px'></i>
  </a>
  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav mr-auto">
   	  <li class="nav-item">
        <a class="nav-link" href="/">HOME</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/article/article">게시판</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">준비중</a>
      </li>
      <c:if test="${not empty user}">
      <li class="nav-item">
        <a class="nav-link" href="/user/logout">로그아웃</a>
      </li></c:if>
      <c:if test="${empty user}">
      <li class="nav-item">
        <a class="nav-link" href="/user/loginForm">로그인</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/user/joinForm">회원가입</a>
      </li></c:if>
    </ul>
   </div>
</nav>