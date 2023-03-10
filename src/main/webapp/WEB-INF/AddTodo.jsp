<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="./../css/main.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<main>
		<div>
			<span>
				<h1>Todo Form</h1>
			</span>
			<form action="/REST/todos" method="post">
				<input type="text" placeholder="Title..." name="title"> <select
					name="completed" id="">
					<option value="true">true</option>
					<option value="false">false</option>
				</select>
				<div>
					<button type="submit">add</button>
					<button type="reset">reset</button>
				</div>
			</form>
		</div>
	</main>
	<jsp:include page="../footer.jsp" />
</body>
</html>