<%@page import="org.eclipse.jdt.internal.compiler.impl.ITypeRequestor"%>
<%@page import="com.estf.todo.beans.Todo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="../css/main.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<main>
		<div>
			<%
			List<Todo> todos = (List<Todo>) request.getAttribute("todos");
			%>
			<span>
				<h1>Todo Form</h1>
			</span>
			<%
			if (todos != null) {
			%>
			<table>
				<thead>
					<tr>
						<th>id</th>
						<th>title</th>
						<th>completed</th>
						<th>options</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Todo todo : todos) {
					%>
					<tr>
						<td><%=todo.getId()%></td>
						<td><%=todo.getTitle()%></td>
						<td><%=todo.getCompleted()%></td>
						<td><a href="deleteTodo?id">X</a></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
			<%
			}
			%>
		</div>
	</main>
	<jsp:include page="../footer.jsp" />
</body>
</html>