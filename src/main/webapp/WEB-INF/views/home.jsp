<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"%>
<html>
<head>
<link href="${pageContext.request.contextPath }/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath }/resources/css/heroic-features.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Home</title>
 <style>
  /* Make the image fully responsive */
  .carousel-inner img {
    width: 100%;
    height: 100%;
  }
  </style>
</head>
<body>
	<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="${pageContext.request.contextPath }/">RentCarShop</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          
          <li class="nav-item">
            <a class="nav-link" href="#">차량목록</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">예약확인</a>
          </li>
          
          <li class="nav-item">
          	<a class="nav-link" href="#">회원가입</a>
          </li>
			
		  <li class="nav-item">
          	<a class="nav-link" href="#">로그인</a>
          </li>
          
          <li class="nav-item">
          	<a class="nav-link" href="${pageContext.request.contextPath }/board/create">글작성</a>
          </li>
          
          <li class="nav-item">
          	<a class="nav-link" href="${pageContext.request.contextPath }/board/list">게시판</a>
          </li>
          
          <li class="nav-item">
          	<a class="nav-link" href="${pageContext.request.contextPath }/board/listCriteria">게시판 페이징</a>
          </li>
          
          <li class="nav-item">
          	<a class="nav-link" href="${pageContext.request.contextPath }/sboard/listCriteria">검색기능 게시판 페이징</a>
          </li>
          
          
        </ul>
      </div>
    </div>
  </nav>
  
  <c:if test="${center == null }">
	 
  <div id="demo" class="carousel slide" data-ride="carousel">
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="${pageContext.request.contextPath }/resources/carouselIMG/p1.jpg" alt="Los Angeles" width="1100" height="500">
      <div class="carousel-caption">
        <h3>Los Angeles</h3>
        <p>We had such a great time in LA!</p>
      </div>   
    </div>
    <div class="carousel-item">
      <img src="${pageContext.request.contextPath }/resources/carouselIMG/p2.jpg" alt="Chicago" width="1100" height="500">
      <div class="carousel-caption">
        <h3>Chicago</h3>
        <p>Thank you, Chicago!</p>
      </div>   
    </div>
    <div class="carousel-item">
      <img src="${pageContext.request.contextPath }/resources/carouselIMG/p3.jpg" alt="New York" width="1100" height="500">
      <div class="carousel-caption">
        <h3>New York</h3>
        <p>We love the Big Apple!</p>
      </div>   
    </div>
  </div>
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
</div>
  </c:if>
  
  
  
  
  <div>
	<c:if test="${center != null }">
		<jsp:include page="${center }"/>
	</c:if>
  </div>
  
  

<!-- Bootstrap core JavaScript -->
  <script src="${pageContext.request.contextPath }/resources/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath }/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
