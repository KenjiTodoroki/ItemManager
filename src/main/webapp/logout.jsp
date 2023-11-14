<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト画面</title>
<link rel="stylesheet" href="assets/stylesheets/app.css">
<link rel="stylesheet"
	href="assets/stylesheets/object/projects/_logout/_logout.css">
</head>
<body>
	<div class="main">
		<main>
			<h1 class="main__title">${id}さん ログアウトしました</h1>
			<button onclick="location.href='${pageContext.request.contextPath}/'">ログイン画面へ</button>
		</main>
	</div>
</body>
</html>
