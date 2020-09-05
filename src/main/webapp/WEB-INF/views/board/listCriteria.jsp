<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath }/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath }/resources/css/heroic-features.css" rel="stylesheet">
<!-- <script src="http://code.jquery.com/jquery-latest.min.js"></script> -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#writeBtn").on("click", function(){
			location.href = "${pageContext.request.contextPath}/board/create";
			
		});
	});
	

</script>


<style>
.container-fluid{ 
 	padding-right: 0; 
	padding-left: 0; 
}

.jumbotron{
	margin-bottom: 0;
} 

</style>
</head>
<body>
<div class="container-fluid text-white">
	<div class="jumbotron jumbotron-fluid text-dark">
		<div class="container-fluid">
			<center>배너입니다</center>
		</div>
	</div>
	
	<div class="container-fluid bg-dark text-white">
		<table class="table table-dark table-bordered text-center">
			<thead>
				<tr>
					<th width="5%">글번호</th>
					<th width="50%">제목</th>
					<th width="25%">작성자</th>
					<th width="15%">작성일</th>
					<th width="5%">조회수</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${boardVO }"  var="vo">
				<tr>
					<td>${vo.bno }</td>
					<td><a href="${pageContext.request.contextPath }/board/read${pageMaker.makeQuery(pageMaker.cri.page)}&bno=${vo.bno}">${vo.title }</a></td>
					<td>${vo.writer }</td>
					<td><f:formatDate type="both" value="${vo.regDate }"  /></td>
					<td>${vo.viewCnt }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<div class="container" align="right">
			<button type="button" class="btn btn-primary" id="writeBtn">글쓰기</button>
		</div>

		<div class= "text-center">
			<ul class="pagination">
				
				<c:if test="${pageMaker.prev }">
					<li><a href="${pageContext.request.contextPath }/board/listCriteria?page=${pageMaker.startPage -1}">이전</a></li>
				</c:if>
				
				<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
				<li <c:out value="${pageMaker.cri.page == idx? 'class = active' : '' }"/>>
					<a href="${pageContext.request.contextPath }/board/listCriteria?page=${idx}">${idx}</a>
				</li>
				</c:forEach>
				
				<c:if test="${pageMaker.next && pageMaker.endPage > 0 }">
					<li><a href="${pageContext.request.contextPath }/board/listCriteria?page=${pageMaker.endPage +1}">다음</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</div>
</body>
</html>