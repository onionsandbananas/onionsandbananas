<%@page pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>


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
         <input type = "submit" value = "Wypożycz"/>
    </form>
    <br/>
    <br/>
	<form action = "checkUser" method = "GET">
         Szukaj po UI: <input type="text" name="ui">
         <br/>
         <input type = "submit" value = "Szukaj"/>
    </form>
</body>
</html>