<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
<link rel="stylesheet" href="assets/stylesheets/app.css">
<link rel="stylesheet"
	href="assets/stylesheets/object/projects/common/_header.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="main">
		<main>
			<h2>商品管理システム</h2>
			<button
				onclick="location.href='${pageContext.request.contextPath}/item-register'">商品登録</button>
		</main>
	</div>
</body>
</html>
