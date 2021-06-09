<%@page pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
Historia użytkownika(${ui})
<table>
	<th>ID</th>
	<th>Tytuł</th>
	<th>Status</th>
	<th>Data</th>
	<c:forEach var="i" begin="0" end="${end}">
    <tr>      
        <td>${book[i].id}</td>
        <td>${book[i].title}</td>
        <td>${borrow[i].status}</td>
        <td>${borrow[i].date}</td>
    </tr>
	</c:forEach>
</table>
</body>
</html>