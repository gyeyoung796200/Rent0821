<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
$(document).ready(function(){

	var formObj = $("form[role='form']");
	
	
	$("#modifyBtn").click(function(){
		
		formObj.attr("action", "${pageContext.request.contextPath}/board/modify");
		formObj.attr("method", "post");
		formObj.submit();
	});
	
// 	$("#cancelBtn").click(function(){
		
// 		formObj.attr("action", "${pageContext.request.contextPath}/board/read");
// 		formObj.attr("method", "get");
// 		formObj.submit();
// 	});	
	
	$("#listBtn").click(function(){
		
		formObj.attr("action", "${pageContext.request.contextPath}/board/listCriteria");
		formObj.attr("method", "get");
		formObj.submit();
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
			<center>����Դϴ�</center>
		</div>
	</div>
	
	<div class="container-fluid bg-dark">
	
	<div class="container bg-dark">
		<form role="form" class="needs-validation">
		 <input type="hidden" name="bno" value="${boardVO.bno }">
		 <input type="hidden" name="page" value="${cri.page }">
		 <input type="hidden" name="perPageNum" value="${cri.perPageNum }">
		 
		 <div class="form-group">
	      <label for="uname">�۹�ȣ</label>
	      <input type="text" class="form-control" id="utitle" name="bno" value="${boardVO.bno }" readonly="readonly">
	    </div>
		 
		 
		 <div class="form-group">
	      <label for="uname">����</label>
	      <input type="text" class="form-control" id="utitle" name="title" value="${boardVO.title }">
	    </div>
		
	    <div class="form-group">
	      <label for="uname">�ۼ���</label>
	      <input type="text" class="form-control" id="uname"  name="writer" value="${boardVO.writer }" readonly="readonly">
	    </div>
	    
	      <div class="form-group">
	      <label for="uname">����</label>
	      <textarea rows="20" cols="20" class="form-control" name="content">${boardVO.content }</textarea>
	    </div>
	    
	    <button type="submit" class="btn btn-primary" id="modifyBtn">Ȯ��</button>
	    <button type="button" class="btn btn-danger" onclick="history.back();" id="cancelBtn">���</button>
	    <button type="button" class="btn btn-danger" id="listBtn">���</button>
	  </form>
	</div>
</div>
</div>	
</body>
</html>