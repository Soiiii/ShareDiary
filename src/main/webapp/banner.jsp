<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 부트스트랩 CSS추가 -->
<link rel="stylesheet" href="./css/bootstrap.min.css">
<!-- 커스텀CSS추가 -->
<link rel="stylesheet" href="./css/custom.css">

<link href="./css/menu.css" rel="stylesheet">
<script type="text/javascript" src="./js/menu.js"></script>

<!--  메인베너 이미지 섹션  -->
<div id="banner">
	<div class="header">
		<img src="./img/main.png" style="width: 100%" />
	</div>
	
	<!-- Nav : 메뉴바 부분 -->
	<div class="navbar">
	<!--   네비게이션바를 이용하여 드롭다운 사용하면 넣을 구문 
    <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" id="dropdown" data-toggle="dropdown">-->
		<a href="./index.jsp" class="active">메인</a>
		<a href="./diaryView.jsp">일기장</a>
		<a href="./board">게시판</a>
		<a href="./odView.jsp">공유일기장</a>
		<!--  하트는 맨 오른쪽에 있는것. 관리자 메뉴일듯?-->
		<a href="#" class="right">❤</a>
	</div>
</div>