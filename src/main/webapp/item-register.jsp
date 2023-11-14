<%@ page import="model.entity.MakerBean"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品登録画面</title>
<link rel="stylesheet" href="assets/stylesheets/app.css">
<link rel="stylesheet"
	href="assets/stylesheets/object/projects/common/_header.css">
<link rel="stylesheet"
	href="assets/stylesheets/object/projects/_item-register/_item-register.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="main">
		<main>
			<h2 class="main__title">商品登録フォーム</h2>
			<c:if error="${not empty errorMessage}">
				<p class="main__errorMessage">${errorMessage}</p>
			</c:if>
			<form class=main__form action="item-register" method="post">
				<label for="itemName">商品名:</label> <input type="text"
					name="itemName" id="itemName" required><br> <label
					for="makerCode">メーカー:</label> <select name="makerCode"
					id="makerCode" required>
					<%
					List<MakerBean> records = (List<MakerBean>) request.getAttribute("records");
					for (MakerBean record : records) {
					%>
					<option value="<%=record.getMakerCode()%>"><%=record.getMakerName()%></option>
					<%
					}
					%>
				</select><br> <label for="price">価格(万円):</label> <input type="number"
					name="price" id="price" required><br> <input
					type="submit" value="商品登録確定">
			</form>
			<button class="main__backButton"
				onclick="location.href='${pageContext.request.contextPath}/login'">商品一覧へもどる</button>
		</main>
	</div>
</body>
</html>
