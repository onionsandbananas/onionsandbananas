<%@page pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="http://localhost:8080/css/style.css" />
</head>
<body>
	<header>
		<h2>Historia użytkownika(${ui})</h2>
	</header>
	<section>
		<table>
			<th>ID</th>
			<th>Tytuł</th>
			<th>Status</th>
			<th>Data</th>
			<c:forEach var="i" begin="0" end="${fn:length(book)}">
		    <tr>      
		        <td>${book[i].id}</td>
		        <td>${book[i].title}</td>
		        <td>${borrow[i].status}</td>
		        <td>${borrow[i].date}</td>
		    </tr>
			</c:forEach>
		</table>
	</section>
	<br/>
	<br/>
	<nav>
		<a href="/welcome">Wróć</a>
	</nav>
</body>
</html>