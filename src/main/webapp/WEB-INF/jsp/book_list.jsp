<%@page pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="http://localhost:8080/css/style.css" />
</head>
<body>
	<header>
		<h2>Spis książek</h2>
	</header>
	<section>
		<form action = "search" method = "GET">
	         Tytuł: <input type="text" name="title">
	         <br/>
	         <input class="button" type = "submit" value = "Szukaj"/>
	      </form>
	     <form action = "all">
	         <input class="button" type = "submit" value = "Wyczyść filtrowanie"/>
	     </form>
     </section>
     <section>
		<table>
			<th>     
			<form action = "order" method="POST">
					<input type="hidden" name="order" value="title">
		         <input class="button" type = "submit" value = "Tytuł"/>
		     </form>
		    </th>
			<th>
			<form action = "order" method="POST">
					<input type="hidden" name="order" value="author">
		         <input class="button" type = "submit" value = "Autor"/>
		     </form>
			</th>
			<th>
			<form action = "order" method="POST">
					<input type="hidden" name="order" value="year">
		         <input class="button" type = "submit" value = "Rok"/>
		     </form>
			</th>
			<th>
			<form action = "order" method="POST">
					<input type="hidden" name="order" value="status">
		         <input class="button" type = "submit" value = "Dostępna"/>
		     </form>
			</th>
			<c:forEach items="${books}" var="book">
		    <tr>      
		        <td>${book.title}</td>
		        <td>${book.author}</td>
		        <td>${book.year}</td>
		        <td>
			        <c:choose>
					  <c:when test="${book.status eq true}">
						Tak
					  </c:when>
					  <c:when test="${book.status eq false}">
						Nie
					  </c:when>
					</c:choose>
		        </td>
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