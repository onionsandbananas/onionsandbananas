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
		<h2>Admin panel</h2>
	</header>
	<section>
		<form action = "panel" method = "GET">
	         <input class="button" type = "submit" value = "Odswież"/>
	    </form>	
	</section>
		<form action = "getUser" method = "GET">
	         Szukaj(UI): <input type="text" name="ui">
	         <br/>
	         <input class="button" type = "submit" value = "Szukaj"/>
	    </form>
	<section>
		<table>
			<th>ID</th>
			<th>UI</th>
			<th>
				<form action="usersByRole">
					<input class="button" type="submit" value="Rola"/>
				</form>
			</th>
			<c:forEach items="${users}" var="user">
			    <tr>
			        <td>${user.id}</td>
			        <td>${user.ui}</td>
			        <td>${user.role}</td>
			    </tr>
			</c:forEach>
		</table>
	</section>${error}
	<section>
		
		<form action="changeRole" method="GET">
			ID: <input type="text" name="id"/>${errId}
			<select name="changeRole">
			    <option value="user" >user</option>
			    <option value="worker" >worker</option>
			    <option value="admin" >admin</option>
			</select>
			<input class="button" type="submit" value="Zmień"/>
		</form>
	</section>
		<br/>
	    <br/>
	    <br/>
	<section>
		<form action = "deleteUser" method = "GET">
	         Usuń(ID): <input type="text" name="id">
	         <br/>
	         <input class="button" type = "submit" value = "Usuń"/>
	    </form>
	</section>
	<br/>
	<br/>
	<nav>
		<a href="/welcome">Wróć</a>
	</nav>
</body>
</html>