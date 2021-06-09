<%@page pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

<table>
	<c:forEach items="${users}" var="user">
    <tr>      
        <td>${user.id}</td>
        <td>${user.ui}</td>
        <td>${user.role}</td>
    </tr>
	</c:forEach>
</table>
${error}
<form action="changeRole" method="GET">
	ID: <input type="text" name="id"/>${errId}
	<select name="changeRole">
	    <option value="user" >user</option>
	    <option value="worker" >worker</option>
	    <option value="admin" >admin</option>
	</select>
	<input type="submit" value="Zmień"/>
</form>
	
	<br/>
	
    <br/>
    <br/>
	<form action = "checkUser" method = "GET">
         Szukaj po UI: <input type="text" name="ui">
         <br/>
         <input type = "submit" value = "Szukaj"/>
    </form>

</body>
</html>