<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix = "fn" %> <!-- 함수사용 -->
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang ="en" >
<head>
<meta charset="UTF-8">
<title>Bootstrap Example</title>
	<meta name ="viewport" content = "width=device-width, initial-scale = 1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  	function goDelete(idx){
  		location.href="${cpath}/boardDelete.do?idx="+idx;
  	}
  	function goUpdate(idx){
  		location.href="${cpath}/boardUpdate.do/${vo.idx}";
  	}
  </script>
</head>
<body>

<div class = "container">
	<h2>Spring WEB MVC01</h2>
	<div class = "panel panel-default">
	<div class = "panel-heading">SPRING BOARD</div>
	<div class = "panel-body">
		<table b class = "table table-bordered">
			<tr>
				<td>제목</td>
				<td>${vo.title}</td> <!-- addAttribute의 vo에서 정보 가져오기 -->			
			</tr>
			<%pageContext.setAttribute("newLineChar","\n"); %>
			<tr>
				<td>내용</td>
				<td>${fn:replace(vo.contents,newLineChar,"<br>")}</td> 
			</tr>
			<tr>
				<td>작성자</td>
				<td>${vo.writer}</td> 
			</tr>
			<tr>
				<td>작성일</td>
				<td>${fn:split(vo.indate," ")[0]}</td> <!-- 일자만 표기 -->
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button class = "btn btn-primary btn-sm" onClick="goUpdate(${vo.idx})">수정</button>
					<button class = "btn btn-danger btn-sm" onClick="goDelete(${vo.idx})">삭제</button>
					<button class = "btn btn-success btn-sm" onClick="location.href='${cpath}/boardList.do'">리스트</button>
				</td>
			</tr>
		</table>
	</div>
	<div class = "panel-footer">빅데이터 분석서비스 개발자과정 김정미</div>
	</div>
</div>

</body>
</html>