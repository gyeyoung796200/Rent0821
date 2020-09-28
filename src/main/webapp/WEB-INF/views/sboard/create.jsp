<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath }/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath }/resources/css/heroic-features.css" rel="stylesheet">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
$(document).ready(function(){
	
	$("#listBtn").on("click", function(){
		location.href="${pageContext.request.contextPath}/sboard/listCriteria";
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
	
	<div class="container-fluid bg-dark">
	
	<div class="container bg-dark">
		<form role="form" action="${pageContext.request.contextPath }/sboard/create" method="post" >
		<input type="hidden" name="page" value="${cri.page }">
		<input type="hidden" name="perPageNum" value="${cri.perPageNum }"> 
		
		 
		 <div class="form-group">
	      <label for="uname">제목</label>
	      <input type="text" class="form-control" id="utitle" placeholder="Enter title" name="title">
	    </div>
		
	    <div class="form-group">
	      <label for="uname">작성자</label>
	      <input type="text" class="form-control" id="uname" placeholder="Enter username" name="writer">
	    </div>
	    
	      <div class="form-group">
	      <label for="uname">내용</label>
	      <textarea rows="20" cols="20" class="form-control" placeholder="enter content" name="content"></textarea>
	    </div>
	    
	    <button type="submit" class="btn btn-primary">확인</button>
	    <button type="reset" class="btn btn-danger">취소</button>
	    <button type="button" class="btn btn-default text-white" id="listBtn">목록</button>
	  </form>
	</div>
</div>
</div>
</body>
</html>