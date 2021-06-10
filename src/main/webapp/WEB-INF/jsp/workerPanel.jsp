<%@page pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet"  href="http://localhost:8080/css/style.css" />
</head>
<body>
	<header>
		<h2>Worker Panel</h2>
	</header>
	<section>
		${error}
		<br/>
		<form action = "save" method = "GET">
	         Id ksiażki: 
	         <select name="bookid">
		         <c:forEach items="${book}" var="book">
		    		<option value='${book.id}' >${book.id}</option>
				</c:forEach>
			</select>
	         <br/>
	         UI użytkownika: <input type="text" name="ui">
	         <br/>
	         Data zwrotu[RRRR-MM-DD]: <input type="text" name="date">
	         ${errDate}
	         <br/>
	         <input class="button" type = "submit" value = "Wypożycz"/>
	    </form>
	</section>
	
		<form action = "changeDate" method = "GET">
			${errDate2}
			 Nowa data[RRRR-MM-DD]<input type="text" name="newDate"/>
	         Id ksiażki: 
	         <select name="bookId">
		         <c:forEach items="${bBooks}" var="book">
		    		<option value='${book.bookID}' >${book.bookID}</option>
				</c:forEach>
			</select>
			
			<input class="button" type = "submit" value = "Zmień date"/>
		</form>
	    <br/>
	    <br/>
	<section>
		<form action = "checkUser" method = "GET">
	         Szukaj po UI: <input type="text" name="ui">
	         <br/>
	         <input class="button" type = "submit" value = "Szukaj"/>
	    </form>
	</section>
	<br/>
	<br/>
	<nav>
		<a href="/welcome">Wróć</a>
	</nav>
</body>
</html>