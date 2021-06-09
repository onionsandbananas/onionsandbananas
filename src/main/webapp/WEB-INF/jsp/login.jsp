<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
	<header> 
		<h2>Biblioteka</h2>
	</header>
	<section>
		<form action = "login_check" method="POST">
	   		Login: <input type="text" name="login">
	   		<br/>
	    	Hasło: <input type="password" name="password">
	    	<br/>
	    	<input class="button" type = "submit" value="Login"/>
	    </form>
	<br/>
	</section>
	<nav>
   		<a id="noLogin" href="welcome">Kontynuuj bez logowania</a>
    </nav>
</body>
</html>