<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="assets/stylesheets/app.css">
<link rel="stylesheet"
	href="assets/stylesheets/object/projects/_login/_login.css">
</head>
<body>
	<div class="main">
		<main>
			<div class="main__logoOuter">
				<img class="main__logoInner" src="assets/images/seassist_logo.png"
					alt="ロゴ">
			</div>
			<h2 class="main__title">商品管理システム</h2>
			<c:if error="${not empty errorMessage}">
				<p class="main__errorMessage">${errorMessage}</p>
			</c:if>
			<form action="login" method="post">
				<label for="id">ユーザーID</label><br> <input type="text" name="id"
					id="id"><br> <label for="password">パスワード</label><br>
				<input type="password" name="password" id="password"><br>
				<br> <input type="submit" value="ログイン">
			</form>
		</main>
	</div>
</body>
</html>
