<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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
			location.href = "${pageContext.request.contextPath}/sboard/create"+"${pageMaker.makeQuery(1)}";
			
		});
		
		$("#searchBtn").on("click", function(){
			
			self.location ="${pageContext.request.contextPath}/sboard/listCriteria"
																+"${pageMaker.makeQuery(1)}"
																+"&searchType="
																+$("select option:selected").val()
																+"&keyWord="
																+$("#keyWordInput").val();
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
			<c:forEach items="${boardVO }"  var="vo" varStatus="status" >
				<tr>
<%-- 					<td>${vo.bno }</td> --%>
<%-- 					<td>${rownum}</td> --%>
<%-- 					<td>${fn:length(boardVO)-status.index }</td> --%>
					<td>${(totalCount - status.index) - ( (cri.page - 1)  *  cri.perPageNum ) }
					<td><a href="${pageContext.request.contextPath }/sboard/read${pageMaker.makeSearch(pageMaker.cri.page)}&bno=${vo.bno}">${vo.title }</a></td>
					<td>${vo.writer }</td>
					<td><f:formatDate type="both" value="${vo.regDate }"  /></td>
					<td>${vo.viewCnt }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<div class="container" align="right">
		
		
			<select name="searchType" >
				<option value="n" 
					<c:out value="${cri.searchType == null ? 'selected' : ''}" />></option>
				<option value="t"
					<c:out value="${cri.searchType eq 't' ? 'selected' : '' }" />>제목</option>
				<option value="c"
					<c:out value="${cri.searchType eq 'c' ? 'selected' : '' }" />>내용</option>
				<option value="w"
					<c:out value="${cri.searchType eq 'w' ? 'selected' : ''}"  />>작성자</option>
				<option value="tc"
					<c:out value="${cri.searchType eq 'tc' ? 'selected' : ''}" />>제목+내용</option>
				<option value="cw"
					<c:out value="${cri.searchType eq 'cw' ? 'selected' : ''}" />>내용+작성자</option>
				<option value="tcw"
					<c:out value="${cri.searchType eq 'tcw' ? 'selected' : ''}" />>제목+내용+작성자</option>
			</select>
		
			<input type="text" name="keyWord" id="keyWordInput" value="${cri.keyWord }" >
			<button type="button" id="searchBtn">검색</button>
			<button type="button" id="writeBtn">글쓰기</button>
		</div>

		<div class= "text-center">
			<ul class="pagination">
				
				<c:if test="${pageMaker.prev }">
					<li><a href="${pageContext.request.contextPath }/sboard/listCriteria${pageMaker.makeSearch(pageMaker.startPage -1)}">이전</a></li>
				</c:if>
				
				<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
				<li <c:out value="${pageMaker.cri.page == idx? 'class = active' : '' }"/>>
					<a href="${pageContext.request.contextPath }/sboard/listCriteria${pageMaker.makeSearch(idx)}">${idx}</a>
				</li>
				</c:forEach>
				
				<c:if test="${pageMaker.next && pageMaker.endPage > 0 }">
					<li><a href="${pageContext.request.contextPath }/sboard/listCriteria${pageMaker.makeSearch(pageMaker.endPage +1)}">다음</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</div>
</body>
</html>