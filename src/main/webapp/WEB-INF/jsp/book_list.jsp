<%@page pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<form action = "search" method = "GET">
         Title: <input type="text" name="title">
         <br/>
         <input type = "submit" value = "Szukaj"/>
      </form>
     <form action = "all">
         <input type = "submit" value = "Wyczyść filtrowanie"/>
     </form>
<table>
	<th>     
	<form action = "order" method="POST">
			<input type="hidden" name="order" value="title">
         <input type = "submit" value = "Tytuł"/>
     </form>
    </th>
	<th>
	<form action = "order" method="POST">
			<input type="hidden" name="order" value="author">
         <input type = "submit" value = "Autor"/>
     </form>
	</th>
	<th>
	<form action = "order" method="POST">
			<input type="hidden" name="order" value="year">
         <input type = "submit" value = "Rok"/>
     </form>
	</th>
	<th>
	<form action = "order" method="POST">
			<input type="hidden" name="order" value="status">
         <input type = "submit" value = "Dostępna"/>
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
</body>
</html>