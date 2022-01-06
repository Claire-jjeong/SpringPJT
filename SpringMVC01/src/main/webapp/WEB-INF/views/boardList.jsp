<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class = "container">
	<h2>Spring WEB MVC01</h2>
	<!--패널은 콘텐츠가 있는 박스 형태의 구성요소를 만들 때 사용  -->
	<div class = "panel panel-default">
	<div class = "panel-heading">SPRING BOARD</div>
	<div class = "panel-body">
		<table class = "table table-hover table-bordered">
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>작성일</td>
				<td>조회수</td>
			</tr>
			<c:forEach var = "vo" items = "${list}"> <!-- list안에 있는걸 가져오겠다 -->
			<tr>
				<td>${vo.idx}</td>
				<td><a href="boardContent.do?idx=${vo.idx}">${vo.title}</a></td> <!-- 제목 클릭 시 boardContent(상세보기)기 -->
				<td>${vo.writer}</td>
				<td>${vo.indate}</td>
				<td>${vo.count}</td>
			</tr>
			</c:forEach>
			<!-- 글쓰기 -->
			<tr>
				<td colspan ="5">							<!-- 글쓰기 버튼 클릭 시 해당 경로로 이동 -->
					<button class = "btn btn-primary btn-sm" onClick="location.href='boardInsertForm.do'">글쓰기</button>
					
				</td>
			</tr>
		</table>
	</div>
	<div class = "panel-footer">빅데이터 분석서비스 개발자과정 김정미</div>
	</div>
</div>

</body>
</html>